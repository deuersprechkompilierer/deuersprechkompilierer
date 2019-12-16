/**
 * @file 	ConstantAlreadyDefinedException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dass eine Konstante mit gleichem Bezeichner bereits existiert.
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ConstantAlreadyDefinedException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String constName;
	
	public ConstantAlreadyDefinedException(Token constNameToken) {
		super(constNameToken);
		this.constName = constNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " Konstante bereits definiert: <" + constName + ">";

	}
}
