package pt;

import edu.stanford.nlp.pipeline.*;

import java.util.Properties;
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
			main();
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
	    System.out.println("Analyzing");
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
		  return null;
	  }

}
