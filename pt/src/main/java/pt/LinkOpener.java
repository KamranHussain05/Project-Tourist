package pt;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class LinkOpener {

	/**
	 * Opens link via desktop browser
	 * 
	 * @param s String url for link
	 */
	public static void openLink(String s) {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			if (urlValid(s) == true) {
				try {
					Desktop.getDesktop().browse(new URI(s));
				} catch (IOException | URISyntaxException e) {
					System.out.println("error opening link");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Checks if inputted url is valid
	 * 
	 * @param url String
	 * @return Boolean that dictates if url is valid
	 */
	public static Boolean urlValid(String url) {
		Boolean builtString = false;
		String newUrl = "";

		// blank url check
		if (url == "" || url == " ")
			return false;
		// http header check
		else if (url.contains("http://") == false && url.contains("https://") == false) {
			// new string that includes header
			newUrl = "https://" + url;
			builtString = true;
		}

		// if new url was constructed
		if (builtString) {
			try {
				new URL(newUrl).toURI();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		// if input url was untouched
		else {
			try {
				new URL(url).toURI();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

}
