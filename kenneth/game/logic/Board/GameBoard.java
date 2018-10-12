package kenneth.game.logic.Board;

import java.util.HashMap;

import kenneth.game.logic.Point3D;
import kenneth.game.logic.entity.Entity;


/**Stores the location of all the objects within a "location."
 * <br>
 * Uses nested maps for this
 * */
public class GameBoard {

	HashMap<String, HashMap<Point3D, Entity>> Locations = new HashMap<>(); //eventually will shift string to a Location.class abstract/interface
	
	HashMap<Point3D, Entity> LocationObjects = null;
	
	String location;
	
	public GameBoard() {
		Locations.put("default", new HashMap<Point3D, Entity>());
	}
	
	public void loadLocation(String loc) {
		if (LocationObjects != null) {
			updateLocationMap();
		}
		LocationObjects = Locations.get(loc);
		location = loc;
	}
	
	public boolean isPointOccupied(Point3D pos) {
		return LocationObjects.containsKey(pos);
	}
	
	/**Tests for single point collisions, and stores ent in that pos<br>
	 * <br>
	 * Better to use hitbox version*/
	public Entity setObjectLocation(Point3D pos, Entity obj) {
		
		if (isPointOccupied(pos)) {
			return getObjectAtLocation(pos);
		} else {
			LocationObjects.put(pos, obj);
			return obj;
		}
		
	}
	
	/**Tests for entire hitbox, and stores the ent value in all of it's hitbox values*/
	public Entity setObjectLocation(Point3D[] hitbox, Entity obj) {
		
		for (Point3D pos : hitbox) {
			if (isPointOccupied(pos)) {
				return getObjectAtLocation(pos);
			} else {
				LocationObjects.put(pos, obj);
				return obj;
			}
		}
		return null;
		
	}
	
	private void updateLocationMap() {
		Locations.put(location, LocationObjects);
	}
	
	public Entity getObjectAtLocation(Point3D pos) {
		return LocationObjects.get(pos);
	}
}