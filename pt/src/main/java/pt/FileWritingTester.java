package pt;

public class FileWritingTester {
	
	private static WriteToFile w;
	
	public FileWritingTester() {
		w = new WriteToFile();
	}

	public static void main(String[] args) {
		String s = "test";
		w = new WriteToFile();
		for (int i =0; i<5; i++) {
			w.writeToFile(s+i);
			System.out.println(i);
		}
	}

}
