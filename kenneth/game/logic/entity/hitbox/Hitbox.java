package kenneth.game.logic.entity.hitbox;

import kenneth.game.logic.Point3D;

public abstract class Hitbox {

	/**Used to store all the points for the hit box
	 * <br><br>
	 * <i>Since I'm using a large scaled grid system, it is likely that it will be impossible to make a clean circle</i>
	 * 
	 * */
	protected Point3D[] points;
	
	public Hitbox() {
		this.generate();
	}
	
	public Point3D[] getHitboxPoints() {
		return points;
	}
	
	protected abstract void generate();

	public abstract void reGenerate(Point3D pos);
}
