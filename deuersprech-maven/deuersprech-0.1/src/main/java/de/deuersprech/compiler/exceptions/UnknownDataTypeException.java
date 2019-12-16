package de.deuersprech.compiler.exceptions;

public class UnknownDataTypeException extends Exception {
    private String varName;
    private static final long serialVersionUID = 1L;
    
    public UnknownDataTypeException(String varName) {
        super(varName);
        this.varName = varName;
    }

    public String getMessage() {
		return "Datentyp von <" + varName + "> nicht bekannt!";
	}
}