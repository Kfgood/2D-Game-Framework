package kenneth.game.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kenneth.game.Launch;

public class GameBoardGraphics extends JPanel {
	
	private static final long serialVersionUID = -2462001805209966160L;

	ImageIcon Player = new ImageIcon("src/kenneth/game/Graphics/basicPlayer.png");
	
	@Override
	public void paintComponent(Graphics g) {
		
		BufferedImage bf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		
		drawPlayer(bf.getGraphics());
		g.drawImage(bf,0,0,null);
	}
	
	private void drawPlayer(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Player.getImage(), Launch.getGameManager().getPlayer().getPos().x, -Launch.getGameManager().getPlayer().getPos().y, Launch.getGameManager().getPlayer().getPos().x+150, -Launch.getGameManager().getPlayer().getPos().y+200, 0, 7, 15, 27, null);
	}
	
}
