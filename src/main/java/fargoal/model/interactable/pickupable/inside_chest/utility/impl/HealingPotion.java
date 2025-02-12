package fargoal.model.interactable.pickupable.inside_chest.utility.impl;

import java.util.Random;

import fargoal.model.events.impl.PlayerActionEvent;
import fargoal.model.interactable.pickupable.inside_chest.utility.api.AbstractUtility;
import fargoal.model.interactable.pickupable.inside_chest.utility.api.UtilityType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements an Healing Potion, which the player found in a chest.
 * It heal the player, incresing his health.
 */
public class HealingPotion extends AbstractUtility {

    private static final int N_HEALING_POTION_TO_START = 1;
    private static final int MAX_HIT_POINTS_TO_ADD = 19;

    /**
     * This is the constructor of the class. It store right away the item the player found in a chest.
     */
    public HealingPotion() {
        this.setNumberInInventory(N_HEALING_POTION_TO_START);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.HEALING_POTION.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void effect(final FloorManager floorManager) {
        int healthToAdd = new Random().nextInt(MAX_HIT_POINTS_TO_ADD) + 3 * floorManager.getPlayer().getLevel();
        int healthToSet = floorManager.getPlayer().getHealth().getCurrentHealth() + healthToAdd;
        floorManager.notifyFloorEvent(new PlayerActionEvent(this));
        if (healthToSet >= floorManager.getPlayer().getHealth().getMaxHealth()) {
            floorManager.getPlayer().getHealth().setHealth(floorManager.getPlayer().getHealth().getMaxHealth());
        } else {
            floorManager.getPlayer().getHealth().setHealth(healthToSet);
        }
        this.removeUtility();
    }

    /** {@inheritDoc} */
    @Override
    public void addToPlayer() {
    } 
}
