/**
 * @file 	UndeclaredConstantException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dasse nicht definierte Funktion aufgerufen wird
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndefinedFunctionException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String functionName;
	
	public UndefinedFunctionException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}
	
	public String getMessage() {
		return "SIE BEGEHEN EINE STRAFTAT! " + line + ":" + column + " Ruf zu undefinierter Funktion: <" + functionName + ">";
	}
}
