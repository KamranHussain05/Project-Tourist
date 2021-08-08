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
	private GTextField searchBar;
	private DrawingSurface s;
	private PImage Logo;
	
	public DrawingSurfaceMainScreen(DrawingSurface s) {
		super(s.width, s.height);
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false); //Removes suggestions in console
		randDestination = false;
		randExperience = false;
		Logo = s.loadImage("res/Logo.png");
		
		searchBar = new GTextField(s, (float)400, (float)270, (float)466, (float)30);
		searchBar.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
		searchBar.setPromptText("Enter an activity or interest, and a destination");
	}
	

	public void draw() {
		s.background(195, 225, 210);
		s.randD.setVisible(true);
		s.randE.setVisible(true);
		s.randAll.setVisible(true);
		searchBar.setVisible(true);
		s.enter.setVisible(true);
		s.randD.setEnabled(true);
		s.randE.setEnabled(true);
		s.randAll.setEnabled(true);
		s.enter.setEnabled(true);
		s.image(Logo, 486, 100);
	}
	
	public boolean getrandD() {
		return randDestination;
	}
	
	public boolean getrandE() {
		return randExperience;
	}
	
	public void setRandD(boolean b) {
		randDestination = b;
	}
	
	public void setRandE(boolean b) {
		randExperience = b;
	}
	
	public GTextField getSearchBar() {
		return searchBar;
	}
	
	private String getSearchBarText() {
		return searchBar.getText();
	}
	
	public String getDestination() {
		if (!randDestination)
			return searchBar.getText();
		else 
			return "RANDOM"; //Choose random destination if this method returns this
	}
	
	public void moveOn() {
		s.switchScreen(ScreenSwitcher.SCREEN2);
		s.randD.setEnabled(false);
		s.randE.setEnabled(false);
		s.randAll.setEnabled(false);
		s.enter.setEnabled(false);
		searchBar.setEnabled(false);
		s.randD.setVisible(false);
		s.randE.setVisible(false);
		s.randAll.setVisible(false);
		s.enter.setVisible(false);
		searchBar.setVisible(false);
	}

}
