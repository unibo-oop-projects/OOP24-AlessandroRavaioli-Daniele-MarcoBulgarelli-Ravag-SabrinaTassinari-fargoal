package fargoal.model.entity.commons.api;

import fargoal.commons.api.Position;
import fargoal.model.FloorElement;

public interface Entity extends FloorElement{
    
    public Integer getHealth();

    public Position getPosition();

    public Integer getSkill();
}
