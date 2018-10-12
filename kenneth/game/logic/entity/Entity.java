package kenneth.game.logic.entity;

import kenneth.game.logic.Point3D;
import kenneth.game.logic.entity.hitbox.Hitbox;

/**Anything that goes on the map is a subclass*/
public abstract class Entity {

	protected String identifier;
	
	protected Point3D pos; //central point of object
	
	protected Hitbox hb;
	
	/**Entity/Tile ID*/
	protected static String name;
	
	/**Can be passed through without effect to object passing through it (ActionTiles)<hr/>
	 * Layout for z axis on map 
	 * <ul>
	 * 	<li>0 - objects sit
	 * 	<li>1 - ethereal objects sit
	 * 	<li>2 - next floor
	 * <ul>
	 * */
	protected boolean isEthereal = false;
	
	public Point3D getPos() {
		return pos;
	}
	
	public String getObjectName() {
		return name;
	}
	
	/**To test if movement should be prevented (Collision should still be tested)*/
	public boolean isSolid() {
		return !isEthereal;
	}
	
	public Hitbox getHitbox() {
		return hb;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Entity) {
			Entity ent = (Entity) obj;
			if (this.identifier.equals(ent.identifier)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		
		s = name + ": " + pos;
		
		return s;
	}
}
