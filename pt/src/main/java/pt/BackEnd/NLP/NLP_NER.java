package pt.BackEnd.NLP;

import edu.stanford.nlp.pipeline.*;
import pt.BackEnd.FileIO.*;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;

public class NLP_NER {

	private static String dest;
	private static String userInput;
	private static String fLink;
	private static Boolean isRunning = true;
	private static String hotel;
	private static String activity;
	private static WriteToFile w;
	private static Properties props;
	
	public NLP_NER() {
		dest = null;
		// set up pipeline properties
				props = new Properties();
				props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
	}

	public static void checkInput(String in) {
		isRunning=true;
		userInput = in;

		if (userInput == "RANDOM DEST" || userInput == "") {
			randomLocation();
		} else {
			main();
		}
	}

	public static void main() {
		System.out.println("Inside NLP Class");

		System.out.println("Before setting up pipeline");
		// set up pipeline
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		// make an example document
		CoreDocument doc = new CoreDocument(userInput);
		System.out.println("Analyzing Text");
		// annotate the document
		pipeline.annotate(doc);
		System.out.println("Writing");
		// view results
		System.out.println("---");
		System.out.println("entities found");
		for (CoreEntityMention em : doc.entityMentions()) {
			System.out.println("\tdetected entity: \t" + em.text() + "\t" + em.entityType());
			if (em.entityType() == "CITY") {
				dest = em.text();
				System.out.println(dest);
				//getFlightLink(dest);
			}

			if (em.entityType() == "COUNTRY") {
				dest = em.text();
				System.out.println(dest);
				//getFlightLink(dest);
			}

			if (em.entityType() == "STATE_OR_PROVINCE") {
				dest = em.text();
				System.out.println(dest);
				
				//getFlightLink(dest);
			} 
			
			if(dest == null) {
				dest = randomLocation();
			}

		} 
		System.out.println(dest);
		System.out.println("---");
		isRunning = false;
	}

	public static Boolean isNLPRunning() {
		return isRunning;
	}

	public static String getDestination() {
		return dest;
	}

	public static String getFlightLink() {
		String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";
		String searchTerm = "flights+to+" + getDestination().replace(" ", "");
		fLink = GOOGLE_SEARCH_URL + searchTerm;
		System.out.println(fLink);
		return fLink;
	}

	public static String getHotelLink() {
		String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";
		getDestination().replace(" ", "+");
		String searchTerm = "hotels+at+" + getDestination().replace(" ", "");
		hotel = GOOGLE_SEARCH_URL + searchTerm;
		System.out.println(hotel);
		return hotel;
	}

	public static String getActivitiesLink() {
		String GOOGLE_SEARCH_URL = "http://www.google.com/search?q=";
		getDestination().replace(" ", "+");
		String searchTerm = "top+sights+in+" + getDestination().replace(" ", "");
		activity = GOOGLE_SEARCH_URL + searchTerm;
		System.out.println(activity);
		return activity;
	}

	public static String randomLocation() {
		System.out.println("Randomizing location");
		String randDest = "";
		Hashtable<Integer, String> cities = new Hashtable<Integer, String>();
		cities.put(0, "Beijing");
		cities.put(1, "Paris");
		cities.put(2, "San Francisco");
		cities.put(3, "Cancun");
		cities.put(4, "London");
		cities.put(6, "New York");
		cities.put(7, "Moscow");
		cities.put(8, "Tokyo");
		cities.put(9, "Dubai");
		cities.put(10, "Singapore");
		cities.put(11, "Barcelona");
		cities.put(12, "Toulouse");
		cities.put(13, "Los Angeles");
		cities.put(14, "Madrid");
		cities.put(15, "Rome");
		cities.put(16, "Chicago");
		cities.put(17, "Toronto");
		cities.put(18, "Abu Dhabi");
		cities.put(19, "St. Petersburg");
		cities.put(20, "Amsterdam");
		cities.put(21, "Dheli");
		cities.put(22, "Prague");
		cities.put(23, "Istanbul");
		cities.put(24, "Seoul");
		cities.put(25, "Sydney");

		Random rand = new Random();
		int index = rand.nextInt(25);
		randDest = cities.get(index);
		dest = randDest;

		System.out.println(randDest);
		return randDest;
	}
}