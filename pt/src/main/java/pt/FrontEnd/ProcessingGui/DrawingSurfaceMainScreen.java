package pt.FrontEnd.ProcessingGui;

import java.awt.Font;

import g4p_controls.*;
import processing.core.PImage;

public class DrawingSurfaceMainScreen extends Screen {

	private static boolean randDestination;
	private boolean randActivities;
	private static GTextField searchBar;
	private static DrawingSurface s;
	private PImage Logo;
	private static boolean moveOn;

	public DrawingSurfaceMainScreen(DrawingSurface s) {
		super(s.width, s.height);
		DrawingSurfaceMainScreen.s = s;
	}

	public void setup() {
		moveOn = false;
		G4P.messagesEnabled(false); // Removes suggestions in console
		randDestination = false;
		randActivities = false;
		Logo = s.loadImage("res/Logo.png");

		searchBar = new GTextField(s, (float) 400, (float) 280, (float) 466, (float) 30);
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

	public static String getInput() {
		if (!randDestination)
			return s.getText();
		else
			return "RANDOM DEST"; // Choose random destination if this method returns this
	}

	public static boolean getMoveOn() {
		return moveOn;
	}

	public void moveOn() {
		moveOn = true;
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
		s.setText(searchBar.getText());
	}

}
