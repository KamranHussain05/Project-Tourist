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
	private PImage[] loadingGif;
	private boolean moveOn;
	
	public DrawingSurfaceLoadingScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		loadingGif = new PImage[8];
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false);
		moveOn = false;
		loadingGif[0] = s.loadImage( "res/frame1.png" );
		loadingGif[1] = s.loadImage( "res/frame2.png" );
		loadingGif[2] = s.loadImage( "res/frame3.png" );
		loadingGif[3] = s.loadImage( "res/frame4.png" );
		loadingGif[4] = s.loadImage( "res/frame5.png" );
		loadingGif[5] = s.loadImage( "res/frame6.png" );
		loadingGif[6] = s.loadImage( "res/frame7.png" );
		loadingGif[7] = s.loadImage( "res/frame8.png" );
		s.frameRate(10);
	}
	

	public void draw() {
		s.background(255, 255, 255);
		s.image(s.loadImage("res/Logo.png"), 486, 100);
		s.image( loadingGif[s.frameCount%8], 270, 300 );
		
		
	}
	
	public void moveOn() {
		moveOn = true;
	}

}
