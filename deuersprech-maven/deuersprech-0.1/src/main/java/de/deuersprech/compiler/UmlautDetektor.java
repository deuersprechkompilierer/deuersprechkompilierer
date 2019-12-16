/**
 * @file 	UmlautDetektor.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * prüft einen übergebenen String auf Umlaute. 
 * der compiler benutzt diese Funktion, um Bezeichner auf Gültigkeit zu prüfen.
 */
package de.deuersprech.compiler;

public class UmlautDetektor {
	public static boolean hatUmlaut(String varName) {
		if( varName.contains("ä")
		 || varName.contains("Ä")
		 || varName.contains("ö")
		 || varName.contains("Ö")
		 || varName.contains("ü")
		 || varName.contains("Ü") ) {
			return true;
		}
		
		return false;
	}	
}
