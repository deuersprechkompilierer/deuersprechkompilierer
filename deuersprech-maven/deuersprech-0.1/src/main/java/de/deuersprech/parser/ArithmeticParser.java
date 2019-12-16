// Generated from ./Arithmetic.g4 by ANTLR 4.7.2
package de.deuersprech.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LPAREN=11, RPAREN=12, CONSTKEYWORD=13, PLUSOP=14, MINOP=15, MULTOP=16, 
		DIVOP=17, LT=18, LEQ=19, GT=20, GEQ=21, EQ=22, AND=23, OR=24, NOT=25, 
		ASSIGNOP=26, UMLAUT=27, DATATYPE=28, INTEGER=29, WS=30, STRING=31, ID=32;
	public static final int
		RULE_program = 0, RULE_progPart = 1, RULE_statement = 2, RULE_println = 3, 
		RULE_print = 4, RULE_constDeclaration = 5, RULE_varDeclaration = 6, RULE_assignment = 7, 
		RULE_functionDefinition = 8, RULE_functionCall = 9, RULE_statementList = 10, 
		RULE_parameterDeclaration = 11, RULE_expressionList = 12, RULE_branch = 13, 
		RULE_loop = 14, RULE_block = 15, RULE_expression = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "progPart", "statement", "println", "print", "constDeclaration", 
			"varDeclaration", "assignment", "functionDefinition", "functionCall", 
			"statementList", "parameterDeclaration", "expressionList", "branch", 
			"loop", "block", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'druckzeile('", "'druck('", "'{'", "'gebzurueck'", "'}'", 
			"','", "'wenn'", "'sonst'", "'waehrend'", "'('", "')'", "'konstante ganzzahl'", 
			"'PLUS'", "'MINUS'", "'MAL'", "'DURCH'", "'KLEINER'", "'KLEINERGLEICH'", 
			"'GROESSER'", "'GROESSERGLEICH'", "'GLEICH'", "'UND'", "'ODER'", "'NICHT'", 
			"'ISTGLEICH'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "LPAREN", 
			"RPAREN", "CONSTKEYWORD", "PLUSOP", "MINOP", "MULTOP", "DIVOP", "LT", 
			"LEQ", "GT", "GEQ", "EQ", "AND", "OR", "NOT", "ASSIGNOP", "UMLAUT", "DATATYPE", 
			"INTEGER", "WS", "STRING", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArithmeticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<ProgPartContext> progPart() {
			return getRuleContexts(ProgPartContext.class);
		}
		public ProgPartContext progPart(int i) {
			return getRuleContext(ProgPartContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				progPart();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << LPAREN) | (1L << CONSTKEYWORD) | (1L << NOT) | (1L << DATATYPE) | (1L << INTEGER) | (1L << STRING) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgPartContext extends ParserRuleContext {
		public ProgPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progPart; }
	 
		public ProgPartContext() { }
		public void copyFrom(ProgPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgPartFunctionDefContext extends ProgPartContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ProgPartFunctionDefContext(ProgPartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitProgPartFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MainStatementContext extends ProgPartContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainStatementContext(ProgPartContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMainStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgPartContext progPart() throws RecognitionException {
		ProgPartContext _localctx = new ProgPartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progPart);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new MainStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				statement();
				}
				break;
			case 2:
				_localctx = new ProgPartFunctionDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				functionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				println();
				setState(44);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				print();
				setState(47);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				constDeclaration();
				setState(50);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				varDeclaration();
				setState(53);
				match(T__0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				assignment();
				setState(56);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				expression(0);
				setState(59);
				match(T__0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(61);
				branch();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(62);
				loop();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintlnContext extends ParserRuleContext {
		public ExpressionContext argument;
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitPrintln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_println);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__1);
			setState(66);
			((PrintlnContext)_localctx).argument = expression(0);
			setState(67);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ExpressionContext argument;
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__2);
			setState(70);
			((PrintContext)_localctx).argument = expression(0);
			setState(71);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclarationContext extends ParserRuleContext {
		public Token constName;
		public TerminalNode CONSTKEYWORD() { return getToken(ArithmeticParser.CONSTKEYWORD, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(CONSTKEYWORD);
			setState(74);
			((ConstDeclarationContext)_localctx).constName = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public Token type;
		public Token varName;
		public TerminalNode DATATYPE() { return getToken(ArithmeticParser.DATATYPE, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			((VarDeclarationContext)_localctx).type = match(DATATYPE);
			setState(77);
			((VarDeclarationContext)_localctx).varName = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public Token varName;
		public ExpressionContext expr;
		public TerminalNode ASSIGNOP() { return getToken(ArithmeticParser.ASSIGNOP, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((AssignmentContext)_localctx).varName = match(ID);
			setState(80);
			match(ASSIGNOP);
			setState(81);
			((AssignmentContext)_localctx).expr = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Token type;
		public Token functionName;
		public ParameterDeclarationContext params;
		public StatementListContext statements;
		public ExpressionContext returnValue;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public TerminalNode DATATYPE() { return getToken(ArithmeticParser.DATATYPE, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((FunctionDefinitionContext)_localctx).type = match(DATATYPE);
			setState(84);
			((FunctionDefinitionContext)_localctx).functionName = match(ID);
			setState(85);
			match(LPAREN);
			setState(86);
			((FunctionDefinitionContext)_localctx).params = parameterDeclaration();
			setState(87);
			match(RPAREN);
			setState(88);
			match(T__3);
			setState(89);
			((FunctionDefinitionContext)_localctx).statements = statementList();
			setState(90);
			match(T__4);
			setState(91);
			((FunctionDefinitionContext)_localctx).returnValue = expression(0);
			setState(92);
			match(T__0);
			setState(93);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public Token functionName;
		public ExpressionListContext arguments;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((FunctionCallContext)_localctx).functionName = match(ID);
			setState(96);
			match(LPAREN);
			setState(97);
			((FunctionCallContext)_localctx).arguments = expressionList();
			setState(98);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << LPAREN) | (1L << CONSTKEYWORD) | (1L << NOT) | (1L << DATATYPE) | (1L << INTEGER) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				{
				setState(100);
				statement();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration;
		public List<VarDeclarationContext> declarations = new ArrayList<VarDeclarationContext>();
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameterDeclaration);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATATYPE) {
					{
					setState(106);
					((ParameterDeclarationContext)_localctx).varDeclaration = varDeclaration();
					((ParameterDeclarationContext)_localctx).declarations.add(((ParameterDeclarationContext)_localctx).varDeclaration);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((ParameterDeclarationContext)_localctx).varDeclaration = varDeclaration();
				((ParameterDeclarationContext)_localctx).declarations.add(((ParameterDeclarationContext)_localctx).varDeclaration);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(110);
					match(T__6);
					setState(111);
					((ParameterDeclarationContext)_localctx).varDeclaration = varDeclaration();
					((ParameterDeclarationContext)_localctx).declarations.add(((ParameterDeclarationContext)_localctx).varDeclaration);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> expressions = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressionList);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case NOT:
			case INTEGER:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				((ExpressionListContext)_localctx).expression = expression(0);
				((ExpressionListContext)_localctx).expressions.add(((ExpressionListContext)_localctx).expression);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(121);
					match(T__6);
					setState(122);
					((ExpressionListContext)_localctx).expression = expression(0);
					((ExpressionListContext)_localctx).expressions.add(((ExpressionListContext)_localctx).expression);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockContext onTrue;
		public BlockContext onFalse;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_branch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__7);
			setState(132);
			match(LPAREN);
			setState(133);
			((BranchContext)_localctx).condition = expression(0);
			setState(134);
			match(RPAREN);
			setState(135);
			((BranchContext)_localctx).onTrue = block();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(136);
				match(T__8);
				setState(137);
				((BranchContext)_localctx).onFalse = block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockContext onTrue;
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__9);
			setState(141);
			match(LPAREN);
			setState(142);
			((LoopContext)_localctx).condition = expression(0);
			setState(143);
			match(RPAREN);
			setState(144);
			((LoopContext)_localctx).onTrue = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__3);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7) | (1L << T__9) | (1L << LPAREN) | (1L << CONSTKEYWORD) | (1L << NOT) | (1L << DATATYPE) | (1L << INTEGER) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				{
				setState(147);
				statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTOP() { return getToken(ArithmeticParser.MULTOP, 0); }
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUSOP() { return getToken(ArithmeticParser.PLUSOP, 0); }
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExpressionContext {
		public Token varName;
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public Token constName;
		public TerminalNode ID() { return getToken(ArithmeticParser.ID, 0); }
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InverseGateContext extends ExpressionContext {
		public ExpressionContext expr;
		public TerminalNode NOT() { return getToken(ArithmeticParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InverseGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitInverseGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public Token txt;
		public TerminalNode STRING() { return getToken(ArithmeticParser.STRING, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndGateContext extends ExpressionContext {
		public ExpressionContext leftSide;
		public ExpressionContext rightSide;
		public TerminalNode AND() { return getToken(ArithmeticParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAndGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINOP() { return getToken(ArithmeticParser.MINOP, 0); }
		public SubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode INTEGER() { return getToken(ArithmeticParser.INTEGER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExpressionContext {
		public Token compareOp;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(ArithmeticParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(ArithmeticParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(ArithmeticParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(ArithmeticParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(ArithmeticParser.EQ, 0); }
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrGateContext extends ExpressionContext {
		public ExpressionContext leftSide;
		public ExpressionContext rightSide;
		public TerminalNode OR() { return getToken(ArithmeticParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrGateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitOrGate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIVOP() { return getToken(ArithmeticParser.DIVOP, 0); }
		public DivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(156);
				match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				((StringContext)_localctx).txt = match(STRING);
				}
				break;
			case 3:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				((VariableContext)_localctx).varName = match(ID);
				}
				break;
			case 4:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				((ConstantContext)_localctx).constName = match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(LPAREN);
				setState(161);
				expression(0);
				setState(162);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new InverseGateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(NOT);
				setState(165);
				((InverseGateContext)_localctx).expr = expression(2);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(190);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new DivisionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(170);
						match(DIVOP);
						setState(171);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(173);
						match(MULTOP);
						setState(174);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new SubtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(176);
						match(MINOP);
						setState(177);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(179);
						match(PLUSOP);
						setState(180);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(181);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(182);
						((ComparisonContext)_localctx).compareOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LEQ) | (1L << GT) | (1L << GEQ) | (1L << EQ))) != 0)) ) {
							((ComparisonContext)_localctx).compareOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(183);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new AndGateContext(new ExpressionContext(_parentctx, _parentState));
						((AndGateContext)_localctx).leftSide = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(185);
						match(AND);
						setState(186);
						((AndGateContext)_localctx).rightSide = expression(5);
						}
						break;
					case 7:
						{
						_localctx = new OrGateContext(new ExpressionContext(_parentctx, _parentState));
						((OrGateContext)_localctx).leftSide = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(188);
						match(OR);
						setState(189);
						((OrGateContext)_localctx).rightSide = expression(4);
						}
						break;
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00c6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\7\fh\n\f\f\f\16\fk\13\f\3\r\5\rn\n\r\3\r\3\r\3\r\7\rs\n\r\f\r\16\r"+
		"v\13\r\3\r\5\ry\n\r\3\16\3\16\3\16\7\16~\n\16\f\16\16\16\u0081\13\16\3"+
		"\16\5\16\u0084\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008d\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u0097\n\21\f\21\16\21\u009a"+
		"\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00aa\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00c1\n\22"+
		"\f\22\16\22\u00c4\13\22\3\22\2\3\"\23\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"\2\3\3\2\24\30\2\u00d3\2%\3\2\2\2\4+\3\2\2\2\6A\3\2\2\2\bC\3"+
		"\2\2\2\nG\3\2\2\2\fK\3\2\2\2\16N\3\2\2\2\20Q\3\2\2\2\22U\3\2\2\2\24a\3"+
		"\2\2\2\26i\3\2\2\2\30x\3\2\2\2\32\u0083\3\2\2\2\34\u0085\3\2\2\2\36\u008e"+
		"\3\2\2\2 \u0094\3\2\2\2\"\u00a9\3\2\2\2$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2),\5\6\4\2*,\5\22\n\2+)\3\2\2\2+*\3\2"+
		"\2\2,\5\3\2\2\2-.\5\b\5\2./\7\3\2\2/B\3\2\2\2\60\61\5\n\6\2\61\62\7\3"+
		"\2\2\62B\3\2\2\2\63\64\5\f\7\2\64\65\7\3\2\2\65B\3\2\2\2\66\67\5\16\b"+
		"\2\678\7\3\2\28B\3\2\2\29:\5\20\t\2:;\7\3\2\2;B\3\2\2\2<=\5\"\22\2=>\7"+
		"\3\2\2>B\3\2\2\2?B\5\34\17\2@B\5\36\20\2A-\3\2\2\2A\60\3\2\2\2A\63\3\2"+
		"\2\2A\66\3\2\2\2A9\3\2\2\2A<\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CD"+
		"\7\4\2\2DE\5\"\22\2EF\7\16\2\2F\t\3\2\2\2GH\7\5\2\2HI\5\"\22\2IJ\7\16"+
		"\2\2J\13\3\2\2\2KL\7\17\2\2LM\7\"\2\2M\r\3\2\2\2NO\7\36\2\2OP\7\"\2\2"+
		"P\17\3\2\2\2QR\7\"\2\2RS\7\34\2\2ST\5\"\22\2T\21\3\2\2\2UV\7\36\2\2VW"+
		"\7\"\2\2WX\7\r\2\2XY\5\30\r\2YZ\7\16\2\2Z[\7\6\2\2[\\\5\26\f\2\\]\7\7"+
		"\2\2]^\5\"\22\2^_\7\3\2\2_`\7\b\2\2`\23\3\2\2\2ab\7\"\2\2bc\7\r\2\2cd"+
		"\5\32\16\2de\7\16\2\2e\25\3\2\2\2fh\5\6\4\2gf\3\2\2\2hk\3\2\2\2ig\3\2"+
		"\2\2ij\3\2\2\2j\27\3\2\2\2ki\3\2\2\2ln\5\16\b\2ml\3\2\2\2mn\3\2\2\2ny"+
		"\3\2\2\2ot\5\16\b\2pq\7\t\2\2qs\5\16\b\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2"+
		"tu\3\2\2\2uy\3\2\2\2vt\3\2\2\2wy\3\2\2\2xm\3\2\2\2xo\3\2\2\2xw\3\2\2\2"+
		"y\31\3\2\2\2z\177\5\"\22\2{|\7\t\2\2|~\5\"\22\2}{\3\2\2\2~\u0081\3\2\2"+
		"\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0084\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0082\u0084\3\2\2\2\u0083z\3\2\2\2\u0083\u0082\3\2\2\2\u0084\33\3\2"+
		"\2\2\u0085\u0086\7\n\2\2\u0086\u0087\7\r\2\2\u0087\u0088\5\"\22\2\u0088"+
		"\u0089\7\16\2\2\u0089\u008c\5 \21\2\u008a\u008b\7\13\2\2\u008b\u008d\5"+
		" \21\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\35\3\2\2\2\u008e"+
		"\u008f\7\f\2\2\u008f\u0090\7\r\2\2\u0090\u0091\5\"\22\2\u0091\u0092\7"+
		"\16\2\2\u0092\u0093\5 \21\2\u0093\37\3\2\2\2\u0094\u0098\7\6\2\2\u0095"+
		"\u0097\5\6\4\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7\b\2\2\u009c!\3\2\2\2\u009d\u009e\b\22\1\2\u009e\u00aa\7\37\2"+
		"\2\u009f\u00aa\7!\2\2\u00a0\u00aa\7\"\2\2\u00a1\u00aa\7\"\2\2\u00a2\u00a3"+
		"\7\r\2\2\u00a3\u00a4\5\"\22\2\u00a4\u00a5\7\16\2\2\u00a5\u00aa\3\2\2\2"+
		"\u00a6\u00a7\7\33\2\2\u00a7\u00aa\5\"\22\4\u00a8\u00aa\5\24\13\2\u00a9"+
		"\u009d\3\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9\u00a1\3\2"+
		"\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00c2\3\2\2\2\u00ab\u00ac\f\13\2\2\u00ac\u00ad\7\23\2\2\u00ad\u00c1\5"+
		"\"\22\f\u00ae\u00af\f\n\2\2\u00af\u00b0\7\22\2\2\u00b0\u00c1\5\"\22\13"+
		"\u00b1\u00b2\f\t\2\2\u00b2\u00b3\7\21\2\2\u00b3\u00c1\5\"\22\n\u00b4\u00b5"+
		"\f\b\2\2\u00b5\u00b6\7\20\2\2\u00b6\u00c1\5\"\22\t\u00b7\u00b8\f\7\2\2"+
		"\u00b8\u00b9\t\2\2\2\u00b9\u00c1\5\"\22\b\u00ba\u00bb\f\6\2\2\u00bb\u00bc"+
		"\7\31\2\2\u00bc\u00c1\5\"\22\7\u00bd\u00be\f\5\2\2\u00be\u00bf\7\32\2"+
		"\2\u00bf\u00c1\5\"\22\6\u00c0\u00ab\3\2\2\2\u00c0\u00ae\3\2\2\2\u00c0"+
		"\u00b1\3\2\2\2\u00c0\u00b4\3\2\2\2\u00c0\u00b7\3\2\2\2\u00c0\u00ba\3\2"+
		"\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3#\3\2\2\2\u00c4\u00c2\3\2\2\2\20\'+Aimtx\177\u0083"+
		"\u008c\u0098\u00a9\u00c0\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}