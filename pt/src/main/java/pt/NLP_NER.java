package pt;

import edu.stanford.nlp.pipeline.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

public class NLP_NER {
	
	private static String dest;
	private String act1;
	private String act2;
	private String act3;
	private String act4;
	private static String userInput;
	private static String fLink;
	private static Boolean isRunning = true;
	
	public static void checkInput() {
		if (DrawingSurfaceMainScreen.getMoveOn()) {
			userInput = DrawingSurfaceMainScreen.getInput();
		} 
		
		if(userInput == "RANDOM DEST") {
			randomLocation();
		} else {
			main();
		}
	}

	public static void main() {
		isRunning = true;
		System.out.println("Inside NLP Class");
		
	    // set up pipeline properties
	    Properties props = new Properties();
	    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
	    System.out.println("Before setting up pipeline");
	    // set up pipeline
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    // make an example document
	    CoreDocument doc = new CoreDocument(userInput);
	    System.out.println("Anazlying");
	    // annotate the document
	    pipeline.annotate(doc);
	    System.out.println("Writing");
	    // view results
	    System.out.println("---");
	    System.out.println("entities found");
	    for (CoreEntityMention em : doc.entityMentions()) {
	    	System.out.println("\tdetected entity: \t"+em.text()+"\t"+em.entityType());
	    	if (em.entityType() == "CITY") {
	    		dest = em.text();
	    		System.out.println(dest);
	    		getFlightLink(dest);
	    	} 
	    	
	    	if (em.entityType() == "COUNTRY") {
	    		dest = em.text();
	    		System.out.println(dest);
	    		getFlightLink(dest);
	    	} 
	    	
	    	if (em.entityType() == 	"STATE_OR_PROVINCE") {
	    		dest = em.text();
	    		System.out.println(dest);
	    		getFlightLink(dest);
	    	} 
	    	
	    	if(em.text() == "null") {
	    		randomLocation();
	    	}
	    }
	 
	    System.out.println("---");
	    System.out.println("tokens and ner tags");
	    String tokensAndNERTags = doc.tokens().stream().map(token -> "("+token.word()+","+token.ner()+")").collect(
	        Collectors.joining(" "));
	    System.out.println(tokensAndNERTags);
	    isRunning = false;
	  }
	  
	  public static Boolean isNLPRunning() {
		  return isRunning;
	  }
	  
	  public static String getDestination() {
			String s = dest;
			return s;
	  }
	  
	  public static String getFlightLink(String destination) {
			String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";
		    String searchTerm = "flights+to+" + destination.replace(" ", "");
		    fLink = GOOGLE_SEARCH_URL +searchTerm;
		    System.out.println(fLink);
		    return fLink;
	  }
	  
	  public static String randomLocation() {
		  System.out.println("Randomizing location");
		  String randDest = "";
		  Hashtable<Integer, String> cities = new Hashtable<Integer, String>();
		  cities.put(0, "Beijing");
		  cities.put(1, "Paris");
		  cities.put(2,  "San Francisco");
		  cities.put(3,  "Cancun");
		  cities.put(4,  "London");
		  cities.put(6,  "New York");
		  cities.put(7,  "Moscow");
		  cities.put(8,  "Tokyo");
		  cities.put(9,  "Dubai");
		  cities.put(10,  "Singapore");
		  cities.put(11,  "Barcelona");
		  cities.put(12,  "Toulouse");
		  cities.put(13,  "Los Angeles");
		  cities.put(14,  "Madrid");
		  cities.put(15,  "Rome");
		  cities.put(16,  "Chicago");
		  cities.put(17,  "Toronto");
		  cities.put(18,  "Abu Dhabi");
		  cities.put(19,  "St. Petersburg");
		  cities.put(20,  "Amsterdam");
		  cities.put(21,  "Dheli");
		  cities.put(22,  "Prague");
		  cities.put(23,  "Istanbul");
		  cities.put(24,  "Seoul");
		  cities.put(25,  "Sydney");
		  
		  
		  Random rand = new Random();
		  int index = rand.nextInt(25);
		  randDest = cities.get(index);
		  
		  getFlightLink(randDest);
		  System.out.println(randDest);
		  return randDest;
	  }

}
