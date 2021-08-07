import java.awt.Font;
import java.util.ArrayList;

import g4p_controls.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PSurface;

public class DrawingSurfaceLoadingScreen extends Screen {
	
	private PSurface surface;
	private DrawingSurface s;
	private PImage loadingGif;
	private boolean moveOn;
	
	public DrawingSurfaceLoadingScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		this.s = s;
	}
	
	public void setup() {
		moveOn = false;
	}
	

	public void draw() {
		s.background(225, 225, 225);
	}
	
	public void moveOn() {
		moveOn = true;
	}

}
