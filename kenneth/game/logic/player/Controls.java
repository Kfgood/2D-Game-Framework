package kenneth.game.logic.player;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import kenneth.game.Launch;


/**Controls controller, will eventually split this up into different controllers, likely using subclasses*/
public class Controls{
	
	private MovementControls move = new MovementControls(this);
	private KeyboardFocusManager kfm;
	
	public Controls() {
		kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	}

	public void startMovementManagement() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(move);
	}
	
	public void endMovementManagement() {
		kfm.removeKeyEventDispatcher(move);
	}
	
	protected void movementUpdated() {
		//There is some stutter when a key is pressed, as well as it canceling out a button press when another is pressed down
			//To fix: change this to just set a direction vector and have the actual movement event run through a thread
		Launch.getGameManager().getPlayer().updateMovement(move.horizontalDirection, move.verticalDirection, move.running);
	}
}

class MovementControls implements KeyEventDispatcher {
	
	int horizontalDirection = 0, verticalDirection = 0;
	boolean running = false;
	boolean n = false, s = false, e = false, w = false;
	
	Controls c;
	
	public MovementControls(Controls controls) {
		c = controls;
	}

	//one way for better accuracy would be to create 4 different listeners for each direction (But this shouldn't be needed, I think)
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		synchronized (Movement.class) {
            switch (e.getID()) {
	            case KeyEvent.KEY_PRESSED:
	                if (e.getKeyCode() == KeyEvent.VK_W) {
	                	n = true;
	                	updateVDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_S) {
	                	s = true;
	                	updateVDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_D) {
	                	this.e = true;
	                	updateHDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_A) {
	                	w = true;
	                	updateHDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
	                	running = true;
	                }
	                break;
	
	            case KeyEvent.KEY_RELEASED:
	                if (e.getKeyCode() == KeyEvent.VK_W) {
	                	n = false;
	                	updateVDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_S) {
	                	s = false;
	                	updateVDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_D) {
	                	this.e = false;
	                	updateHDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_A) {
	                	w = false;
	                	updateHDirection();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
	                	running = false;
	                }
	                break;
            }
            
            System.out.println("<" + horizontalDirection + ", " + verticalDirection + ">");

            c.movementUpdated();
            
            return false;
        }
	}

	private void updateHDirection() {
		if (e && !w) {
			horizontalDirection = 1;
		} else if (w && !e) {
			horizontalDirection = -1;
		} else {
			horizontalDirection = 0;
		}
	}

	private void updateVDirection() {
		if (n && !s) {
			verticalDirection = 1;
		} else if (s && !n) {
			verticalDirection = -1;
		} else {
			verticalDirection = 0;
		}
	}
	
}