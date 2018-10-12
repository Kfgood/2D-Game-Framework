package kenneth.game.logic;

/**Converts from graphical points(px) to game points
 * 
 * each 32x32 pixels will be one point
 * <br>	(z is managed differently, it's more like a floor level)
 * 
 * */
public class Point3D {

	public int x = 0, y = 0, z = 0; //make a get
	
	private static final int GRAPHICALRATIO = 4;
	
	public Point3D(){}
	
	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D(Point3D p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}
	
	public static int[] toGraphicPoints(Point3D pos) {
		
		int[] points = new int[2];
		
		points[0] = (int)(pos.x/GRAPHICALRATIO);
		points[1] = (int)(pos.y/GRAPHICALRATIO);
		
		return points;
	}
	
	public static Point3D toPoint3D(int x, int y, int z) {
		
		Point3D p3d = new Point3D();
		
		p3d.setXYZ(new Point3D(x*GRAPHICALRATIO, y*GRAPHICALRATIO, z));
		
		return p3d;
	}
	
	public static Point3D toPoint3D(int x, int y) {
		
		Point3D p3d = new Point3D();
		
		p3d.setXYZ(new Point3D(x*GRAPHICALRATIO, y*GRAPHICALRATIO, 0));
		
		return p3d;
	}
	
	public void setXYZ(Point3D p3d) {
		this.x = p3d.x;
		this.y = p3d.y;
		this.z = p3d.z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point3D) {
			Point3D pos = (Point3D) obj;
			if (this.x == pos.x && this.y == pos.y && this.z == pos.z) {
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
		return "<"+ x + "," + y + "," + z + ">";
	}
}
