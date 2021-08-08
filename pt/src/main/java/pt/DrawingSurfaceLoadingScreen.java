package pt;

import java.util.Timer;
import java.util.TimerTask;

import g4p_controls.*;
import processing.core.PImage;


public class DrawingSurfaceLoadingScreen extends Screen {

	private DrawingSurface s;
	private PImage[] loadingGif;
	
	public DrawingSurfaceLoadingScreen(DrawingSurface s) {
		super(s.width, s.height);
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
		/*TimerTask task = new Screen3(this);
		Timer timer = new Timer();
		timer.schedule(task, 40000);*/
		moveOn();
		s.background(255, 255, 255);
		s.image(loadingGif[s.frameCount%8], 283, 250);
		s.textSize(40);
		s.fill(195, 225, 210);
		s.text("Gathering an Adventure...", 445, 400);
	}
	
	public void moveOn() {
		if (NERPipelineDemo.isNLPRunning() == false) {
			s.switchScreen(ScreenSwitcher.SCREEN3);
		}
	}

}
