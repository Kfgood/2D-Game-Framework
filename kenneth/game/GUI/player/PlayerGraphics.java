package kenneth.game.GUI.player;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import kenneth.game.Launch;

public class PlayerGraphics extends JComponent{

	private static final long serialVersionUID = 2368752214742173179L;
	
	public final Image IDLE;
	public final Image RUNNING;
	public final Image HURT;
	
	public PlayerGraphics() throws IOException{
		IDLE = ImageIO.read((new Launch()).getClass().getResource("Graphics/basicPlayer.png"));
		RUNNING = ImageIO.read((new Launch()).getClass().getResource("Graphics/basicPlayer.png"));
		HURT = ImageIO.read((new Launch()).getClass().getResource("Graphics/basicPlayer.png"));
	}
		
}
