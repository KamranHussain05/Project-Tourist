package pt.BackEnd.FileIO;

import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
	String text;
	PrintWriter writer;
	
	public WriteToFile() {
		
	}

	public void writeToFile(String s) {
		text = s;// getText();
		fileWriting();
	}

	public void fileWriting() {
		try {
			writer = new PrintWriter("res/userdatastorage.txt", "UTF-8");
			writer.println(text);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
