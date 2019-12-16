/**
 * @file 	DataType.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * enum für die beiden zulässigen Deuersprech-Datentypen
 */
package de.deuersprech.compiler;

import javax.xml.crypto.Data;

/**
 * enum fuer Deuersprech-Datentypen
 */
public enum DataType {
    INT("I"), STRING("Ljava/lang/String;");

    /**
     * jasmin-datentyp als string
     */
    private final String JVM_TPE;

    /**
     * konstruktor
     * @param jvmTape jasmin-datentyp als string
     */
    DataType(String jvmTape) {
        this.JVM_TPE = jvmTape;
    }

    /**
     * @return datentyp in jasmin-syntax 
     */
    public String getJvmType() {
        return JVM_TPE;
    }

    /**
     * vergleicht zwei DataType-Objekte auf Gleichheit
     * @param right rechte Seite des Vergleichs
     * @return true wenn gleich, sonst false
     */
    public boolean equals(DataType right) {
        // self check
        if (this == right) {
            return true;
        }
        // null check
        if (right == null) {
            return false;
        }
        // type check and cast
        if (getClass() != right.getClass()) {
            return false;
        }

        // field comparison
        return  (this.JVM_TPE.equals(right.JVM_TPE))  ;
    }

}