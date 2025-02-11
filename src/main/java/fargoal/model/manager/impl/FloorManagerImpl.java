package fargoal.model.manager.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.model.commons.Timer;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.entity.player.api.Player;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.impl.ChestImpl;
import fargoal.model.interactable.pickUpAble.onGround.SackOfMoney;
import fargoal.model.interactable.pickUpAble.onGround.SwordOfFargoal;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.interactable.stair.impl.DownStairs;
import fargoal.model.interactable.stair.impl.UpStairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.manager.api.SceneManager;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;
import fargoal.view.api.RenderFactory;
import fargoal.view.impl.InventoryInformationRenderer;
import fargoal.view.impl.PlayerInformationRenderer;
import fargoal.view.impl.RenderEventListener;
import fargoal.view.impl.SwingRenderFactory;
import fargoal.model.interactable.temple.Temple;

/**
 * A class that implements the entirety of the floor and all its elements.
 */
public class FloorManagerImpl implements FloorManager, SceneManager {

    private static final int MAX_MONSTERS = 7;
    private static final int MAX_NUMBER_OF_TREASURES = 25;
    private static final int FIXED_NUMBER_OF_STAIRS = 2;
    private static final int VARIABLE_NUMBER_OF_STAIRS = 2;
    private static final int TIME_TO_WAIT_ON_EVENT = 1500;
    private static final int MINIMUM_SWORD_LEVEL = 15;
    private static final int VARIABLE_SWORD_LEVEL = 6;

    private final RenderEventListener listener;
    private FloorMap map;
    private List<Monster> monsters;
    private Player player;
    private final FloorMask mask;
    private int floorLevel;
    private List<Interactable> interactables;
    private MonsterFactory monstFact;
    private Temple temple;
    private final RenderFactory renderFactory;
    private final Timer timer;
    private long elapsed;
    private final SwordOfFargoal sword;

    /**
     * Constructor that inizializes all of its fields.
     * @param context - the structure in which the reference to the view is contained
     */
    public FloorManagerImpl(GameEngine engine) {
        this.listener = new RenderEventListener(engine.getView());
        this.monsters = new LinkedList<>();
        this.mask = new FloorMaskImpl();
        this.floorLevel = 1;
        this.interactables = new LinkedList<>();
        this.renderFactory = new SwingRenderFactory(engine.getView());
        this.timer = new Timer();
        this.player = new PlayerImpl(this,
                engine.getController(),
                new PlayerInformationRenderer(engine.getView()),
                new InventoryInformationRenderer(engine.getView()));
        this.sword = new SwordOfFargoal(renderFactory,
                new Random().nextInt(VARIABLE_SWORD_LEVEL) + MINIMUM_SWORD_LEVEL);
        initializeFloor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(GameEngine engine) {
        this.elapsed = engine.getElapsedTime();
        //Try to generate a monster, i don't need it to be guaranteed
        if (this.monsters.size() < MAX_MONSTERS) {
            generateMonster(this.interactables.stream()
                    .filter(in -> in instanceof Stairs)
                    .findAny().get().getPosition());
            Collections.shuffle(this.interactables);
        }
        if (timer.updateTime(this.elapsed) == 0) {
            this.getAllElements().forEach(e -> e.update(this));  
            this.player.getInventory().getListAllSpell().forEach(s -> s.update(this)); 
        } else {
            this.listener.render();
        }
        this.mask.update(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Monster> getMonsters() {
        return this.monsters;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FloorMap getFloorMap() {
        return this.map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFloorLevel() {
        return this.floorLevel;
    }

    @Override
    public FloorMask getFloorMask() {
        return this.mask;
    }

    /** {@inheritDoc} */
    @Override
    public List<Interactable> getInteractables() {
        return this.interactables;
    }

    /** {@inheritDoc} */
    @Override
    public Temple getTemple() {
        return this.temple;
    }

    /** {@inheritDoc} */
    @Override
    public RenderFactory getRenderFactory() {
        return this.renderFactory;
    }

    /** {@inheritDoc} */
    @Override
    public List<FloorElement> getAllElements() {
        List<FloorElement> elements = new LinkedList<>(this.interactables);
        elements.add(this.temple);
        elements.add(this.player);
        elements.addAll(this.monsters);
        return elements;
    }

    /**
     * {@inheritDOc}
     */
    @Override
    public void increaseFloorLevel() {
        this.floorLevel++;
        initializeFloor();
        this.interactables.add(new UpStairs(this.player.getPosition(), this.renderFactory));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreaseFloorLevel() {
        if (this.floorLevel <= 0) {
            throw new  IllegalStateException("cannot go to level -1");
        }
        this.floorLevel--;
        initializeFloor();
        this.interactables.add(new DownStairs(this.player.getPosition(), this.renderFactory));
    }

    private void initializeFloor() {
        this.map = new FloorConstructorImpl().createFloor(this.renderFactory);
        this.mask.resetMask();
        this.monsters.clear();
        this.interactables.clear();
        this.player.setPosition(this.map.getRandomTile());
        this.monstFact = new MonsterFactoryImpl(this.floorLevel);
        while (this.monsters.size() < MAX_MONSTERS) {
            generateMonster(this.map.getRandomTile());
        }

        int goldSpots = new Random().nextInt(4) + 6;
        int treasures = Math.min(MAX_NUMBER_OF_TREASURES, new Random().nextInt(this.floorLevel) + 3);
        while (this.interactables.size() < goldSpots) {
            generateGold();
        }
        while (this.interactables.size() < goldSpots + treasures) {
            generateItems();
        } 

        do {
            this.temple = new Temple(this.map.getRandomTile(), this.renderFactory);
        } while (this.interactables.stream().anyMatch(item -> item.getPosition().equals(this.temple.getPosition())) 
                || this.player.getPosition().equals(this.temple.getPosition()));

        int downStair = new Random().nextInt(VARIABLE_NUMBER_OF_STAIRS) + FIXED_NUMBER_OF_STAIRS;
        while (this.interactables.size() < downStair + goldSpots + treasures) {
            generateStairs(new DownStairs(new Position(0, 0), renderFactory));
        }
        if (this.floorLevel != 1 || this.player.hasSword()) {
            int upStair = new Random().nextInt(VARIABLE_NUMBER_OF_STAIRS) + FIXED_NUMBER_OF_STAIRS;
            while (this.interactables.size() < downStair + upStair + goldSpots + treasures) {
                generateStairs(new UpStairs(new Position(0, 0), renderFactory));
            }
        }

        if (this.player.getInventory()
                .getListOfMaps()
                .getListOfMaps().contains(this.floorLevel)) {
            this.mask.clearMask();
        }

        if (this.floorLevel == sword.getMapLevel()) {
            do {
                sword.setPosition(this.map.getRandomTile());
            } while (this.interactables.stream()
                    .anyMatch(in -> in.getPosition().equals(this.sword.getPosition()))
                    || this.temple.getPosition().equals(this.sword.getPosition()));
        }
    }

    private void generateMonster(Position pos) {
        boolean alreadyPresent = false;
        alreadyPresent = false;
        for (int i = 0; i < this.monsters.size(); i++) {
            if (this.monsters.get(i).getPosition().equals(pos) || pos.equals(this.player.getPosition())) {
                alreadyPresent = true;
            }
        }
        if (!alreadyPresent) {
            this.monsters.add(monstFact.generate(pos, this.map, this, renderFactory));
        }
    }
    
    private void generateItems() {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            Interactable temp = new ChestImpl(pos, this.renderFactory);
            alreadyPresent = false;
            for (int i = 0; i < this.interactables.size(); i++) {
                if (this.interactables.get(i).getPosition().equals(pos) || this.player.getPosition().equals(pos)) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                this.interactables.add(temp);
            }
        } while (alreadyPresent);
    }

    private void generateGold() {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            SackOfMoney temp = new SackOfMoney(pos, this.renderFactory);
            alreadyPresent = false;
            for (int i = 0; i < this.interactables.size(); i++) {
                if (this.interactables.get(i).getPosition().equals(pos) || this.player.getPosition().equals(pos)) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                this.interactables.add(temp);
            }
        } while (alreadyPresent);
    }    

    private void generateStairs(Stairs type) {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            Stairs temp = (type instanceof DownStairs
                    ? new DownStairs(pos, this.renderFactory)
                    : new UpStairs(pos, this.renderFactory));
            alreadyPresent = false;
            if (this.interactables.stream().anyMatch(item -> item.getPosition().equals(pos))
                    || this.player.getPosition().equals(pos)
                    || this.temple.getPosition().equals(pos)) {
                alreadyPresent = true;
            }
            if (!alreadyPresent) {
                this.interactables.add(temp);
            }
        } while (alreadyPresent);
    }

    @Override
    public void notifyFloorEvent(FloorEvent floorEvent) {
        listener.notifyEvent(floorEvent);
        timer.setTime(TIME_TO_WAIT_ON_EVENT);
    }

    @Override
    public long getTimePassed() {
        return this.elapsed;
    }

    @Override
    public void setSceneManager(GameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSceneManager'");
    }
}
