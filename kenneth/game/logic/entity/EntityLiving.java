package kenneth.game.logic.entity;

import kenneth.game.logic.ActionObjects;
import kenneth.game.logic.Point3D;

public abstract class EntityLiving extends Entity implements ActionObjects {

	//Health damage thread? it would sleep for a little bit once attacked
	
	public abstract void update();

	public abstract void setPosition(Point3D pos);

}
