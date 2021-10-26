package pt.BackEnd.FileIO;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadData {
	HashMap<String, String> map;

	public ReadData(HashMap<String, String> map) {
		this.map = map;
	}

	public void readData(String filename) {
		try (FileWriter fw = new FileWriter("data.txt", true); BufferedWriter bw = new BufferedWriter(fw);) {
			for (Map.Entry<String, String> entry : map.entrySet()) {

				// put key and value separated by a colon
				bw.write(entry.getKey() + ":" + entry.getValue());

				// new line
				bw.newLine();
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
