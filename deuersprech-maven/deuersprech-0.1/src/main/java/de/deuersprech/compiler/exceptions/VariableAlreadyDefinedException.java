/**
 * @file 	VariableAlreadyDefined.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dasse nicht Variable bereits definiert wurde
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException{
	private static final long serialVersionUID = 1L;
	private String varName;
	
	public VariableAlreadyDefinedException(Token variableNameToken) {
		super(variableNameToken);
		this.varName = variableNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " Variable bereits definiert: <" + varName + ">";

	}
}
