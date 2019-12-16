// Generated from c:\Users\noahh\deuersprech-repo\deuersprech-maven\deuersprech-0.1\grammar\Arithmetic.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LPAREN=11, RPAREN=12, CONSTKEYWORD=13, PLUSOP=14, MINOP=15, MULTOP=16, 
		DIVOP=17, LT=18, LEQ=19, GT=20, GEQ=21, EQ=22, AND=23, OR=24, NOT=25, 
		ASSIGNOP=26, UMLAUT=27, DATATYPE=28, INTEGER=29, WS=30, STRING=31, ID=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "LPAREN", "RPAREN", "CONSTKEYWORD", "PLUSOP", "MINOP", "MULTOP", 
		"DIVOP", "LT", "LEQ", "GT", "GEQ", "EQ", "AND", "OR", "NOT", "ASSIGNOP", 
		"UMLAUT", "DATATYPE", "INTEGER", "WS", "STRING", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'druckzeile('", "'druck('", "'{'", "'gebzurueck'", "'}'", 
		"','", "'wenn'", "'sonst'", "'waehrend'", "'('", "')'", "'konstante ganzzahl'", 
		"'PLUS'", "'MINUS'", "'MAL'", "'DURCH'", "'KLEINER'", "'KLEINERGLEICH'", 
		"'GROESSER'", "'GROESSERGLEICH'", "'GLEICH'", "'UND'", "'ODER'", "'NICHT'", 
		"'ISTGLEICH'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "LPAREN", 
		"RPAREN", "CONSTKEYWORD", "PLUSOP", "MINOP", "MULTOP", "DIVOP", "LT", 
		"LEQ", "GT", "GEQ", "EQ", "AND", "OR", "NOT", "ASSIGNOP", "UMLAUT", "DATATYPE", 
		"INTEGER", "WS", "STRING", "ID"
	};
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


	public ArithmeticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0128\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u0107\n\35\3\36\6\36\u010a\n\36\r\36\16\36\u010b"+
		"\3\37\6\37\u010f\n\37\r\37\16\37\u0110\3\37\3\37\3 \3 \7 \u0117\n \f "+
		"\16 \u011a\13 \3 \3 \3!\3!\5!\u0120\n!\3!\3!\7!\u0124\n!\f!\16!\u0127"+
		"\13!\3\u0118\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"\3\2\7\b\2\u00c6\u00c6\u00d8\u00d8\u00de\u00de"+
		"\u00e6\u00e6\u00f8\u00f8\u00fe\u00fe\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\"+
		"c|\5\2\62;C\\c|\2\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2"+
		"\2\5E\3\2\2\2\7Q\3\2\2\2\tX\3\2\2\2\13Z\3\2\2\2\re\3\2\2\2\17g\3\2\2\2"+
		"\21i\3\2\2\2\23n\3\2\2\2\25t\3\2\2\2\27}\3\2\2\2\31\177\3\2\2\2\33\u0081"+
		"\3\2\2\2\35\u0094\3\2\2\2\37\u0099\3\2\2\2!\u009f\3\2\2\2#\u00a3\3\2\2"+
		"\2%\u00a9\3\2\2\2\'\u00b1\3\2\2\2)\u00bf\3\2\2\2+\u00c8\3\2\2\2-\u00d7"+
		"\3\2\2\2/\u00de\3\2\2\2\61\u00e2\3\2\2\2\63\u00e7\3\2\2\2\65\u00ed\3\2"+
		"\2\2\67\u00f7\3\2\2\29\u0106\3\2\2\2;\u0109\3\2\2\2=\u010e\3\2\2\2?\u0114"+
		"\3\2\2\2A\u011f\3\2\2\2CD\7=\2\2D\4\3\2\2\2EF\7f\2\2FG\7t\2\2GH\7w\2\2"+
		"HI\7e\2\2IJ\7m\2\2JK\7|\2\2KL\7g\2\2LM\7k\2\2MN\7n\2\2NO\7g\2\2OP\7*\2"+
		"\2P\6\3\2\2\2QR\7f\2\2RS\7t\2\2ST\7w\2\2TU\7e\2\2UV\7m\2\2VW\7*\2\2W\b"+
		"\3\2\2\2XY\7}\2\2Y\n\3\2\2\2Z[\7i\2\2[\\\7g\2\2\\]\7d\2\2]^\7|\2\2^_\7"+
		"w\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2bc\7e\2\2cd\7m\2\2d\f\3\2\2\2ef\7\177"+
		"\2\2f\16\3\2\2\2gh\7.\2\2h\20\3\2\2\2ij\7y\2\2jk\7g\2\2kl\7p\2\2lm\7p"+
		"\2\2m\22\3\2\2\2no\7u\2\2op\7q\2\2pq\7p\2\2qr\7u\2\2rs\7v\2\2s\24\3\2"+
		"\2\2tu\7y\2\2uv\7c\2\2vw\7g\2\2wx\7j\2\2xy\7t\2\2yz\7g\2\2z{\7p\2\2{|"+
		"\7f\2\2|\26\3\2\2\2}~\7*\2\2~\30\3\2\2\2\177\u0080\7+\2\2\u0080\32\3\2"+
		"\2\2\u0081\u0082\7m\2\2\u0082\u0083\7q\2\2\u0083\u0084\7p\2\2\u0084\u0085"+
		"\7u\2\2\u0085\u0086\7v\2\2\u0086\u0087\7c\2\2\u0087\u0088\7p\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\u008b\7\"\2\2\u008b\u008c\7i\2"+
		"\2\u008c\u008d\7c\2\2\u008d\u008e\7p\2\2\u008e\u008f\7|\2\2\u008f\u0090"+
		"\7|\2\2\u0090\u0091\7c\2\2\u0091\u0092\7j\2\2\u0092\u0093\7n\2\2\u0093"+
		"\34\3\2\2\2\u0094\u0095\7R\2\2\u0095\u0096\7N\2\2\u0096\u0097\7W\2\2\u0097"+
		"\u0098\7U\2\2\u0098\36\3\2\2\2\u0099\u009a\7O\2\2\u009a\u009b\7K\2\2\u009b"+
		"\u009c\7P\2\2\u009c\u009d\7W\2\2\u009d\u009e\7U\2\2\u009e \3\2\2\2\u009f"+
		"\u00a0\7O\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2\7N\2\2\u00a2\"\3\2\2\2\u00a3"+
		"\u00a4\7F\2\2\u00a4\u00a5\7W\2\2\u00a5\u00a6\7T\2\2\u00a6\u00a7\7E\2\2"+
		"\u00a7\u00a8\7J\2\2\u00a8$\3\2\2\2\u00a9\u00aa\7M\2\2\u00aa\u00ab\7N\2"+
		"\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7K\2\2\u00ad\u00ae\7P\2\2\u00ae\u00af"+
		"\7G\2\2\u00af\u00b0\7T\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7M\2\2\u00b2\u00b3"+
		"\7N\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7P\2\2\u00b6"+
		"\u00b7\7G\2\2\u00b7\u00b8\7T\2\2\u00b8\u00b9\7I\2\2\u00b9\u00ba\7N\2\2"+
		"\u00ba\u00bb\7G\2\2\u00bb\u00bc\7K\2\2\u00bc\u00bd\7E\2\2\u00bd\u00be"+
		"\7J\2\2\u00be(\3\2\2\2\u00bf\u00c0\7I\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2"+
		"\7Q\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7U\2\2\u00c4\u00c5\7U\2\2\u00c5"+
		"\u00c6\7G\2\2\u00c6\u00c7\7T\2\2\u00c7*\3\2\2\2\u00c8\u00c9\7I\2\2\u00c9"+
		"\u00ca\7T\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7G\2\2\u00cc\u00cd\7U\2\2"+
		"\u00cd\u00ce\7U\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7T\2\2\u00d0\u00d1"+
		"\7I\2\2\u00d1\u00d2\7N\2\2\u00d2\u00d3\7G\2\2\u00d3\u00d4\7K\2\2\u00d4"+
		"\u00d5\7E\2\2\u00d5\u00d6\7J\2\2\u00d6,\3\2\2\2\u00d7\u00d8\7I\2\2\u00d8"+
		"\u00d9\7N\2\2\u00d9\u00da\7G\2\2\u00da\u00db\7K\2\2\u00db\u00dc\7E\2\2"+
		"\u00dc\u00dd\7J\2\2\u00dd.\3\2\2\2\u00de\u00df\7W\2\2\u00df\u00e0\7P\2"+
		"\2\u00e0\u00e1\7F\2\2\u00e1\60\3\2\2\2\u00e2\u00e3\7Q\2\2\u00e3\u00e4"+
		"\7F\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6\7T\2\2\u00e6\62\3\2\2\2\u00e7\u00e8"+
		"\7P\2\2\u00e8\u00e9\7K\2\2\u00e9\u00ea\7E\2\2\u00ea\u00eb\7J\2\2\u00eb"+
		"\u00ec\7V\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7K\2\2\u00ee\u00ef\7U\2\2\u00ef"+
		"\u00f0\7V\2\2\u00f0\u00f1\7I\2\2\u00f1\u00f2\7N\2\2\u00f2\u00f3\7G\2\2"+
		"\u00f3\u00f4\7K\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6\7J\2\2\u00f6\66\3\2"+
		"\2\2\u00f7\u00f8\t\2\2\2\u00f88\3\2\2\2\u00f9\u00fa\7i\2\2\u00fa\u00fb"+
		"\7c\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7|\2\2\u00fd\u00fe\7|\2\2\u00fe"+
		"\u00ff\7c\2\2\u00ff\u0100\7j\2\2\u0100\u0107\7n\2\2\u0101\u0102\7m\2\2"+
		"\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2\u0104\u0105\7v\2\2\u0105\u0107"+
		"\7g\2\2\u0106\u00f9\3\2\2\2\u0106\u0101\3\2\2\2\u0107:\3\2\2\2\u0108\u010a"+
		"\t\3\2\2\u0109\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c<\3\2\2\2\u010d\u010f\t\4\2\2\u010e\u010d\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0113\b\37\2\2\u0113>\3\2\2\2\u0114\u0118\7$\2\2\u0115"+
		"\u0117\13\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\7$\2\2\u011c@\3\2\2\2\u011d\u0120\t\5\2\2\u011e\u0120\5\67\34\2"+
		"\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120\u0125\3\2\2\2\u0121\u0124"+
		"\t\6\2\2\u0122\u0124\5\67\34\2\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2"+
		"\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126B\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\n\2\u0106\u010b\u0110\u0118\u011f\u0123\u0125"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}