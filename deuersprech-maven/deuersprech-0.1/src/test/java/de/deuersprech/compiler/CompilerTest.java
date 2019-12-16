/**
 * @file 	CompilerTest.java
 * @author 	https://github.com/deuersprechkompilierer
 * @date	14.12.2019
 * Testfälle für den Deuersprechkompilierer
 */

package de.deuersprech.compiler;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.deuersprech.compiler.exceptions.ConstantAlreadyDefinedException;
import de.deuersprech.compiler.exceptions.ConstantReassignException;
import de.deuersprech.compiler.exceptions.FunctionAlreadyDefinedException;
import de.deuersprech.compiler.exceptions.UndeclaredVariableException;
import de.deuersprech.compiler.exceptions.UndefinedFunctionException;
import de.deuersprech.compiler.exceptions.VariableAlreadyDefinedException;
import jasmin.ClassFile;

public class CompilerTest {
	private Path tempDir;
	
	@BeforeMethod
	public void createTempDir() throws Exception {
		tempDir = Files.createTempDirectory("compilerTest");
	}
	
	@AfterMethod
	public void delteTempDir() {
		deleteRecursive(tempDir.toFile());
	}
	
	private void deleteRecursive(File file) {
		if (file.isDirectory()) {
			for(File child : file.listFiles()) {
				deleteRecursive(child);
			}
		} 
		if (!file.delete() ) {
			throw new Error("Could not delete file <" + file + ">");
		}
	}

	@Test(dataProvider = "provide_code_expectedText")
	public void runningCode_outputsExpectedText(String description, String code, String expectedText) throws Exception {
		
		//execution
		String actualOutput = compileAndRun(code);
	  
		//evaluation
		Assert.assertEquals(actualOutput, expectedText);
	}

	@DataProvider
	public Object[][] provide_code_expectedText() throws Exception {
		return new Object[][] {
			{"verkettete arithmetik", "druckzeile(12345 PLUS 2 PLUS 3 PLUS 4 PLUS 5 PLUS 2 MAL 10 MINUS 48 MAL (4 MINUS 1) MINUS 16 DURCH 4);", "12231" + System.lineSeparator()},
			{"addition", "druckzeile(1 PLUS 4);", "5" + System.lineSeparator()}, 
			{"mehrere druckzeile aussagen","druckzeile(1234); druckzeile(151);", "1234" + System.lineSeparator() + "151" + System.lineSeparator() },
			{"mehrere druck aussagen","druck(1234); druck(151);", "1234" + "151"  },
			{"mehrere druckzeile aussagen mit arithmetik", "druckzeile(666); druckzeile(1234 PLUS 5); druckzeile(1 PLUS 1);", "666" + System.lineSeparator() + "1239" + System.lineSeparator() + "2" +System.lineSeparator() },
			{"arithmetic links nach rechts add sub", "druckzeile(8 MINUS 2 PLUS 5);", "11" + System.lineSeparator()},
			{"arithmetic links nach rechts mul div", "druckzeile(8 DURCH 2 MAL 4);", "16" + System.lineSeparator()},
			{"ordnung der opertationen (sog. punkt vor strich)","druckzeile(9 MINUS 2 MAL 3);", "3" + System.lineSeparator()},
			
			{"variablen und arithmetic", example("variables/arithmetic"), "2" + System.lineSeparator() + "60" + System.lineSeparator() },
			
			{"simple functions", example("functions/simple"), "42" + System.lineSeparator()},
			
			{"functions with statement in body", example("functions/function_body"), "42" + System.lineSeparator()},
			//testet Scopes, i wird sowohl in randomNumber() als auch im main-Scope definiert 
			{"scopes", example("functions/scopes"), "42" + System.lineSeparator() + "2" + System.lineSeparator() },
			//testet Funktionsparameter
			{"function parameters", example("functions/parameters"), "7" + System.lineSeparator() },
			//testet, ob mehrere Funktionen mit gleichem Namen, aber unterschiedlicher Parameterliste moeglich sind
			{"functions with equal name but different signature", example("functions/equal_name_different_signature"), "42" + System.lineSeparator() + "23" + System.lineSeparator() },
			//teste conditional branches
			{"if-else-statement with false", example("branch/if_int_false") , "69" + System.lineSeparator()} ,
			{"if-else-statement with true", example("branch/if_int_true") , "42" + System.lineSeparator()},
			
			{"lower than evaluates to true", "druckzeile(3 KLEINER 4);", "1" + System.lineSeparator()},
			{"lower than evaluates to false", "druckzeile(4 KLEINER 4);", "0" + System.lineSeparator()},
			
			{"lower or equal evaluates to true", "druckzeile(3 KLEINERGLEICH 4);", "1" + System.lineSeparator()},
			{"lower or equal evaluates to true", "druckzeile(4 KLEINERGLEICH 4);", "1" + System.lineSeparator()},
			{"lower or equal evaluates to false", "druckzeile(5 KLEINERGLEICH 4);", "0" + System.lineSeparator()},
			
			{"greater than evaluates to true", "druckzeile(4 GROESSER 3);", "1" + System.lineSeparator()},
			{"greater than evaluates to false", "druckzeile(4 GROESSER 4);", "0" + System.lineSeparator()},
			
			{"greater or equal evaluates to true", "druckzeile(5 GROESSERGLEICH 4);", "1" + System.lineSeparator()},
			{"greater or equal evaluates to true", "druckzeile(4 GROESSERGLEICH 4);", "1" + System.lineSeparator()},
			{"greater or equal evaluates to false", "druckzeile(3 GROESSERGLEICH 4);", "0" + System.lineSeparator()},
			
			{"false and false", "druckzeile(0 UND 0);", "0" + System.lineSeparator()},
			{"true and false", "druckzeile(1 UND 0);", "0" + System.lineSeparator()},
			{"false and true", "druckzeile(0 UND 1);", "0" + System.lineSeparator()},
			{"true and true", "druckzeile(1 UND 1);", "1" + System.lineSeparator()},
			
			{"false or false", "druckzeile(0 ODER 0);", "0" + System.lineSeparator()},
			{"true or false", "druckzeile(1 ODER 0);", "1" + System.lineSeparator()},
			{"false or true", "druckzeile(0 ODER 1);", "1" + System.lineSeparator()},
			{"true or true", "druckzeile(1 ODER 1);", "1" + System.lineSeparator()},
			
			{"notGate true", "druckzeile(NICHT 1);", "0" + System.lineSeparator()},
			{"notGate false", "druckzeile(NICHT 0);", "1" + System.lineSeparator()},
			
			{"loop test", example("loops/sum_from_0_to_5"), 
				"0" + System.lineSeparator() + 
				"1" + System.lineSeparator() +
				"3" + System.lineSeparator() + 
				"6" + System.lineSeparator() + 
				"10"+ System.lineSeparator()},
			
			{"simple test for constant usage", example("constants/simpleTest"), "42" + System.lineSeparator()},
			{"drucke kettenliteral", "druck(\"hallo welt\");", "hallo welt"},
			{"zeichenkette variable", example("strings/stringDeclaration"), "hallo deuersprech" + System.lineSeparator()},
			{"zeichenkette funktion rueckgabe", example("strings/returnString"), "aight"},
			{"zeichenkette funktion uebergabe", example("strings/stringAsFunctParam"), "hallo"},
		};
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:11 nicht deklarierte Variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifReadingUndefinedVariable() throws Exception{
		//execution
		compileAndRun("druckzeile(x);");
		//evaluation performed by expceted exception
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:0 nicht deklarierte Variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifWritingUndefinedVariable() throws Exception{
		//execution
		compileAndRun("x ISTGLEICH 5;");
		//evaluation performed by expceted exception
	}
		
	@Test(expectedExceptions = VariableAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:9 Variable bereits definiert: <x>")
	public void compilingCode_throwsVariableAlreadyDefiniedException_whenRedifingVariable() throws Exception{
		//execution
		compileAndRun("ganzzahl x;" + System.lineSeparator() + "ganzzahl x;");
		//evaluation performed by expceted exception
	}

	@Test(expectedExceptions = UndefinedFunctionException.class, expectedExceptionsMessageRegExp = "SIE BEGEHEN EINE STRAFTAT! 1:11 Ruf zu undefinierter Funktion: <undefinedFunct>")
	public void compilingCode_throwsUndefinedFunctionException_whenCallingUndefinedFunction() throws Exception{
		//execution
		compileAndRun("druckzeile(undefinedFunct());");
		//evaluation performed by expceted exception
	}
	
	@Test(expectedExceptions = FunctionAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:9 Funktion bereits definiert: <test>")
	public void compilingCode_throwsFunctionAlreadyDefinedException_whenDefiningAlreadyDefinedFunction() throws Exception{
		//execution
		compileAndRun("ganzzahl test() { gebzurueck 123; } \nganzzahl test() { gebzurueck 123; } ");
		//evaluation performed by expceted exception
	}

	@Test(expectedExceptions = ConstantAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:19 Konstante bereits definiert: <X>")
	public void compilingCode_throwsConstantAlreadyDefiniedException_whenRedifingConstant() throws Exception{
		//execution
		compileAndRun("konstante ganzzahl X;" + System.lineSeparator() + "konstante ganzzahl X;");
		//evaluation performed by expceted exception
	}
	
	@Test(expectedExceptions = ConstantReassignException.class, expectedExceptionsMessageRegExp = "3:0 einer Konstannte darf nur ein Mal ein Wert zugewiesen werden: <X>")
	public void compilingCode_throwsConstantReassignException_whenRedifingConstant() throws Exception{
		//execution
		compileAndRun("konstante ganzzahl X;" + System.lineSeparator() + "X ISTGLEICH 3;" + System.lineSeparator() + "X ISTGLEICH 5;");
		//evaluation performed by expceted exception
	}
	
	
	private static String example(String fileName) throws Exception {
		try(InputStream in = CompilerTest.class.getResourceAsStream("/examples/" + fileName + ".txt")) {
			if(in == null) {
				throw new IllegalArgumentException("No such example <" + fileName + ">");
			}
			return new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		}
	}
		
	private String compileAndRun(String code) throws Exception {
		CharStream test = CharStreams.fromString(code);
		code = Main.compile(test);
		//System.out.println(code);
		ClassFile classFile = new ClassFile();
		classFile.readJasmin(new StringReader(code), "", false);
		Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
		try(OutputStream out = Files.newOutputStream(outputPath)) {
			classFile.write(out);
		}
		//	classFile.write(Files.newOutputStream(outputPath));
		return runJavaClass(tempDir, classFile.getClassName());
	}

	private String runJavaClass(Path dir, String className) throws Exception{
		Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
		try(InputStream in = process.getInputStream()) {
			return new Scanner(in).useDelimiter("\\A").next();
		}
	}
}
