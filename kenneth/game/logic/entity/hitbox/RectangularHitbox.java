package kenneth.game.logic.entity.hitbox;

import kenneth.game.logic.Point3D;

public class RectangularHitbox extends Hitbox {

	int height, width;
	
	Point3D pos;
	
	public RectangularHitbox(Point3D pos, int width, int height) {
		
		this.pos = new Point3D(pos);
		
		this.height = height;
		this.width = width;
		
		this.generate();
	}

	@Override
	protected void generate() {
		points = new Point3D[width*height];
		
		for (int i = 0; i < width*height; i++) { //loops entire area
			for (int i2 = 0; i2 < width; i2++) { //loops rows
				for (int i3 = 0; i3 < height; i3++) { //loops columns
					points[i] = new Point3D(pos.x+i2, pos.y+i3, pos.z);
				}
			}
		}
		
	}

	@Override
	public void reGenerate(Point3D pos) {
		this.pos = pos;
		this.generate();
	}

}
