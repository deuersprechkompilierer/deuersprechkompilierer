// Generated from ./Arithmetic.g4 by ANTLR 4.7.2
package de.deuersprech.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ArithmeticParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainStatement}
	 * labeled alternative in {@link ArithmeticParser#progPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainStatement(ArithmeticParser.MainStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProgPartFunctionDef}
	 * labeled alternative in {@link ArithmeticParser#progPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgPartFunctionDef(ArithmeticParser.ProgPartFunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArithmeticParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(ArithmeticParser.PrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ArithmeticParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(ArithmeticParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(ArithmeticParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ArithmeticParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(ArithmeticParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ArithmeticParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(ArithmeticParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(ArithmeticParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(ArithmeticParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(ArithmeticParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(ArithmeticParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ArithmeticParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(ArithmeticParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(ArithmeticParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ArithmeticParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(ArithmeticParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InverseGate}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInverseGate(ArithmeticParser.InverseGateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ArithmeticParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndGate}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndGate(ArithmeticParser.AndGateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(ArithmeticParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(ArithmeticParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ArithmeticParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ArithmeticParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(ArithmeticParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrGate}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrGate(ArithmeticParser.OrGateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(ArithmeticParser.DivisionContext ctx);
}