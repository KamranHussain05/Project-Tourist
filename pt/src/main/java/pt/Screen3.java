package pt;

import java.util.TimerTask;

public class Screen3 extends TimerTask {

	DrawingSurfaceLoadingScreen d;

	public Screen3(DrawingSurfaceLoadingScreen d) {
		this.d = d;
	}

	public void run() {
		d.moveOn();
	}

}
