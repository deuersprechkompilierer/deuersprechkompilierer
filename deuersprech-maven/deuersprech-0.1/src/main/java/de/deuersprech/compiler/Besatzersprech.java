/**
 * @file 	Besatzersprech.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Findet Besatzersprech in Strings
 */
package de.deuersprech.compiler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * lädt Datei "besatzersprech.txt", liest jede Zeile als String in eine ArrayList von Strings
 */
public class Besatzersprech {
	private ArrayList<String> boeseWoerter = new ArrayList<>();

	public Besatzersprech() {
		try {
			InputStream actual = this.getClass().getClassLoader().getResourceAsStream("besatzersprech.txt");
			InputStreamReader iSReader = new InputStreamReader(actual);
			BufferedReader txtReader = new BufferedReader(iSReader);

			while(txtReader.readLine() != null) {
				boeseWoerter.add(txtReader.readLine());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean istBesatzersprech(String word) {
		if(boeseWoerter.contains(word) && word.length() > 2) {
			return true;
		} else {
			return false;	
		}
	}
}
