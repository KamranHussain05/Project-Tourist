import java.awt.Font;
import java.util.ArrayList;

import g4p_controls.*;
import processing.core.PApplet;
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
	
	public DrawingSurfaceMainScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		this.s = s;
	}
	
	public void setup() {
		randDestination = false;
		randExperience = false;
		randD = new GButton(s, 85, 450, 342, 100, "Random Destination");
		randD.setLocalColorScheme(1); // http://www.lagers.org.uk/g4p/guides/g04-colorschemes.html
		randE = new GButton(s, 512, 450, 342, 100, "Random Experience");
		randE.setLocalColorScheme(1);
		randAll = new GButton(s, 939, 450, 342, 100, "Random Destination and Experience");
		randAll.setLocalColorScheme(1);
		searchBar = new GTextField(s, (float)450, (float)270, (float)466, (float)30);
		searchBar.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
		searchBar.setPromptText("Enter an activity or interest, and a destination");
		enter = new GButton(s, 916, 450, 100, 100, "Random Experience");
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
	
	public void keyPressed() {
		if (s.key == s.ENTER || s.key == s.RETURN) { //Will exit search bar if ENTER or RETURN is pressed
			searchBar.setFocus(false);
		}
	}
	
	public void handleButtonEvents(GButton button, GEvent event) {
		if (button == randD && event == GEvent.CLICKED) {
		      randDestination = true;
		}
		if (button == randE && event == GEvent.CLICKED) {
		      randExperience = true;
		}
		if (button == randAll && event == GEvent.CLICKED) {
		      randDestination = true;
		      randExperience = true;
		}
	}
	
	public boolean getrandD() {
		return randDestination;
	}
	
	public boolean getrandE() {
		return randExperience;
	}
	
	public String getDestination() {
		if (!randDestination)
			return searchBar.getText();
		else 
			return "RANDOM"; //Choose random destination if this method returns this
	}

}
