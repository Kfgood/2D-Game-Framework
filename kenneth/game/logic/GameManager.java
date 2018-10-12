package kenneth.game.logic;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import kenneth.game.Launch;
import kenneth.game.GUI.GameBoardGraphics;
import kenneth.game.logic.Board.GameBoard;
import kenneth.game.logic.entity.Entity;
import kenneth.game.logic.entity.EntityLiving;
import kenneth.game.logic.player.Controls;
import kenneth.game.logic.player.Player;


/**Logic for the Game map
 * <br>
 * Will handle the location of objects and other stuff
 * */
public class GameManager {

	/**Storage of all the locations of the objects<br>
	 * All the points with no object in it, are left empty<br>
	 * */
	private GameBoard gb;
	
	private Player p;
	
	private Controls c;
	
	private GameBoardGraphics gc;
	
	private static JFrame GameWindow;
	
	public GameManager(){
		c = new Controls();
		gb.loadLocation("default");
	}

	public void startGame() {
		generateGameWindow();
		
		startWorldThread();
		
		p = new Player();
		c.startMovementManagement(); //starts movement thread
		gb = new GameBoard();
	}
	
	private void startWorldThread() {
		//Will need to determine just what type of game it is and how it will handle preventing an overload error if everything in the world is loaded at once
	}

	private void generateGameWindow() {
		GameWindow = new JFrame();
		GameWindow.setFocusable(true);
		GameWindow.setUndecorated(true);
		GameWindow.setSize(Launch.SCREENSIZE); //will eventually change this out to be an actual full screen app
		GameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		gc = new GameBoardGraphics();
		gc.setSize(Launch.SCREENSIZE);
		
		GameWindow.add(gc);
		gc.repaint();
		
		GameWindow.setVisible(true);
	}
	
	/**World events tick event*/
	public void updateWorldEvents() {
		
	}
	
	public void updateObjectPosition(Point3D pos, EntityLiving e) {
		
		//will need to find a way to get the point right up against a wall if the player collides with a wall
		
		//Should be called by an objects update movement method so updating the location again is pointless as the object already has the updated position
		//e.updateLocation(pos);
		Entity ent = gb.setObjectLocation(p.getHitbox().getHitboxPoints(), e);
		if (!ent.equals(e)) {
			e.collision(ent);
		} else {
			//send converted information to entity graphic class
			//create graphic handler that will store the entity, and the graphic class within a map as the entity being the Key
			//also need to create a method of spawning in multiple entities of the same object while having them being different entities
					//rn I'm using a string as an "identifier"
			gc.repaint();
			return;
		}
	}

	/**Used for camera tracking<br>
	 * <hr>
	 * Does this by converting the Point3D grid values into graphical points based on players location and the Point3D's method for point ratio*/
	private Point3D convertPoint(Point3D pos) {
		
		Point3D pPos = p.getPos();
		
		Point3D newPos = pos;
		
		return newPos;
	}
	
	public Player getPlayer() {
		return p;
	}
}
