import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import g4p_controls.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PSurface;


public class DrawingSurfaceLoadingScreen extends Screen {
	
	private PSurface surface;
	private DrawingSurface s;
	private PImage[] loadingGif;
	
	public DrawingSurfaceLoadingScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		loadingGif = new PImage[8];
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false);
		loadingGif[0] = s.loadImage( "res/frame1.png" );
		loadingGif[1] = s.loadImage( "res/frame2.png" );
		loadingGif[2] = s.loadImage( "res/frame3.png" );
		loadingGif[3] = s.loadImage( "res/frame4.png" );
		loadingGif[4] = s.loadImage( "res/frame5.png" );
		loadingGif[5] = s.loadImage( "res/frame6.png" );
		loadingGif[6] = s.loadImage( "res/frame7.png" );
		loadingGif[7] = s.loadImage( "res/frame8.png" );
		s.frameRate(8);
	}
	

	public void draw() {
		TimerTask task = new Screen3(this);
		Timer timer = new Timer();
		timer.schedule(task, 4000);
		s.background(255, 255, 255);
		s.image(loadingGif[s.frameCount%8], 283, 250);
	}
	
	public void moveOn() {
		s.switchScreen(ScreenSwitcher.SCREEN3);
	}

}
