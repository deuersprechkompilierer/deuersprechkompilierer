/**
 * @file 	BesatzersprechErkanntException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass ein Bezeichner Besatzersprech enthält.
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class BesatzersprechErkanntException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String besatzersprechWortName;
	
	public BesatzersprechErkanntException(Token besatzersprechWort) {
		super(besatzersprechWort);
		this.besatzersprechWortName = besatzersprechWort.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " <" + besatzersprechWortName + ">" + System.lineSeparator()
		 + "Sprich Deutsch, du Hurensohn!" + System.lineSeparator();
	}
}
