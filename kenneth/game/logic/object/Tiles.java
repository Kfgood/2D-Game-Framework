package kenneth.game.logic.object;

import kenneth.game.logic.Point3D;
import kenneth.game.logic.entity.Entity;

public class Tiles {
	
	public Tiles() {
		this.createObjects();
	}
	
	private void createObjects() {
		
	}
	
	public Tile obj() {
		return new Tile(new Point3D(1,1,1));
	}
	
}

class Tile extends Entity{
	
	static {
		Tile.name = "Tile";
	}
	
	public Tile(Point3D pos) {
		
	}
	
	@Override
	public String toString() {
		String s = "";
		
		s = name + ":" + pos;
		
		return s;
	}	
}