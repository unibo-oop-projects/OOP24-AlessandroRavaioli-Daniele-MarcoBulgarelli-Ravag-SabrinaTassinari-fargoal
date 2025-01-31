package fargoal.model.entity.commons.api;

import fargoal.api.Position;
import fargoal.model.FloorElement;

public interface Entity extends FloorElement{
    
    Integer getHealth();

    Position getPosition();

    Integer getSkill();

}
