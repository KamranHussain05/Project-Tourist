package pt;

import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
	String text;

	public WriteToFile() {
		text = "I like Los Angeles CA";// getText();
	}

	public void fileWriting() {
		try {
			PrintWriter writer = new PrintWriter("res/data.txt", "UTF-8");
			writer.println(text);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
