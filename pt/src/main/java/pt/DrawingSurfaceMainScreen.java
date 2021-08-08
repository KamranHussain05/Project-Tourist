package pt;

import java.awt.Font;

import g4p_controls.*;
import processing.core.PImage;

public class DrawingSurfaceMainScreen extends Screen {
	
	private boolean randDestination;
	private boolean randActivities;
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
		randActivities = false;
		Logo = s.loadImage("res/Logo.png");
		
		searchBar = new GTextField(s, (float)400, (float)270, (float)466, (float)30);
		searchBar.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
		searchBar.setPromptText("Enter an activity or interest, and a destination");
	}
	

	public void draw() {
		s.background(195, 225, 210);
		s.randD.setVisible(true);
		s.randA.setVisible(true);
		s.randAll.setVisible(true);
		searchBar.setVisible(true);
		s.enter.setVisible(true);
		s.randD.setEnabled(true);
		s.randA.setEnabled(true);
		s.randAll.setEnabled(true);
		s.enter.setEnabled(true);
		s.image(Logo, 486, 100);
	}
	
	public boolean getrandD() {
		return randDestination;
	}
	
	public boolean getrandE() {
		return randActivities;
	}
	
	public void setRandD(boolean b) {
		randDestination = b;
	}
	
	public void setRandA(boolean b) {
		randActivities = b;
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
		s.switchScreen(ScreenSwitcher.SCREEN2);
		s.randD.setEnabled(false);
		s.randA.setEnabled(false);
		s.randAll.setEnabled(false);
		s.enter.setEnabled(false);
		searchBar.setEnabled(false);
		s.randD.setVisible(false);
		s.randA.setVisible(false);
		s.randAll.setVisible(false);
		s.enter.setVisible(false);
		searchBar.setVisible(false);
	}

}
