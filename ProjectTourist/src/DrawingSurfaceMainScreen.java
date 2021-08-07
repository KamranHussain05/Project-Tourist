import java.awt.Font;
import java.util.ArrayList;

import g4p_controls.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PSurface;

public class DrawingSurfaceMainScreen extends Screen {
	
	private boolean randDestination;
	private boolean randExperience;
	private GButton randD;
	private GButton randE;
	private GButton randAll;
	private GButton enter;
	private GTextField searchBar;
	private PSurface surface;
	private DrawingSurface s;
	private PImage logo;
	private boolean moveOn;
	private boolean isFocus;
	
	public DrawingSurfaceMainScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false); //Removes suggestions in console
		randDestination = false;
		randExperience = false;
		moveOn = false;
		
		randD = new GButton(s, 85, 450, 342, 100, "Random Destination");
		randD.setLocalColorScheme(1); // http://www.lagers.org.uk/g4p/guides/g04-colorschemes.html
		
		randE = new GButton(s, 512, 450, 342, 100, "Random Experience");
		randE.setLocalColorScheme(1);
		
		randAll = new GButton(s, 939, 450, 342, 100, "Random Destination and Experience");
		randAll.setLocalColorScheme(1);
		
		searchBar = new GTextField(s, (float)400, (float)270, (float)466, (float)30);
		searchBar.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
		searchBar.setPromptText("Enter an activity or interest, and a destination");
		
		enter = new GButton(s, 866, 270, 100, 30, "Click to continue or press Enter");
		enter.setLocalColorScheme(1);
	}
	

	public void draw() {
		s.background(195, 225, 210);
		randD.setVisible(true);
		randE.setVisible(true);
		randAll.setVisible(true);
		searchBar.setVisible(true);
		enter.setVisible(true);
		s.image(s.loadImage("res/Logo.png"), 486, 100);
	}
	
	public void handleButtonEvents(GButton button, GEvent event) {
		System.out.println("Hello");
		button.fireAllEvents(true);
		
		if (button == randD && event == GEvent.CLICKED) {
		      randDestination = true;
		      button.setVisible(false);
		}
		if (button == randE && event == GEvent.CLICKED) {
		      randExperience = true;
		      button.setVisible(false);
		}
		if (button == randAll && event == GEvent.CLICKED) {
		      randDestination = true;
		      randExperience = true;
		      button.setVisible(false);
		}
		if (button == enter && event == GEvent.CLICKED) {
			searchBar.setFocus(false);
			button.setVisible(false);
			moveOn();
		}
	}
	
	public boolean getrandD() {
		return randDestination;
	}
	
	public boolean getrandE() {
		return randExperience;
	}
	
	public GTextField getSearchBar() {
		return searchBar;
	}
	
	public String getDestination() {
		if (!randDestination)
			return searchBar.getText();
		else 
			return "RANDOM"; //Choose random destination if this method returns this
	}
	
	public void moveOn() {
		moveOn = true;
		s.switchScreen(ScreenSwitcher.SCREEN2);
		randD.setEnabled(false);
		randE.setEnabled(false);
		randAll.setEnabled(false);
		enter.setEnabled(false);
		searchBar.setEnabled(false);
		randD.setVisible(false);
		randE.setVisible(false);
		randAll.setVisible(false);
		enter.setVisible(false);
		searchBar.setVisible(false);
	}
	private String getSearchBarText() {
		return searchBar.getText();
	}

}
