import java.util.Dictionary;

// Author: Kamran Hussain
// Date: 8/6/21
// 
public class NaturalLanguageProcessing {
	private String dest;
	private String act1;
	private String act2;
	private String act3;
	private String act4;
	
	
	public NaturalLanguageProcessing() {
		
	}
	
	
	// Accessor methods for file writer and front end
	public String getDestination() {
		String s = dest;
		return s;
	}
	
	public String getActivityOne() {
		String s = act1;
		return s;
	}
	
	public String getActivityTwo() {
		String s = act2;
		return s;
	}
	
	public String getActivityThree() {
		String s = act3;
		return s;
	}
	
	public String getActivityFour() {
		String s = act4;
		return s;
	}
	
	@SuppressWarnings("null")
	public Dictionary<String, String> getProcessedData(String loc, String actOne, String actTwo, String actThree) {
		Dictionary<String, String> results = null;
		results.put("location", loc);
		results.put("activityOne", actOne);
		results.put("activityTwo", actTwo);
		results.put("activityThree", getActivityThree());
		
		return results;
	}
}
