

import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet{
	
	private String textBar;
	
	public DrawingSurface() {
		
	}
	
	public void setup() {
		surface.setTitle("Project Tourist");
		surface.setLocation(37, 55);
		textBar = "Type a Location";
	}
	

	public void draw() {
		background(255, 165, 0);
		this.rect(450, 270, 466, 55, 50);
		this.image(loadImage("res/Logo.png"), 486, 100);
		
		pushStyle();
		fill(0);
		textSize(20);
		text(textBar, 480, 305);
		popStyle();
	}

}
