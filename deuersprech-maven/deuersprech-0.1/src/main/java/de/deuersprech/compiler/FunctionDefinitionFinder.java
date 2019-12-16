/**
 * @file 	FunctionDefinitionFinder.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Findet Funktionsdefinitionen in einem ParseTree
 */

package de.deuersprech.compiler;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;

import de.deuersprech.compiler.FunctionList.FunctionDefinition;
import de.deuersprech.compiler.exceptions.FunctionAlreadyDefinedException;
import de.deuersprech.parser.ArithmeticBaseVisitor;
import de.deuersprech.parser.ArithmeticParser.FunctionDefinitionContext;
import de.deuersprech.parser.ArithmeticParser.VarDeclarationContext;

/**@brief
 * Die Klasse FunctionDefintionFinder wird vor dem eigentlichen Auswerten des ParseTree genutzt, um alle Funktionsdefinitionen zu pruefen  
 */
public class FunctionDefinitionFinder {
	
	/**@brief
	 * Die einzige Methode der Klasse. Besucht den Parsetree, um Funktionsdefintionen zu finden
	 * @param tree
	 * @return
	 */
	public static FunctionList findFunctions(ParseTree tree) {
		//legt eine Liste mit allen Funktionen an
		final FunctionList definedFunctions = new FunctionList();
		//nutzt den von ANTLR generierten Visitor
		new ArithmeticBaseVisitor<Void>() {
			//verarbeitet Funktionsdefintionen
			@Override
			public Void visitFunctionDefinition(FunctionDefinitionContext ctx) {
				String functName = ctx.functionName.getText();
				ArrayList<DataType> params = new ArrayList<>();
				for(VarDeclarationContext param : ctx.params.declarations) {
					params.add(MyArithmeticVisitor.toDataType(param.type.getText()));
				}
				DataType returnType = MyArithmeticVisitor.toDataType(ctx.type.getText());


				FunctionDefinition defCandidate = new FunctionDefinition(functName, params, returnType);

				//ueberprueft, ob ein funktionsbezeichner besatzersprech enthaelt
				/*Besatzersprech pruefer = new Besatzersprech();
				if(pruefer.istBesatzersprech(functName)) {
					throw new BesatzersprechErkanntException(ctx.functionName);					
				}
				*/
				//ueberprueft, ob eine funktion mit der gleichen signatur bereits vorhanden ist.
				if(definedFunctions.contains(defCandidate.getSignature())) {
					throw new FunctionAlreadyDefinedException(ctx.functionName);
				}
				
				//fuegt die Funktion der Liste hinzu
				definedFunctions.add(defCandidate);
				return null;
			}
		}.visit(tree);
		//gibt die Liste zurueck
		return definedFunctions;
	}
}
