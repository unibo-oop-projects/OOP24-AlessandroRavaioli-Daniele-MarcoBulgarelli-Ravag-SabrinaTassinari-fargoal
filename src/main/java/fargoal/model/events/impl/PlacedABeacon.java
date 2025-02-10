package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class PlacedABeacon implements FloorEvent {
    
    private final FloorElement beaconOnGround;

    public PlacedABeacon(FloorElement beaconOnGround) {
        this.beaconOnGround = beaconOnGround;
    }

    public FloorElement getWhatPlaced() {
        return this.beaconOnGround;
    }

}
