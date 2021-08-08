

import java.awt.Point;
import java.util.ArrayList;

import g4p_controls.GButton;
import g4p_controls.GEvent;
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
	public GButton randD;
	public GButton randE;
	public GButton randAll;
	public GButton enter;
	
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
		
		randD = new GButton(this, 85, 450, 342, 100, "Random Destination");
		randD.setLocalColorScheme(1); // http://www.lagers.org.uk/g4p/guides/g04-colorschemes.html
		randD.setEnabled(false);
		randD.setVisible(false);
		
		randE = new GButton(this, 512, 450, 342, 100, "Random Experience");
		randE.setLocalColorScheme(1);
		randE.setEnabled(false);
		randE.setVisible(false);
		
		randAll = new GButton(this, 939, 450, 342, 100, "Random Destination and Experience");
		randAll.setLocalColorScheme(1);
		randAll.setEnabled(false);
		randAll.setVisible(false);
		
		enter = new GButton(this, 866, 270, 100, 30, "Click to continue or press Enter");
		enter.setLocalColorScheme(1);
		enter.setEnabled(false);
		enter.setVisible(false);
	}
	
	/**
	 * Draws the selected screen
	 */
	public void draw() {
		pushMatrix();
		
		activeScreen.draw();
		
		popMatrix();
	}
	
	public void handleButtonEvents(GButton button, GEvent event) {
		System.out.println("Hello");
		button.fireAllEvents(true);
		
		if (button == randD && event == GEvent.CLICKED) {
			main.setRandD(true);
			System.out.println("randD");
		}
		if (button == randE && event == GEvent.CLICKED) {
			main.setRandE(true);
			System.out.println("ranE");
		}
		if (button == randAll && event == GEvent.CLICKED) {
			main.setRandD(true);
			main.setRandE(true);
			System.out.println("ranAll");
		}
		if (button == enter && event == GEvent.CLICKED) {
			main.getSearchBar().setFocus(false);
			main.moveOn();
		}
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
