/**
 * @file 	UndeclaredVariableException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dasse nicht deklarierte Variable aufgerufen wird
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends CompileException{
	private static final long serialVersionUID = 1L;
	private String varName;
	
	public UndeclaredVariableException(Token varNameToken) {
		super(varNameToken); 
		this.varName = varNameToken.getText();
	}


	@Override
	public String getMessage(){
		return line + ":" + column + " nicht deklarierte Variable <" + varName + ">";
	}
}
