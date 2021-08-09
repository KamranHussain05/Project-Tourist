package pt;
import g4p_controls.G4P;

public class DrawingSurfaceEndScreen extends Screen {
	
	private DrawingSurface s;
	
	public DrawingSurfaceEndScreen(DrawingSurface s) {
		super(s.width, s.height);
		this.s = s;
	}
	
	public void setup() {
		G4P.messagesEnabled(false);
	}
	
	public void draw() {
		s.background(195, 225, 210);
		s.image(s.loadImage("res/Logo.png"), 486, 100);
		s.fill(0, 0, 0);
		s.textSize(28);
		s.text("Your Destination is: " + NLP_NER.getDestination(), 470, 300);
		s.flights.setVisible(true);
		s.hotels.setVisible(true);
		s.activities.setVisible(true);
		s.flights.setEnabled(true);
		s.hotels.setEnabled(true);
		s.activities.setEnabled(true);
	}

}
