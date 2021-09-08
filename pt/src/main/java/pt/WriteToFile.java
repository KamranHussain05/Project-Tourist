package pt;

import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
	String text;

	public void writeToFile(String s) {
		text = s;// getText();
		fileWriting();
	}

	public void fileWriting() {
		try {
			PrintWriter writer = new PrintWriter("userdatastorage.txt", "UTF-8");
			writer.println(text);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
