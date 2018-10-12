package kenneth.game;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import kenneth.game.GUI.GameBoardGraphics;
import kenneth.game.logic.GameManager;
import kenneth.game.logic.player.Controls;

/*Current game ideas:
 * 
 * Random gen Survival - too simple and bland
 * Randomly gen RPG
	* would need to work out how to form unique quests, and how to inter-weave a story into a random gen world
	* very hard I think
	* Quality control
 * Structured RPG
	* just like any other rpg, story w/ main quest
	* could do randomly generated dungeons/towns, but would need unique story to explain
		why something is different everytime you go to it and quality control
 * Civilization like game
 * 
 * 
 * Could also simply just create that background framework for the creation of multiple different games of the above genres
 * */

/**
 * Kenneth Good
 * 10/2/2018
 * 
 * Main class for launching game
 * */
public class Launch {

	public static final Dimension SCREENSIZE = new Dimension(500, 500);//Toolkit.getDefaultToolkit().getScreenSize();
	
	private static GameManager gm;
	
	//Graphics
	private static GraphicsEnvironment ge;
	private static GraphicsDevice gd;
	private static GraphicsConfiguration gc;
	
	public static void main(String[] args) {
		
		//investigate use, I think these could be very powerful and useful
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();

		generateGame();
	}
	
	private static void generateGame() {
		gm = new GameManager();
	}


	public static GameManager getGameManager() {
		return gm;
	}

}
