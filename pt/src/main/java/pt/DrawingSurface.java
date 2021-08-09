package pt;

import java.util.ArrayList;

import g4p_controls.GButton;
import g4p_controls.GEvent;
import processing.core.PApplet;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private Screen activeScreen;
	private ArrayList<Screen> screens;
	private DrawingSurfaceMainScreen main;
	private DrawingSurfaceLoadingScreen loading;
	private DrawingSurfaceEndScreen end;
	public GButton randD;
	public GButton randA;
	public GButton randAll;
	public GButton enter;
	private String text;
	public GButton flights;
	public GButton hotels;
	public GButton activities;

	public DrawingSurface() {

		screens = new ArrayList<Screen>();
		main = new DrawingSurfaceMainScreen(this);
		screens.add(main);
		loading = new DrawingSurfaceLoadingScreen(this);
		screens.add(loading);
		end = new DrawingSurfaceEndScreen(this);
		screens.add(end);

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

		randA = new GButton(this, 512, 450, 342, 100, "Random Activities");
		randA.setLocalColorScheme(1);
		randA.setEnabled(false);
		randA.setVisible(false);

		randAll = new GButton(this, 939, 450, 342, 100, "Random Destination and Activities");
		randAll.setLocalColorScheme(1);
		randAll.setEnabled(false);
		randAll.setVisible(false);

		enter = new GButton(this, 866, 280, 100, 30, "Click to continue or press Enter");
		enter.setLocalColorScheme(1);
		enter.setEnabled(false);
		enter.setVisible(false);

		flights = new GButton(this, 85, 350, 342, 100, "Available Flights");
		flights.setLocalColorScheme(1);
		flights.setEnabled(false);
		flights.setVisible(false);

		hotels = new GButton(this, 512, 350, 342, 100, "Suggested Hotels");
		hotels.setLocalColorScheme(1);
		hotels.setEnabled(false);
		hotels.setVisible(false);

		activities = new GButton(this, 939, 350, 342, 100, "Suggested Activities");
		activities.setLocalColorScheme(1);
		activities.setEnabled(false);
		activities.setVisible(false);
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
		button.fireAllEvents(true);

		if (button == randD && event == GEvent.CLICKED) {
			main.setRandD(true);
		}
		if (button == randA && event == GEvent.CLICKED) {
			main.setRandA(true);
		}
		if (button == randAll && event == GEvent.CLICKED) {
			main.setRandD(true);
			main.setRandA(true);
		}
		if (button == enter && event == GEvent.CLICKED) {
			main.getSearchBar().setFocus(false);
			main.moveOn();
			NLP_NER.checkInput();
		}
		if (button == flights && event == GEvent.CLICKED) {
			LinkOpener.openLink(NLP_NER.getFlightLink(NLP_NER.getDestination()));
		}
		if (button == hotels && event == GEvent.CLICKED) {
			LinkOpener.openLink(NLP_NER.getHotelLink(NLP_NER.getDestination()));
		}
		if (button == activities && event == GEvent.CLICKED) {
			LinkOpener.openLink(NLP_NER.getActivitiesLink(NLP_NER.getDestination()));
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
		if (activeScreen.equals(screens.get(0))) {
			if (key == ENTER || key == RETURN) { // Will exit search bar if ENTER or RETURN is pressed
				main.getSearchBar().setFocus(false);
				main.moveOn();
				NLP_NER.checkInput();
			}
		}
	}

	/**
	 * Switches between screens
	 * 
	 * @param i Number of the screen to be switched to
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

	public String getText() {
		return text;
	}

	public void setText(String t) {
		text = t;
	}

}
