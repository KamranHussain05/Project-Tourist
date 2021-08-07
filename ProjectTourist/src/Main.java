import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {
	
	private static Image getIcon() {
		ImageIcon icon = new ImageIcon("res/icon.png");
		Image img = icon.getImage();
		return img;
	}

	public static void main(String[] args) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1366, 768);
		window.setMinimumSize(new Dimension(1366, 768));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setIconImage(getIcon());
		window.setVisible(true);
		
		canvas.requestFocus();

	}

}
