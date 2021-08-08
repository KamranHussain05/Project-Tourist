package pt;

import edu.stanford.nlp.parser.lexparser.Item;
import edu.stanford.nlp.pipeline.*;

import java.util.Properties;
import java.util.stream.Collectors;

public class NLP_NER {
	
	private static String dest;
	private String act1;
	private String act2;
	private String act3;
	private String act4;
	private static String fLink;
	private static Boolean isRunning = true;

  public static void main() {
	  isRunning = true;
    // set up pipeline properties
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");

    // set up pipeline
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // make an example document
    CoreDocument doc = new CoreDocument(DrawingSurfaceMainScreen.getInput());
    // annotate the document
    pipeline.annotate(doc);
    // view results
    System.out.println("---");
    System.out.println("entities found");
    for (CoreEntityMention em : doc.entityMentions()) {
    	System.out.println("\tdetected entity: \t"+em.text()+"\t"+em.entityType());
    	if (em.entityType() == "CITY" || em.entityType() == "LOCATION") {
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
		destination.replace(" ", "");
	    String searchTerm = "flights+to+" + destination;
	    fLink = GOOGLE_SEARCH_URL +searchTerm;
	    System.out.println(fLink);
	    return fLink;
  }

}
