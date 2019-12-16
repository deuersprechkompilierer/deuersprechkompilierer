/**
 * @file 	InvalidDatatypeAssignmentException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass eine Zuweisung mit inkompatiblen Datentypen aufgerufen wird.
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class InvalidDatatypeAssignmentException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String varNameStr;
	
	public InvalidDatatypeAssignmentException(Token invalidTypeName) {
		super(invalidTypeName);
		this.varNameStr = invalidTypeName.getText();
	}

	public String getMessage() {
		return line + ":" + column + " Zuweisung nicht möglich, inkompatibler Datentyp: <" + varNameStr + ">";
	}
}