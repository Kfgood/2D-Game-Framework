package kenneth.game.logic.player;

import kenneth.game.Launch;
import kenneth.game.logic.ActionObjects;
import kenneth.game.logic.GameManager;
import kenneth.game.logic.Point3D;
import kenneth.game.logic.entity.Entity;
import kenneth.game.logic.entity.EntityLiving;
import kenneth.game.logic.entity.hitbox.RectangularHitbox;

public class Player extends EntityLiving {

	private final int baseSpeed = 10;
	
	private double sprintMod = 0.5;
	
	private int hDir = 0, vDir = 0;
	private boolean running;
	
	private GameManager gm = Launch.getGameManager();
	
	public Player() {
		identifier = "Player";
		
		pos = new Point3D();
		hb = new RectangularHitbox(pos, 32, 32);
	}
	
	public void update() {
		//will be called by the main update thread
		
		//this might make movement slightly smoother
		updateMovement();
		gm.updateObjectPosition(pos, this);
		
	}
	
	public void updateMovement(int hDir, int vDir, boolean running) {
		this.hDir = hDir;
		this.vDir = vDir;
		this.running = running;
	}
	
	private void updateMovement() {
		
		int v_x = 0, v_y = 0;
		
		Point3D newPos = new Point3D();
		
		if(!running) {
			v_x = hDir*baseSpeed;
			v_y = vDir*baseSpeed;
			newPos = new Point3D(pos.x+v_x, pos.y+v_y, pos.z);
		} else {
			v_x = (int) (hDir*baseSpeed*(1+sprintMod));
			v_y = (int) (vDir*baseSpeed*(1+sprintMod));
			newPos = new Point3D(pos.x+v_x, pos.y+v_y, pos.z);
		}
		
		pos.setXYZ(newPos);
		
		updateHitbox();
	}
	
	private void updateHitbox() {
		hb.reGenerate(pos);
	}

	public void setPosition(Point3D newPos) {
		pos = newPos;
	}

	public void collision(Entity ent) {
		if (ent.isSolid()) {
			//set position to right before it
		} else if (ent instanceof ActionObjects) {
			((ActionObjects) ent).collision(this);
			//could create loop with collisions need to be able to tell the difference
			//between the initial collision, and the collision call event sent by
			//the other object due to the first colliding with it
		}
	}
	
}
