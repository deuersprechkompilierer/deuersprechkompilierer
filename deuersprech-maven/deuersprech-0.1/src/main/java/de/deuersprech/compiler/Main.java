/**
 * @file 	Main.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Main-Klasse des Deuersprechkompilierers
 */
package de.deuersprech.compiler;

import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import de.deuersprech.parser.ArithmeticLexer;
import de.deuersprech.parser.ArithmeticParser;
import jasmin.ClassFile;

public class Main {
	public static void main(String[] args) throws Exception {
		String inputFile = "";				
		
		for (String s: args) {
	        inputFile = s;
	    }
	
		CharStream input = CharStreams.fromFileName(inputFile);
		createBytecode(input);
	}
	
	/**
	 * ruft compile-Funktion auf und schreibt .class-Datei in aktuelles Verzeichnis
	 * @param inputStream eingabe-text
	 * @throws Exception
	 */
	static void createBytecode(CharStream inputStream) throws Exception {
		//setzt outputDir zu aktuellem verzeichnis
		Path outputDir = FileSystems.getDefault().getPath("./");
		
		//generieren von JasminCode
		String code = compile(inputStream);

		//System.out.println(code);

		//Jasmin-Aufruf
		ClassFile classFile = new ClassFile();
		classFile.readJasmin(new StringReader(code), "", false);
		
		//.class datei schreiben
		Path outputPath = outputDir.resolve(classFile.getClassName() + ".class");
		try(OutputStream out = Files.newOutputStream(outputPath)) {
			classFile.write(out);
		}
	}

	/**
	 * startet lexer, parser und visitor
	 * @param input eingabe-Text
	 * @return jasmin-code
	 */
	public static String compile(CharStream input) {
		ArithmeticLexer ariLex = new ArithmeticLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(ariLex);
		ArithmeticParser ariParser = new ArithmeticParser(tokens);

		//Syntax-Baum
		ParseTree tree = ariParser.program();

		//ermittelt zunaechst alle Funktionsdefinitionen, damit keine Vowaertsdeklarationen benoetigt werden
		FunctionList definedFunctions = FunctionDefinitionFinder.findFunctions(tree);
		
		return createJasminFile(new MyArithmeticVisitor(definedFunctions).visit(tree));
	}

	/**
	 * fuegt restliche benoetigte Statements hinzu
	 * @param instructions jasmin-code
	 * @return vollständiger jasmin-code
	 */
	private static String createJasminFile(String instructions) {
		return ".class public deuersprechAusstelle\n" + 
				".super java/lang/Object\n" + 
				"\n" + 
				instructions;
	}
}