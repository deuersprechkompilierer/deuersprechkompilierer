/**
 * @file 	JvmStack.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	16.12.2019
 * repräsentiert den JVM-internen Stack und speichert Datentypen der Elemente
 */

package de.deuersprech.compiler;

import java.util.Deque;
import java.util.LinkedList;

/**
 * repräsentiert den JVM-internen Stack
 */
public class JvmStack {
    /**
     * deque zum speichern der liste
     */
    private Deque<DataType> typesOnStack = new LinkedList<>();

    /**
     * legt wert auf stack
     * @param type  der auf den stack zu legende Datentyp
     */
    public void push(DataType type) {
        //System.out.println("jvmstack push: " + type);
        typesOnStack.push(type);
    }

    /**
     * nimmt wert vom stack
     * @return heruntergenommener wert (datentyp)
     */
    public DataType pop() {
        DataType retValue = typesOnStack.pop();
        //System.out.println("jvmstack pop : " + retValue);
        return retValue;
    }
}

