/**
 * @file 	FunctionList.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Verwaltet Liste mit Funktions-Definitionen
 */

package de.deuersprech.compiler;

import java.util.ArrayList;
import java.util.Collection;

/**@brief
 * Die Klasse FunctionList beinhaltet eine Liste von FunctionDefinition-Objekten und kann ueberpruefen, ob eine Funktion bereits definiert ist oder nicht.
 * Dabei wird nicht nur der Name, sondern auch die Parameterliste abgegelichen.
 */
public class FunctionList {
	/**
	 * List, die FunctionDefinitions speichert
	 */
	private Collection<FunctionDefinition> definitions = new ArrayList<>();
	
	/**
	 * Ueberprueft, ob eine Funktion mit der gleichen Signatur bereits vorhanden ist
	 * @param functSignature	Die Signatur der Funktion
	 * @return					true, falls vorhanden, sonst false
	 */
	public boolean contains(String functSignature) {
		// iteriert ueber Liste
		for(FunctionDefinition def : definitions) {
			//und prueft, ob eine Funktion mit der gleichen Signatur vorhanden ist
			if (functSignature.equals(def.getSignature())) {
				return true;
			}		
		}
		return false;
	}
	
	/**
	 * fuegt der Liste eine weitere FunctionDefinition hinzu
	 * @param functName		Name der Funktion
	 * @param paramCount	Anzahl an Paramtern
	 */
	public void add(String functName, ArrayList<DataType> params, DataType returnType) {
		definitions.add(new FunctionDefinition(functName, params, returnType));
	}

	/**
	 * fuegt der Liste eine weitere FunctionDefinition hinzu
	 * @param def			FunctionDefinition-Objekt der hinzuzufügenden Funktion
	 */
	public void add(FunctionDefinition def) {
		definitions.add(def);
	}
	
	/**@brief
	 * Simple Datenstruktur, um Funktions-Definitionen zu speichern.
	 */
	public static class FunctionDefinition {
		/**@brief
		 * Der Name der Funktion
		 */
		private final String functName;
		/**@brief
		 * Die übergabe-Parameter der funktion
		 */
		private final ArrayList<DataType> params;
		/**
		 * return typ der funktion
		 */
		private final DataType returnType;

		/**
		 * Konstruktor der Klasse FunctionDefinition
		 * @param functName		Name der Funktion	
		 * @param params		Übergabeparameter der Funktion bzw. deren Datentyp
		 * @param returnType	Datentyp des Rückgabewertes
		 */
		public FunctionDefinition(String functName, ArrayList<DataType> params, DataType returnType) {
			super();
			this.functName = functName;
			this.params = params;
			this.returnType = returnType;
			//System.out.println("constructor funcDef: returnType is " + returnType);
		}

		/**
		 * genertiert Signatur einer Funktion
		 * eie Signatur setzt sich aus Funktionsname (Bezeichner), Parameterliste und Rückgabetyp zusammen
		 * @return	Signatur der Funktion
		 */
		public String getSignature() {
			String functSignature = functName + "(";
			for(DataType param : params) {
				if(param == DataType.INT) {
					functSignature += "I";
				} else if (param == DataType.STRING) {
					functSignature += "Ljava/lang/String;";
				}
			}
			functSignature += ")";
			if(returnType == DataType.INT) {
				functSignature += "I";
			} else {
				functSignature += "Ljava/lang/String;";
			}
			return functSignature;
		}	

		/**
		 * generiert Signatur der Parameterliste
		 * @return Signatur der Parameterliste
		 */
		public String getParamSignature() {
			String paramSignature = "(";
			for(DataType param : params) {
				if(param == DataType.INT) {
					paramSignature += "I";
				} else if (param == DataType.STRING) {
					paramSignature += "Ljava/lang/String;";
				}
			}
			paramSignature += ")";
			return paramSignature;
		}
	}
}
