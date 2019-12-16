/**
 * @file 	ConstantReassignException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass eine zweite Zuweisung auf eine Konstante aufgerufen wird.
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ConstantReassignException extends CompileException {

	private static final long serialVersionUID = 1L;
	private String constName;
	
	public ConstantReassignException(Token ConstantNameToken) {
		super(ConstantNameToken);
		this.constName = ConstantNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " einer Konstannte darf nur ein Mal ein Wert zugewiesen werden: <" + constName + ">";

	}
	
}
