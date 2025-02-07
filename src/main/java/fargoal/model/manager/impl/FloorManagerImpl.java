package fargoal.model.manager.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.entity.player.api.Player;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.impl.ChestImpl;
import fargoal.model.interactable.pickUpAble.onGround.SackOfMoney;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;

/**
 * A class that implements the entirety of the floor and all its elements.
 */
public class FloorManagerImpl implements FloorManager {

    private static final int MAX_MONSTERS = 7;
    private static final int MAX_NUMBER_OF_TREASURES = 25;

    private FloorMap map;
    private List<Monster> monsters;
    private Player player;
    private final FloorMask mask;
    private int floorLevel;
    private List<Interactable> items;
    private MonsterFactory monstFact;

    /**
     * Constructor that inizializes all of its fields.
     * @param context - the structure in which the reference to the view is contained
     */
    public FloorManagerImpl(final GameContext context) {
        this.monsters = new LinkedList<>();
        this.mask = new FloorMaskImpl(context.getView());
        this.floorLevel = 1;
        this.items = new LinkedList<>();
        initializeFloor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameContext context) {
        List<FloorElement> elements = new LinkedList<>();
        elements.addAll(this.monsters);
        elements.add(player);
        elements.addAll(items);
        elements.forEach(e -> e.update(this));
        this.mask.update(context, this);
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
    public List<Interactable> getItems() {
        return this.items;
    }

    /**
     * {@inheritDOc}
     */
    @Override
    public void increaseFloorLevel() {
        this.floorLevel++;
        initializeFloor();
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
    }

    private void initializeFloor() {
        this.map = new FloorConstructorImpl().createFloor();
        this.mask.resetMask();
        this.monsters.clear();
        this.items.clear();
        this.player = new PlayerImpl(map);
        this.monstFact = new MonsterFactoryImpl(this.floorLevel);
        while (this.monsters.size() < MAX_MONSTERS) {
            generateMonster();
        }
         int goldSpots = new Random().nextInt(4) + 6;
        int treasures = Math.min(MAX_NUMBER_OF_TREASURES, new Random().nextInt(this.floorLevel-1) + 3);
        while (this.items.size() < goldSpots) {
            generateGold();
        }
        while (this.items.size() < goldSpots + treasures) {
            generateItems();
        } 
    }

    private void generateMonster() {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            alreadyPresent = false;
            for (int i = 0; i < this.monsters.size(); i++) {
                if (this.monsters.get(i).getPosition().equals(pos)) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                this.monsters.add(monstFact.generate(pos, this.map, this));
            }
        } while (alreadyPresent);
    }
    
    private void generateItems() {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            Interactable temp = new ChestImpl(pos);
            alreadyPresent = false;
            for (int i = 0; i < this.items.size(); i++) {
                if (this.items.get(i).getPosition().equals(pos)) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                this.items.add(temp);
            }
        } while (alreadyPresent);
    }

    private void generateGold() {
        boolean alreadyPresent = false;
        do {
            Position pos = this.map.getRandomTile();
            SackOfMoney temp = new SackOfMoney(pos);
            alreadyPresent = false;
            for (int i = 0; i < this.items.size(); i++) {
                if (this.items.get(i).getPosition().equals(pos)) {
                    alreadyPresent = true;
                }
            }
            if (!alreadyPresent) {
                this.items.add(temp);
            }
        } while (alreadyPresent);
    }    
}
