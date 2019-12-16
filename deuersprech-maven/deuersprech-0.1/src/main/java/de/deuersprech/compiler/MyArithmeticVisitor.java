/**
 * @file 	MyArithmeticVisitor.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * @brief 
 * nutzt einen von ANTLR generierten Visitor, um aus einem Parsetree Code in Jasmin-Syntax zu erstellen
 */

package de.deuersprech.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StringContent;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import de.deuersprech.compiler.FunctionList.FunctionDefinition;
import de.deuersprech.compiler.exceptions.BesatzersprechErkanntException;
import de.deuersprech.compiler.exceptions.BezeichnerOhneUmalutException;
import de.deuersprech.compiler.exceptions.ConstantAlreadyDefinedException;
import de.deuersprech.compiler.exceptions.ConstantReassignException;
import de.deuersprech.compiler.exceptions.InvalidDatatypeAssignmentException;
import de.deuersprech.compiler.exceptions.UndeclaredVariableException;
import de.deuersprech.compiler.exceptions.UndefinedFunctionException;
import de.deuersprech.compiler.exceptions.UnknownDataTypeException;
import de.deuersprech.compiler.exceptions.VariableAlreadyDefinedException;
import de.deuersprech.parser.ArithmeticBaseVisitor;
import de.deuersprech.parser.ArithmeticVisitor;
import de.deuersprech.parser.ArithmeticParser.AdditionContext;
import de.deuersprech.parser.ArithmeticParser.AndGateContext;
import de.deuersprech.parser.ArithmeticParser.AssignmentContext;
import de.deuersprech.parser.ArithmeticParser.BranchContext;
import de.deuersprech.parser.ArithmeticParser.ComparisonContext;
import de.deuersprech.parser.ArithmeticParser.ConstDeclarationContext;
import de.deuersprech.parser.ArithmeticParser.ConstantContext;
import de.deuersprech.parser.ArithmeticParser.DivisionContext;
import de.deuersprech.parser.ArithmeticParser.ExpressionContext;
import de.deuersprech.parser.ArithmeticParser.FunctionCallContext;
import de.deuersprech.parser.ArithmeticParser.FunctionDefinitionContext;
import de.deuersprech.parser.ArithmeticParser.InverseGateContext;
import de.deuersprech.parser.ArithmeticParser.LoopContext;
import de.deuersprech.parser.ArithmeticParser.MainStatementContext;
import de.deuersprech.parser.ArithmeticParser.MultiplicationContext;
import de.deuersprech.parser.ArithmeticParser.NumberContext;
import de.deuersprech.parser.ArithmeticParser.OrGateContext;
import de.deuersprech.parser.ArithmeticParser.PrintContext;
import de.deuersprech.parser.ArithmeticParser.PrintlnContext;
import de.deuersprech.parser.ArithmeticParser.ProgramContext;
import de.deuersprech.parser.ArithmeticParser.StringContext;
import de.deuersprech.parser.ArithmeticParser.SubtractionContext;
import de.deuersprech.parser.ArithmeticParser.VarDeclarationContext;
import de.deuersprech.parser.ArithmeticParser.VariableContext;


/**
 * @brief
 * Die Klasse MyArithmeticVisitor baut auf ANTLR-generiertem Code auf und implementiert die Jasmin-Code-Erzeugung auf Grundlage des vom Parser erstellen Syntaxbaum.
 */
public class MyArithmeticVisitor extends ArithmeticBaseVisitor<String> {
	/**@brief
	 * Speichert Variablen. Dabei ist der key der Bezeichner der Variable und value der Index in der lokalen Variablentabell der JVM
	 */
	private Map<String, Integer> variables = new HashMap<>();
	/**@brief
	 * Speichert Schreibzugriffen auf Konstanten. Dabei ist der key der Bezeichner der Konstante und value die Zahl der Lesezugriffe in der lokalen Konstantentabell der JVM
	 */
	private Map<String, Boolean> constantsHasBeenAssigned = new HashMap<>();
	/**@brief
	 * Speichert definierte Funktionen.
	 */
	private FunctionList definedFunctions;
	/**
	 * speichert datentyp von werten auf jvm stack
	 */
	private JvmStack jvmStack = new JvmStack();
	/**
	 *  speichert zugehörigen datentyp von variable
	 */
	private Map<String, DataType> varTypeMap = new HashMap<>();
	/**@brief
	 * Zaehlt, wie viele if-else-statements vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int branchCount = 0;
	/**@brief
	 * Zaehlt, wie viele vergleiche vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int comparisonCount = 0;
	/**@brief
	 * Zaehlt, wie viele logische verknuepfungen vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int gateCount = 0;
	/**@brief
	 * Zaehlt, wie viele schleifen vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int loopCount = 0;
	/**
	 * kann einen String auf Besatzersprech überprüfen und ggf. eine Ausnahme, die den Benutzer beleidigt, auslösen
	 */
	private Besatzersprech besatzersprechPruefer = new Besatzersprech();
	
	/**
	 * Konstruktor der Klasse MyArithmeticVisitor
	 * @param definedFunctions Liste mit definierten Funktionen
	 */
	public MyArithmeticVisitor(FunctionList definedFunctions) {
		if(definedFunctions == null) {
			throw new NullPointerException("definedFunctions");
		} 
		this.definedFunctions = definedFunctions;
	}
	
	////////////////////////////////GRUNDLEGENDES////////////////////////////////
	//Startpunkt des Programms
	public String visitProgram(ProgramContext ctx) {
		//es wird zwischen code f.d. main-funktion
		String mainCode = "";
		//und code von restlichen funktionen unterschieden, damit entsprechende definitionen im jasmin-code korrekt getrennt werden
		String functions = "";
		
		//iteriert ueber alle statements, um o.g. unterscheidung zu treffen
		for(int i = 0; i < ctx.getChildCount(); i++) {
			//besucht je einen knoten
			ParseTree child = ctx.getChild(i);
			String generatedCode = visit(child);
			
			//entscheidet, ob main-scope oder andere funktion
			if(child instanceof MainStatementContext) {
				mainCode += generatedCode + "\n";
			} else {
				functions += generatedCode + "\n";
			}
		}
		
		//gibt entsprechenden jasmin-code zurück
		return functions + "\n" + ".method public static main([Ljava/lang/String;)V\n" + 
				"  .limit stack 100\n" + 
				"  .limit locals 100\n" + 
				mainCode + "\n" +
				"  return\n" + 
				".end method\n";
	}

	/**@brief
	 * vearbeitet den Aufruf der println-Funktion
	 */
	public String visitPrintln(PrintlnContext ctx) {
		String argumentInstructions = visit(ctx.argument);
		DataType type = jvmStack.pop();

		return  ";calling print\n" + 
				"getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 	//legt ein System.out Objekt auf den Stack
				argumentInstructions + //"\n" +						//Argument der print-Funktion
				"invokevirtual java/io/PrintStream/println(" + type.getJvmType() + ")V\n\n"; 			//ruft die Methode println des System.out-Objekts auf
	}

	/**@brief
	 * vearbeitet den Aufruf der print-Funktion
	 */
	public String visitPrint(PrintContext ctx) {
		String argumentInstructions = visit(ctx.argument);
		DataType type = jvmStack.pop();

		return  ";calling print\n" + 
				"getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 	//legt ein System.out Objekt auf den Stack
				argumentInstructions + //"\n" +						//Argument der print-Funktion
				"invokevirtual java/io/PrintStream/print(" + type.getJvmType() + ")V\n\n"; 			//ruft die Methode println des System.out-Objekts auf
	}


	/**@brief
	 * verarbeitet ganze Zahlen
	 */
	public String visitNumber(NumberContext ctx) {
		jvmStack.push(DataType.INT);
		return "ldc " + ctx.getChild(0) + "\n";
	}
	
	/**@brief
	 * verarbeitet strings
	 */
	public String visitString(StringContext ctx) {
		jvmStack.push(DataType.STRING);
		return "ldc " + ctx.txt.getText() + "\n";
	}

	//Ja, es stimmt: Literale von negativen Zahlen können noch nicht richtig geparsed werden.
	/**@brief
	 * verarbeitet negative ganze Zahlen
	 */
	/*public String visitNegativeNumber(NegativeNumberContext ctx) {
		return "bipush -" + ctx.getChild(1) + "\n"; 
	}*/
	
	/**@brief
	 * verarbeitet Zuweisungen. 
	 * Es erfolgt ein Zugriff auf die Variablen-Map, um den Index der lokalen Variablentabelle zu erhalten.
	 */
	public String visitAssignment(AssignmentContext ctx) {
		int index = -1;
		
		/*
		if(determineDatatype(ctx.varName.getText()).equals(DataType.STRING) && (ctx.expr instanceof StringContext) ) {
			throw new InvalidDatatypeAssignmentException(ctx.varName);
		}
		*/

		//wenn kein eintrag vorhanden ist, muss es eine variable sein
		if(constantsHasBeenAssigned.get(ctx.varName.getText()) == null) {
			index = requireVariableIndex(ctx.varName);
		} 
		//bei konstanten:
		//wenn bereits ein wert zugewiesen wurde, darf dies nicht erneut geschehen
		else if (constantsHasBeenAssigned.get(ctx.varName.getText()) == true) {
			throw new ConstantReassignException(ctx.varName);
		} 
		//falls erste zuweisung
		else {
			index = requireVariableIndex(ctx.varName);
			constantsHasBeenAssigned.put(ctx.varName.getText(), true);
		}
		
		String instructions =  visit(ctx.expr) + "\n"; 
		if(determineDatatype(ctx.varName).equals(DataType.STRING)) {
			instructions += "astore  " + index;
		} else /*if(determineDatatype(ctx.varName.getText()).equals(DataType.INT)) */{
			instructions += "istore " + index + "\n";
		}

		jvmStack.pop();
		return instructions;
	}

	
	////////////////////////////////VARIABLEN////////////////////////////////////
	/**@brief
	 * verarbeitet Variablen-Deklarationen.
	 * Der Name der Variable wird in der Hashmap variables mit dem zugehoerigen Index in der Variablentabelle gespeichert 
	 */
	public String visitVarDeclaration(VarDeclarationContext ctx) {
		if(variables.containsKey(ctx.varName.getText())) {
			throw new VariableAlreadyDefinedException(ctx.varName);
		}
		
		if(ctx.varName.getText().length() > 2) {
			if(besatzersprechPruefer.istBesatzersprech(ctx.varName.getText())) {
				throw new BesatzersprechErkanntException(ctx.varName);
			}
			
			if(!UmlautDetektor.hatUmlaut(ctx.varName.getText())) {
				throw new BezeichnerOhneUmalutException(ctx.varName);
			}
		}
		
		variables.put(ctx.varName.getText(), variables.size());	//speichert in variablen tabelle
		varTypeMap.put(ctx.varName.getText(), toDataType(ctx.type.getText()));

		return ";delclaration\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von Variablen
	 * Es erfolgt ein Zugriff auf die Variablen-Map, um den Index der lokalen Variablentabelle zu erhalten.
	 */
	public String visitVariable(VariableContext ctx) {
		if(determineDatatype(ctx.varName).equals(DataType.INT)) {
			jvmStack.push(DataType.INT);
			return "iload " + requireVariableIndex(ctx.varName) + "\n";
		} else {
			jvmStack.push(DataType.STRING);
			return "aload " + requireVariableIndex(ctx.varName) + "\n";
		}
	}
	
	
	////////////////////////////////KONSTANTEN///////////////////////////////////
	/**@brief
	 * verarbeitet Konstanten-Deklarationen.
	 * Der Name der Konstante wird in der Hashmap constants mit dem zugehoerigen Index in der Konstantentabelle gespeichert 
	 */
	public String visitConstDeclaration(ConstDeclarationContext ctx) {
		if(variables.containsKey(ctx.constName.getText())) {
			throw new ConstantAlreadyDefinedException(ctx.constName);
		}
		variables.put(ctx.constName.getText(), variables.size());	//speichert in constants tabelle
		varTypeMap.put(ctx.constName.getText(), DataType.INT);
		constantsHasBeenAssigned.put(ctx.constName.getText(), false);
		return ";delclaration\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von Konstanten
	 * Es erfolgt ein Zugriff auf die Konstanten-Map, um den Index der lokalen Konstantentabelle zu erhalten.
	 */
	public String visitConstant(ConstantContext ctx) {
		return "iload " 
			 + requireVariableIndex(ctx.constName)
			 + "\n";
	}

	
	////////////////////////////////FUNKTIONEN///////////////////////////////////
	/**@brief
	 * verarbeitet funktions-aufrufe
	 */
	public String visitFunctionCall(FunctionCallContext ctx) {
		String instructions = "";
		
		//verarbeitet ggf. uebergebene parameter
		String argumentInstructions = visit(ctx.arguments);
		if(argumentInstructions != null) {
			instructions += argumentInstructions + "\n";
		}
		
		//passende funktion suchen
		String functName = ctx.functionName.getText();
		ArrayList<DataType> params = new ArrayList<>();
		for(int i = ctx.arguments.expressions.size() - 1; i >= 0; i--) {
			params.add(jvmStack.pop());
		}
		DataType returnType = DataType.INT;
		FunctionDefinition toBeCalled = new FunctionDefinition(functName, params, returnType);
		
		//ueberprueft, ob Funktion definiert wurde
		if(definedFunctions.contains(toBeCalled.getSignature())) {
			returnType = DataType.INT;
		} else if(definedFunctions.contains(new FunctionDefinition(functName, params, DataType.STRING).getSignature() )) {
			returnType = DataType.STRING;
		} else {
			throw new UndefinedFunctionException(ctx.functionName);
		}
		
		//jasmin-instruction um funktion aufzurufen
		instructions +=  "invokestatic deuersprechAusstelle/" + ctx.functionName.getText() + toBeCalled.getParamSignature() + returnType.getJvmType() + "\n";
	
		jvmStack.push(returnType);
		return instructions;
	}
	
	/**@brief
	 * verarbeitet funktions-deklarationen 
	 */
	public String visitFunctionDefinition(FunctionDefinitionContext ctx) {
		//kopiert die variablentabelle, um unterschiedliche scopes zu ermoeglichen
		Map<String, Integer> oldVariables = variables;
		JvmStack oldJvmStack = jvmStack;
		jvmStack = new JvmStack();

		//neue hasmap fuer den aktuellen gueltigkeitsbereich
		variables = new HashMap<>();
		//verarbeitet parameter-deklarationen der funktion
		visit(ctx.params);
		
		//verarbeitet funktionsrumpf
		String statementInstructions = visit(ctx.statements);
		
		//generiert korrekte signatur 
		String result = ".method public static " + ctx.functionName.getText() + "(";

		for(VarDeclarationContext elem : ctx.params.declarations) {
			if( toDataType(elem.type.getText()).equals(DataType.INT) ) {
				result += "I";
			} else if(toDataType(elem.type.getText()).equals(DataType.STRING)) {
				result += "Ljava/lang/String;";
			}
		}

		String returnType = ctx.type.getText();
		if(toDataType(returnType).equals(DataType.INT)) {
			result += ")I\n";
		} else if(toDataType(returnType).equals(DataType.STRING)) {
			result += ")Ljava/lang/String;\n";
		}

		String returnStatement = ""; 
		if(toDataType(returnType).equals(DataType.STRING)) {
			returnStatement = "areturn\n";
		} else {
			returnStatement = "ireturn\n";
		} 

		result += ".limit locals 100\n"
			 + ".limit stack 100\n"
			 //fuehrt instructions in korrekter reihenfolge zusammen
			 + (statementInstructions == null ? " " : statementInstructions + "\n")
			 + visit(ctx.returnValue) + "\n"
			 + returnStatement
			 //+ "ireturn\n"
			 + ".end method\n";
		
		jvmStack.pop();

		//stellt die variablen-tabelle des vorangegangenen gueltigkeitsbereich wieder her
		variables = oldVariables;
		jvmStack = oldJvmStack;
		return result;
	}
	
	
	////////////////////////////////KONTROLLSTRUKTUREN///////////////////////////
	/**@brief
	 * verarbeitet if-else-statements
	 * (im moment *nur* if-else!)
	 */
	public String visitBranch(BranchContext ctx) {
		String conditionInstructions = visit(ctx.condition);
		jvmStack.pop();
		String onTrueInstructions = visit(ctx.onTrue);
		String onFalseInstructions = visit(ctx.onFalse);
		/*es muss ein index mitgezählt 
		  und angegeben werden, da sonst bei mehreren if-else-statements 
		  die labels nicht mehr eindeutig waeren*/
		branchCount++;	
		
		return conditionInstructions + "\n"
				//jasmin instruction, die zum angegebenen label springt, 
				//falls der wert auf dem stack != 0
				+ "ifne ifTrueLabel" + branchCount + "\n"
				//falls nicht gesprungen wurde, also wert auf dem stack == 0, 
				//werden die onFalseInstructions geladen
				+ onFalseInstructions + "\n"
				//und die onTrueInstructions uebersprungen
				+ "goto endIfLabel" + branchCount + "\n"
				+ "ifTrueLabel" + branchCount + ":\n"
				+ onTrueInstructions + "\n"
				+ "endIfLabel" + branchCount + ":\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von while-Schleifen
	 */
	public String visitLoop(LoopContext ctx) {
		String conditionInstructions = visit(ctx.condition);
		String onTrueInstructions = visit(ctx.onTrue);
		//es muss ein counter mitgezaehlt werden, um die labels im jasmin code eindeutig benennen zu koennen
		loopCount++;
			
		return ";check condition\n" + 
				//bedingung fuer die schleife
				"conditionLabel" + loopCount + ":\n" + 
				conditionInstructions + "\n" +
				//wenn die bedingung true ist
				//sprung zum rumpf der schleife + 
				"ifne onTrueWhileLabel" + loopCount + "\n" + 
				//sonst abbruch der schleife 
				"goto endOfWhileLabel" + loopCount + "\n" +
				
				//funktionsrump
				"onTrueWhileLabel" + loopCount + ":\n" + 
				onTrueInstructions + "\n" +
				//am ende wird die condition erneut geprueft
				
				"goto conditionLabel" + loopCount + "\n" +
				//label fuer abbruch
				"endOfWhileLabel" + loopCount + ":" + "\n";
	}
	
	
	///////////////////////////////ARITHMETIK UND LOGIK//////////////////////////
	/**@brief
	 * verarbeitet Divisionen
	 */
	public String visitDivision(DivisionContext ctx) {
		String instructions =  visitChildren(ctx) + "\n"
							+ "idiv\n";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	/**@brief
	 * verarbeitet Multiplikationen
	 */
	public String visitMultiplication(MultiplicationContext ctx) {
		String instructions =  visitChildren(ctx) + "\n"
							+ "imul\n";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	/**@brief
	 * verarbeitet Subtraktionen
	 */
	public String visitSubtraction(SubtractionContext ctx) {
		String instructions =  visitChildren(ctx) + "\n"
							+ "isub\n";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	/**@brief
	 * verarbeitet Additionen
	 */
	public String visitAddition(AdditionContext ctx) {
		String instructions =  visitChildren(ctx) + "\n"
							+ "iadd\n";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	/**@brief
	 * verarbeitet aufrufe von vergleichsoperatoren
	 */
	public String visitComparison(ComparisonContext ctx) {
		//zaehler haelt sprung labels eindeutig
		comparisonCount++;
		String compareInstruction = "";
		
		//jasmin aurufe fuer enstsprechende vergleiche
		switch(ctx.compareOp.getText()) {
			case "KLEINER": 
				compareInstruction = "if_icmplt";
				break;
			case "KLEINERGLEICH":
				compareInstruction = "if_icmple";
				break;
			case "GROESSER":
				compareInstruction = "if_icmpgt ";
				break;
			case "GROESSERGLEICH":
				compareInstruction = "if_icmpge";
				break;
			case "GLEICH":
				compareInstruction = "if_icmpeq";
				break;
			default:
				throw new IllegalArgumentException("Unbekannter Operator (STRAFTAT!!!): " + ctx.compareOp.getText());
		}
		
		String instructions = visitChildren(ctx) + "\n"
			+ compareInstruction + 
			//wenn vergleich wahr ist, sprung zu onTrueLabel
			" onTrueLabel" + comparisonCount + "\n" + 
  
			//wenn vergleich falsch ist und kein sprung erfolgt, 
			//wird eine 0 fuer false auf den stack geladen
			"ldc 0 \n" + 
			//ueberspringt true case
			"goto onFalseLabel" + comparisonCount + "\n" +
		
			//nach dem onTrueLabel wird eine 1 fuer true auf den stack geladen
			"onTrueLabel" + comparisonCount + ":\n" + 
			"ldc 1 \n" + 
			"onFalseLabel" + comparisonCount + ":\n" ;

		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);

		return instructions;
	}
	
	/**@brief
	 * verarbeitet aufrufe des logischen und (&&)
	 */
	public String visitAndGate(AndGateContext ctx) {
		String leftSide = visit(ctx.leftSide);
		String rightSide = visit(ctx.rightSide);
		//zaehler haelt labels eindeutig
		gateCount++;
		
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);

		return leftSide + 
				//wenn die linke seite false ist, muss der gesamte ausdruck false sein
				"ifeq onFalseAndLabel" + gateCount + "\n" + 
				rightSide + 
				//wenn die rechte seite false ist, muss der gesamte ausdruck false sein
				"ifeq onFalseAndLabel" + gateCount + "\n" + 
				
				//falls beide seiten true sind und nicht gesprungen wurde
				//wird eine 1 fuer true auf den stack gelegt
				"ldc 1\n" + 
				//und der false-teil uebersprungen
				"goto onTrueAndLabel" + gateCount + "\n" + 
				
				//falls zu diesem label gesprungen wurde
				"onFalseAndLabel" + gateCount + ":\n" + 
				//muss das ergebnis false (== 0) sein
				"ldc 0\n" + 
				"onTrueAndLabel"+ gateCount + ":\n";
	}
	
	/**@brief
	 * verarbeitet aurufe des logischen oder (||)
	 */
	public String visitOrGate(OrGateContext ctx) {
		String leftSide = visit(ctx.leftSide);
		String rightSide = visit(ctx.rightSide);
		//zaehler haelt labels eindeutig
		gateCount++;

		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);

		return leftSide + 
				//wenn die linke seite true ist, muss der gesamte ausdruck true sein
				"ifne onTrueOrLabel" + gateCount + "\n" + 
				rightSide +
				//wenn die rechte seite true ist, muss der gesamte ausdruck true sein
				"ifne onTrueOrLabel" + gateCount + "\n" + 
				
				//wenn keine der seiten true ist, wird eine 0 fuer false auf den stack geladen
				"ldc 0\n" + 
				//und der true-teil uebersprungen
				"goto onFalseOrLabel" + gateCount + "\n" + 
				
				//wenn mindestens eine der seiten true ist
				//und zu diesem label gesprungen wird
				"onTrueOrLabel" + gateCount + ":\n" + 
				//wird eine 1 fuer true auf den stack gelegt
				"ldc 1\n" + 
				"onFalseOrLabel" + gateCount + ":\n"; 
	}
	
	/**@brief
	 * verarbeitet aufrufe des logischen nicht (!)
	 */
	public String visitInverseGate(InverseGateContext ctx) {
		String expr = visit(ctx.expr);
		//zaehler haelt labels eindeutig
		gateCount++;
		
		jvmStack.pop();
		jvmStack.push(DataType.INT);

		return expr + 
				//wenn der ausdruck = false ist wird zum entsprechenden label gesprungen
				"ifeq onFalseNotLabel" + gateCount + "\n" + 
				//wenn nicht gesprungen wurde war der ausdruck true 
				//und es wird entsprechend eine 0 fuer false auf den stack gelegt
				"ldc 0\n" + 
				//ueberspringt restlichen code
				"goto onTrueNotLabel" + gateCount + "\n" + 
				
				//label das eine 1 fuer true auf den stack legt, wenn die eingabe 0 war
				"onFalseNotLabel" + gateCount + ":\n" + 
				"ldc 1 \n" + 
				"onTrueNotLabel" + gateCount + ":\n\n";
	}
	
		
	////////////////////////////////HILFSFUNKTIONEN (intern)//////////////////////
	/**@brief
	 * Simple Hilfsfunktion, die einen gegebenen String count-mal mit sich selbst konkateniert 
	 * @param string	Ausgangsstring, der wiederholt werden soll
	 * @param count		Anzahl der Wiederholungen
	 * @return			Zusammengesetzter String
	 */
	private String stringRepeat(String string, int count) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < count; i++) {
			result.append(string);
		}
		return result.toString();
	}

	/**@brief
	 * Loest den Namen einer Variablen zu dessen Index in der lokalen Variablentabelle auf
	 * @param varNameToken	Token mit dem Namen der Variablen
	 * @return				Index der Variablen in der lokalen Variablentabelle falls gefunden
	 */
	private int requireVariableIndex(Token varNameToken) {
		Integer varIndex = variables.get(varNameToken.getText());
		//falls variable nicht existiert
		if(varIndex == null) {
			throw new UndeclaredVariableException(varNameToken);
		}
		return varIndex;
	}
	
	/**@brief
	 * spezifiziert, wie zwei Strings konkateniert werden
	 */
	protected String aggregateResult(String aggregate, String nextResult) {
		if(aggregate == null) {
			return nextResult;
		}
		if(nextResult == null) {
			return aggregate;
		} else {
			return aggregate + nextResult;
		}
	}

	/**
	 * löst einen Variablen-Bezeichner zu einem DataType auf
	 * wirft ggf. eine UndeclaredVariableExceptioin
	 */
	private DataType determineDatatype(Token varName) /*throws Exception*/ {
		if(!varTypeMap.containsKey(varName.getText())) {
			throw new UndeclaredVariableException(varName);
		}
		return varTypeMap.get(varName.getText());
	}

	/**
	 * löst einen String (reserviertes Schlüsselwort für Typbezeichnung) zu einem DataType auf
	 * @param type	reserviertes Schlüsselwort für Typ
	 * @return		zugehöriges DataType-Objekt
	 */
	public static DataType toDataType(String type) {
		if(type.equals("ganzzahl")) {
			return DataType.INT;
		} else {
			return DataType.STRING;
		}
	}
}
