/**
 * @file 	CompileException.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Basisklasse für Exceptions zur Kompilierzeit
 */
package de.deuersprech.compiler.exceptions;

import org.antlr.v4.runtime.Token;

/**@brief
 * Basisklasse fuer Exceptions zur Compile-Zeit
 */
public class CompileException extends RuntimeException {
	private static final long serialVersionUID = -3546840023649947687L;
	protected int line;
	protected int column;
	
	public CompileException(Token token) {
		this.line = token.getLine();
		this.column = token.getCharPositionInLine();
	}
}
