/**
 * @file 	BezeichnerOhneUmlautException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass ein Bezeichner keinen Umlaut enthält. 
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class BezeichnerOhneUmalutException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String bezeichnerStr;
	
	public BezeichnerOhneUmalutException(Token bezeichner) {
		super(bezeichner);
		bezeichnerStr = bezeichner.getText();
	}
	
	
	public String getMessage() {
		return line + ":" + column + " <" + bezeichnerStr + ">" + System.lineSeparator()
		 + "Kritischer Fehler! Bezeichner enthält keinen Umlaut!" + System.lineSeparator();
	}
}
