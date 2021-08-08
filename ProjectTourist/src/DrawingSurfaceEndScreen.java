import g4p_controls.G4P;
import processing.core.PImage;
import processing.core.PSurface;

public class DrawingSurfaceEndScreen extends Screen{
	private PSurface surface;
	private DrawingSurface s;
	private boolean moveOn;
	
	public DrawingSurfaceEndScreen(DrawingSurface s) {
		super(s.width, s.height);
		surface = s.getSurface();
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false);
		moveOn = false;
		
		
	}
	

	public void draw() {
		s.background(195, 225, 210);
		s.image(s.loadImage("res/Logo.png"), 486, 100);
		s.textSize(18);
		s.text("Your city is Los Angeles", 200, 300);
		s.textSize(14);
		s.text("Activities: Hollywood, Universal Studios, Lakers Game", 150, 350);
		
		
	}
	
	public void moveOn() {
		moveOn = true;
	}

}
