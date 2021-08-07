

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet{
	
	public DrawingSurface() {
		
	}
	
	public void setup() {
		surface.setTitle("Project Tourist");
		surface.setLocation(37, 55);
	}
	

	public void draw() {
		this.rect(200, 200, 540, 45, 50);
		
		pushStyle();
		fill(0);
		textSize(10);
		text("Interactions- House Move: Arrow Keys, Person Move: WASD, \nHouse Scale: Left/Right Click, Sun move: comma and period", 120, 10);
		popStyle();
	}

}
