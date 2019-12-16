grammar Arithmetic;

//////////////////////////////////////////////////////////////////////////////////
//Token-Definitionen															//
//////////////////////////////////////////////////////////////////////////////////
LPAREN : '(';		  		//oeffndende runde klammer							//
RPAREN : ')';		  		//schliessende runde klammer						//
CONSTKEYWORD: 'konstante ganzzahl';	//Konstant - Keyword						//
																				//
//mathematische operatoren														//
PLUSOP : 'PLUS';																//
MINOP  : 'MINUS';																//
MULTOP : 'MAL';																	//
DIVOP  : 'DURCH';																//
																				//
//vergleichsoperatoren															//
LT  : 'KLEINER'  ;																//
LEQ : 'KLEINERGLEICH' ;															//
GT  : 'GROESSER'  ;																//
GEQ : 'GROESSERGLEICH' ;														//
EQ  : 'GLEICH' ;																//
																				//
//logische verknuepfungen														//
AND : 'UND' ;																	//
OR : 'ODER'  ;																	//
NOT : 'NICHT'  ;																//
																				//
//sonstige operatoren															//
ASSIGNOP : 'ISTGLEICH';															//
UMLAUT: '\u00c4' | '\u00e4' | '\u00d6' | '\u00f6' | '\u00dc' | '\u00fc' ;		//
DATATYPE: 'ganzzahl' | 'kette' ;
//bezeichner																	//
INTEGER : [0-9]+ ;         	//beliebige folge der ziffern 0 bis 9				//
WS : [ \t\r\n]+ -> skip ;	//ueberspringt spaces, tabstops, linefeeds			//
STRING: '"' .*? '"';
ID: ('a'..'z' | 'A'..'Z' | UMLAUT)('a'..'z' | 'A'..'Z' | '0'..'9' | UMLAUT)*;	//
//////////////////////////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////////////////
//Grundlegende Regeln													//
//////////////////////////////////////////////////////////////////////////
//Startregel/axiom														//
program : progPart+ 													//
		;																//
																		//
progPart : statement 			#MainStatement							//
         | functionDefinition   #ProgPartFunctionDef					//
         ;																//
																		//
statement : println ';'													//
		  | print ';'													//
		  | constDeclaration ';'										//
		  | varDeclaration ';'											//
		  | assignment ';'	
		  | expression ';'											//
//		  | constAssignment ';'											//
		  | branch 														//
		  | loop														//
		  ;																//
		  	  						 									//
//Regel fuer Ausgabefunktion											//
println : 'druckzeile(' argument=expression ')' 						//
		;																//
print 	: 'druck(' argument=expression ')' 								//
		;																//
//////////////////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////////////////
//Regeln fuer Konstanten												//
//////////////////////////////////////////////////////////////////////////
constDeclaration : CONSTKEYWORD constName=ID	 						//
			     ;														//
//constAssignment : constName=ID ASSIGNOP expr=expression				//
//			;															//
//////////////////////////////////////////////////////////////////////////


	
		  

//////////////////////////////////////////////////////////////////////////
//Regeln fuer Variablen													//
//////////////////////////////////////////////////////////////////////////
varDeclaration : type=DATATYPE varName=ID 								//
			   ;														//
																		//
assignment : varName=ID ASSIGNOP expr=expression						//
			;															//
//////////////////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////////////////
//Regeln fuer Funktionen												//
//////////////////////////////////////////////////////////////////////////
functionDefinition : 													//
	type=DATATYPE functionName=ID LPAREN params=parameterDeclaration RPAREN 	//
		'{' 															//
			statements=statementList 							//
			'gebzurueck' returnValue=expression ';'						//
		'}' 															//
		 		   ;													//
																		//
functionCall : functionName=ID LPAREN arguments=expressionList RPAREN 	//
			 ;															//
																		//
statementList : statement*												//
			  ;															//
																		//
parameterDeclaration : 													//
	declarations+=varDeclaration?
		| declarations+=varDeclaration (',' declarations+=varDeclaration)*	//
					|													//
					;													//
																		//
expressionList : expressions+=expression (',' expressions+=expression)*	//
			   |														//
			   ;														//
//////////////////////////////////////////////////////////////////////////




		  
//////////////////////////////////////////////////////////////////////////
//Regeln fuer Kontrollstrukturen										//
//////////////////////////////////////////////////////////////////////////
branch : 'wenn' '(' condition=expression ')' 							//
			onTrue=block 												//
		('sonst' 														//
			onFalse=block)?												//
	   ;																//
																		//
loop : 'waehrend' '(' condition=expression ')' onTrue=block				//
	 ;																	//
																		//
block : '{' statement* '}' 												//
	  ;																	//
//////////////////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////////////////
//Regeln fuer math. Ausdruecke											//
//////////////////////////////////////////////////////////////////////////
expression: INTEGER									#Number				//
	| txt=STRING									#String 			//
	| varName=ID									#Variable			//
	| constName=ID									#Constant			//
	| LPAREN expression RPAREN						#Parenthesis		//
	| expression DIVOP  expression  				#Division			//
	| expression MULTOP expression					#Multiplication		//
	| expression MINOP  expression  				#Subtraction		//
	| expression PLUSOP expression  				#Addition			//
	| expression compareOp=(LT | LEQ | GT | GEQ | EQ) expression	#Comparison
	| leftSide=expression AND rightSide=expression	#AndGate			//
	| leftSide=expression OR rightSide=expression	#OrGate				//
	| NOT expr=expression							#InverseGate		//
	| functionCall 									#functionCallExpression
	;																	//
//////////////////////////////////////////////////////////////////////////
