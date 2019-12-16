/**
 * @file 	UndeclaredConstantException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Exception für den Fall, dasse nicht deklarierte Konstante aufgerufen wird
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredConstantException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String constName;
	
	public UndeclaredConstantException(Token constNameToken) {
		super(constNameToken); 
		this.constName = constNameToken.getText();
	}


	@Override
	public String getMessage(){
		return line + ":" + column + " nicht deklarierte Konstante <" + constName + ">";
	}
}