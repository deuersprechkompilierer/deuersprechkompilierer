/**
 * @file 	FunctionAlreadyDefinedException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass eine Funktion mit gleicher Signatur bereits definiert wurde.
 * Die Signatur setzt sich aus Rückgabetyp, Bezeichner und Parameterliste zusammen.
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class FunctionAlreadyDefinedException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String functionName;
	
	public FunctionAlreadyDefinedException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}

	public String getMessage() {
		return line + ":" + column + " Funktion bereits definiert: <" + functionName + ">";

	}
	
}
