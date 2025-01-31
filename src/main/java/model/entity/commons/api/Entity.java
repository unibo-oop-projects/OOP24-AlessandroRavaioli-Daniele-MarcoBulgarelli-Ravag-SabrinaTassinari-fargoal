package model.entity.commons.api;

import commons.api.*;
import model.FloorElement;

public interface Entity extends FloorElement{
    
    Integer getHealth();

    Position getPosition();

    Integer getSkill();

}
