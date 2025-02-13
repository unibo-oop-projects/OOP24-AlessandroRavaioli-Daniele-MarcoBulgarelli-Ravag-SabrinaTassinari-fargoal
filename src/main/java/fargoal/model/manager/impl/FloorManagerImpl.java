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
import fargoal.model.interactable.pickupable.inside_chest.impl.ChestImpl;
import fargoal.model.interactable.pickupable.on_ground.SackOfMoney;
import fargoal.model.interactable.pickupable.on_ground.SwordOfFargoal;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.interactable.stair.impl.DownStairs;
import fargoal.model.interactable.stair.impl.UpStairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.api.FloorMask;
import fargoal.model.map.impl.FloorGeneratorImpl;
import fargoal.model.map.impl.FloorMaskImpl;
import fargoal.view.api.RenderFactory;
import fargoal.view.impl.InventoryInformationRenderer;
import fargoal.view.impl.PlayerInformationRenderer;
import fargoal.view.impl.RenderEventListener;
import fargoal.view.impl.SwingRenderFactory;
import fargoal.model.interactable.temple.Temple;

/**
 * A class that implements the entirety of the floor and all its elements.
 */
public class FloorManagerImpl implements FloorManager {

    private static final int MINIMUM_NUMBER_OF_GOLD_SPOTS = 6;
    private static final int MAX_MONSTERS = 7;
    private static final int MAX_NUMBER_OF_TREASURES = 25;
    private static final int FIXED_NUMBER_OF_STAIRS = 2;
    private static final int VARIABLE_NUMBER_OF_STAIRS = 2;
    private static final int TIME_TO_WAIT_ON_EVENT = 1000;
    private static final int MINIMUM_SWORD_LEVEL = 15;
    private static final int VARIABLE_SWORD_LEVEL = 6;

    private final RenderEventListener listener;
    private final List<Monster> monsters;
    private final Player player;
    private final FloorMask mask;
    private final List<Interactable> interactables;
    private final RenderFactory renderFactory;
    private final Timer timer;
    private FloorMap map;
    private int floorLevel;
    private MonsterFactory monstFact;
    private Temple temple;

    private long elapsed;
    private final SwordOfFargoal sword;
    private boolean isOver;
    private String endText;

    /**
     * Constructor that inizializes all of its fields.
     * @param engine - the GameEngine in which the program runs {@link GameEngine}
     */
    public FloorManagerImpl(final GameEngine engine) {
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
        this.isOver = false;
        initializeFloor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameEngine engine) {
        this.elapsed = engine.getElapsedTime();
        //Try to generate a monster, i don't need it to be guaranteed
        if (this.monsters.size() < MAX_MONSTERS) {
            generateMonster(this.interactables.stream()
                    .filter(in -> in instanceof Stairs)
                    .findAny().get().getPosition());
            Collections.shuffle(this.interactables);
        }
        if (timer.updateTime(this.elapsed) == 0) {
            if (isOver) {
                this.setSceneManager(engine);
            }
            if (this.player.isFighting()) {
                this.player.update(this);
            } else {
                this.getAllElements().forEach(e -> e.update(this));
                this.sword.update(this);
            }
            this.player.getInventory().getListAllSpell().forEach(s -> s.update(this));
        } else {
            this.listener.render();
        }
        this.mask.update(this);
        if (this.player.isDead()) {
            isOver = true;
            endText = "GAME OVER";
        }
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

    /**
     * {@inheritDoc}
     */
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
        final List<FloorElement> elements = new LinkedList<>(this.interactables);
        elements.add(this.temple);
        elements.add(this.player);
        elements.addAll(this.monsters);
        return elements;
    }

    /** 
     * {@inheritDoc}
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
        this.floorLevel--;
        if (this.floorLevel == 0 && this.player.hasSword()) {
            this.isOver = true;
            this.endText = "YOU WIN";
        } else if (this.floorLevel <= 0) {
            throw new  IllegalStateException("cannot go to level -1");
        } else  {
            initializeFloor();
            this.interactables.add(new DownStairs(this.player.getPosition(), this.renderFactory));
        }
    }

    private void initializeFloor() {
        this.map = new FloorGeneratorImpl().createFloor(this);
        this.mask.resetMask();
        this.monsters.clear();
        this.interactables.clear();
        this.player.move(this.map.getRandomTile());
        this.monstFact = new MonsterFactoryImpl(this.floorLevel);
        while (this.monsters.size() < MAX_MONSTERS) {
            generateMonster(this.map.getRandomTile());
        }

        final int goldSpots = new Random().nextInt(4) + MINIMUM_NUMBER_OF_GOLD_SPOTS;
        final int treasures = Math.min(MAX_NUMBER_OF_TREASURES, new Random().nextInt(this.floorLevel) + 3);
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

        final int downStair = new Random().nextInt(VARIABLE_NUMBER_OF_STAIRS) + FIXED_NUMBER_OF_STAIRS;
        while (this.interactables.size() < downStair + goldSpots + treasures) {
            generateStairs(new DownStairs(new Position(0, 0), renderFactory));
        }
        if (this.floorLevel != 1 || this.player.hasSword()) {
            final int upStair = new Random().nextInt(VARIABLE_NUMBER_OF_STAIRS) + FIXED_NUMBER_OF_STAIRS;
            while (this.interactables.size() < downStair + upStair + goldSpots + treasures) {
                generateStairs(new UpStairs(new Position(0, 0), renderFactory));
            }
        }

        if (this.player.getInventory()
                .getListOfMaps()
                .getListOfMaps().contains(this.floorLevel)) {
            this.mask.clearMask();
        }

        if (this.floorLevel == sword.getMapLevel() && !this.player.hasSword()) {
            do {
                sword.setPosition(this.map.getRandomTile());
            } while (this.interactables.stream()
                    .anyMatch(in -> in.getPosition().equals(this.sword.getPosition()))
                    || this.temple.getPosition().equals(this.sword.getPosition()));
            this.interactables.add(sword);
        }
    }

    private void generateMonster(final Position pos) {
        boolean alreadyPresent = false;
        final Monster tempMonster = monstFact.generate(pos, this, renderFactory);
        if (this.monsters.stream().anyMatch(m -> m.getPosition().equals(pos))
                || this.player.getPosition().equals(pos)
                || tempMonster.areNeighbours(this, 4)) {
            alreadyPresent = true;
        }
        if (!alreadyPresent) {
            this.monsters.add(tempMonster);
        }
    }

    private void generateItems() {
        boolean alreadyPresent;
        do {
            final Position pos = this.map.getRandomTile();
            final Interactable temp = new ChestImpl(pos, this.renderFactory);
            alreadyPresent = false;
            if (this.interactables.stream().anyMatch(in -> in.getPosition().equals(pos))
                    || this.player.getPosition().equals(pos)) {
                        alreadyPresent = true;
                    }
            if (!alreadyPresent) {
                this.interactables.add(temp);
            }
        } while (alreadyPresent);
    }

    private void generateGold() {
        boolean alreadyPresent;
        do {
            final Position pos = this.map.getRandomTile();
            final SackOfMoney temp = new SackOfMoney(pos, this.renderFactory);
            alreadyPresent = false;
            if (this.interactables.stream().anyMatch(in -> in.getPosition().equals(pos))
                    || this.player.getPosition().equals(pos)) {
                alreadyPresent = true;
            }
            if (!alreadyPresent) {
                this.interactables.add(temp);
            }
        } while (alreadyPresent);
    }

    private void generateStairs(final Stairs type) {
        boolean alreadyPresent;
        do {
            final Position pos = this.map.getRandomTile();
            final Stairs temp = type instanceof DownStairs
                    ? new DownStairs(pos, this.renderFactory)
                    : new UpStairs(pos, this.renderFactory);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyFloorEvent(final FloorEvent floorEvent) {
        listener.notifyEvent(floorEvent);
        timer.setTime(TIME_TO_WAIT_ON_EVENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTimePassed() {
        return this.elapsed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSceneManager(final GameEngine engine) {
        engine.setSceneManager(new GameOverManager(engine, endText));
    }

    /** {@inheritDoc} */
    @Override
    public void setIsOver(final boolean isOver) {
        this.isOver = isOver;
        endText = "TOO LATE";
    }
}
