import java.awt.Font;

import g4p_controls.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private boolean randDestination;
	private boolean randExperience;
	private GButton randD;
	private GButton randE;
	private GButton randAll;
	private GTextField searchBar;
	
	public void setup() {
		randDestination = false;
		randExperience = false;
		surface.setTitle("Project Tourist");
		surface.setLocation(37, 55);
		randD = new GButton(this, 85, 450, 342, 100, "Random Destination");
		randD.setLocalColorScheme(1); // http://www.lagers.org.uk/g4p/guides/g04-colorschemes.html
		randE = new GButton(this, 512, 450, 342, 100, "Random Experience");
		randE.setLocalColorScheme(1);
		randAll = new GButton(this, 939, 450, 342, 100, "Random Destination and Experience");
		randAll.setLocalColorScheme(1);
		searchBar = new GTextField(this, (float)450, (float)270, (float)466, (float)30);
		searchBar.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
		searchBar.setPromptText("Type Your Destination");
	}
	

	public void draw() {
		background(195, 225, 210);
		randD.setVisible(true);
		randE.setVisible(true);
		randAll.setVisible(true);
		searchBar.setVisible(true);
		this.image(loadImage("res/Logo.png"), 486, 100);
	}
	
	public void keyPressed() {
		if (key == ENTER || key == RETURN) { //Will exit search bar if ENTER or RETURN is pressed
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
