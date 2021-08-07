

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * This class has all the different screens and switches between them
 * @author Harshith Pothula
 * @version 5/24
 *
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private Screen activeScreen;
	private ArrayList<Screen> screens;
	private DrawingSurfaceMainScreen main;
	private DrawingSurfaceLoadingScreen loading;
	
	public DrawingSurface() {
		
		screens = new ArrayList<Screen>();
		main = new DrawingSurfaceMainScreen(this);
		screens.add(main);
		loading = new DrawingSurfaceLoadingScreen(this);
		screens.add(loading);
		activeScreen = screens.get(0);	
	}
	
	public void settings() {
		// size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
		size(activeScreen.DRAWING_WIDTH, activeScreen.DRAWING_HEIGHT);
	}
	
	public void setup() {
		surface.setTitle("Project Tourist");
		surface.setLocation(37, 55);
		surface.setResizable(true);
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * Draws the selected screen
	 */
	public void draw() {
		pushMatrix();
		
		activeScreen.draw();
		
		popMatrix();
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public void keyPressed() {
		if (key == ENTER || key == RETURN) { //Will exit search bar if ENTER or RETURN is pressed
			main.getSearchBar().setFocus(false);
			main.moveOn();
		}
	}
	
	/**
	 * Switches between screens
	 * @param i Number of the screen to be switched to
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}
