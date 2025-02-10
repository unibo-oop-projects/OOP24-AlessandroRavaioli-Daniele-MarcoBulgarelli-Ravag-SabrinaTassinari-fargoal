package fargoal.model.interactable.temple;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.WalkOverEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * This class implements the temple of the floor.
 * In the temple the player can not be attacked and he can donate 
 * the gold he has to gain experience (as much experience as the gold he has).
 * If the player has donated more than 2000 gold he is blessed: all his health is 
 * restored.
 */
public class Temple implements Interactable {

    final private Position position;
    private Renderer renderer;
    private Position lastPlayerPosition;

    /**
     * This is the constructor of the class. It set the position of the temple.
     * @param position - the position of the temple.
     * @param renderFactory - - a factory to create the renderer of all the elements of the floor.
     */
    public Temple(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.setRender(renderFactory.templeRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.getPlayer().addExperiencePoints(floorManager.getPlayer().getCurrentGold());
        floorManager.getPlayer().getPlayerGold().setGoldDonated(floorManager.getPlayer().getPlayerGold().getGoldDonated() + floorManager.getPlayer().getCurrentGold());
        if (floorManager.getPlayer().getPlayerGold().getGoldDonated() >= 2000) {
            floorManager.getPlayer().getHealth().setHealth(floorManager.getPlayer().getHealth().getMaxHealth());
            floorManager.getPlayer().getPlayerGold().setGoldDonated(0);
        }
        floorManager.getPlayer().getPlayerGold().resetGold();
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "TEMPLE";
    }

    /** {@inheritDoc} */
    @Override
    public void render() {
        this.renderer.render();
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        if (floorManager.getPlayer().getPosition().equals(this.position)) {
            floorManager.getPlayer().setIsImmune(true);
            this.interact(floorManager);
            if (!floorManager.getPlayer().getPosition().equals(this.lastPlayerPosition)) {
                floorManager.notifyFloorEvent(new WalkOverEvent(this));
            }
        } else {
            floorManager.getPlayer().setIsImmune(false);
        }
        this.lastPlayerPosition = floorManager.getPlayer().getPosition();
    }
    
}
