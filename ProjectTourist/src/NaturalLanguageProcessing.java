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
	private String fLink;
	
	
	public NaturalLanguageProcessing() {
		
	}
	
	public String getFlightLink(String destination) {
		String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";
		String cool = destination.replace(' ', '+');
	    String searchTerm = "flights+to+" + cool;
	    fLink = GOOGLE_SEARCH_URL +searchTerm;
	    return fLink;
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
	public Dictionary<String, String> getProcessedData(String loc, String actOne, String actTwo, String actThree, String flightLink) {
		Dictionary<String, String> results = null;
		results.put("location", loc);
		results.put("activityOne", actOne);
		results.put("activityTwo", actTwo);
		results.put("activityThree", getActivityThree());
		results.put("flightChoice", flightLink);
		return results;
	}
	
}
