grammar MiLenguaje;

start_grammar: (substatement)*; //(start_statement (substatement)+ end_statement)+;

substatement: if|for|dec|while|print|assign;//IF|WHILE|FOR|FUNCTION;

if: start_statement IF condex (substatement)+ (elseif)* (else|) end_statement;

for: start_statement FOR  dec TOKEN_SEMICOLON condex TOKEN_SEMICOLON assign (substatement)+ end_statement;

while: start_statement WHILE condex (substatement)+ end_statement;

assign: id TOKEN_ASSIGN arith;

elseif: start_statement ELSEIF condex (substatement)+ end_statement;

else: start_statement ELSE (substatement)+ end_statement;

dec: INTEGER_DEC id|FLOAT_DEC id;

print: PRINT arith;

integer: (START_NUMBER number END_NUMBER)+;

float: (START_NUMBER number END_NUMBER)+ TOKEN_PERIOD (START_NUMBER number END_NUMBER)+;

id: (START_LETTER word END_LETTER)(integer|START_LETTER word END_LETTER)*;

number: literal_0|literal_1 | literal_2|literal_3|literal_4|literal_5|literal_6|literal_7|literal_8|literal_9;

word: literal_a|literal_b|literal_c|literal_d|literal_e|literal_f|literal_g|literal_h|literal_i|literal_j|literal_k|literal_l|literal_m|literal_n|literal_o|literal_p|literal_r|literal_s|literal_u|literal_v|literal_w|literal_x|literal_z;

logic_operator: TKN_GEQ|TKN_GREAT|TOKEN_LESS|TOKEN_NEQ|TOKEN_LEQ|TKN_EQUAL;
binarie_operator: AND|OR;
arith_operator: TKN_MINUS|TKN_PLUS|TKN_TIMES|TOKEN_DIV|TKN_MOD;


arith:  TOKEN_OPEN_PAR arith TOKEN_CLOSE_PAR
        |(TKN_PLUS|TKN_PLUS) arith
        |arith arith_operator arith
        |integer
        |float
        |id;

condex: NOT TOKEN_OPEN_PAR condex TOKEN_CLOSE_PAR (binarie_operator condex)*
        |arith logic_operator arith (binarie_operator condex)*
        | TOKEN_OPEN_PAR condex TOKEN_CLOSE_PAR (binarie_operator condex)*;


// Digits into braille logic
literal_0: '|}<'|'|<}'|'<|}'|'<}|'|'<}|'|'}|<'|'}<|';
literal_1: '+';
literal_2: '+<' | '<+';
literal_3: '+|' | '|+';
literal_4: '+|}' | '|}+' | '}+|' | '}|+' | '|+}' | '+}|';
literal_5: '+}' | '}+';
literal_6: '<+|' | '<|+' | '|<+' | '|+<' | '+<|' | '+|<';
literal_7: '+|<}'|'+|}<'|'+}|<'|'+}<|'|'+<|}'|'+<}|'|'<+|}'|'<+}|'|'<}+|'|'<}|+'|'<|+}'|'<|}+'|'}|<+'|'}|+<'|'}+<|'|'}+|<'|'}<|+'|'}<+|'|'|+<}'|'|+}<'|'|}<+'|'|}+<'|'|<+}'|'|<}+';
literal_8: '+<}'|'+}<'|'}+<'|'}<+'|'<}+'|'<+}';
literal_9: '<|'|'|<';


// Letters into braille logic

literal_a: '+' ;
literal_b: '+<' | '<+';
literal_c: '+|' | '|+' ;
literal_d: '+|}' | '|}+' | '}+|' | '}|+' | '|+}' | '+}|';
literal_e: '+}' | '+}';
literal_f: '<+|' | '<|+' | '|<+' | '|+<' | '+<|' | '+|<';
literal_g: '+|<}'|'+|}<'|'+}|<'|'+}<|'|'+<|}'|'+<}|'|'<+|}'|'<+}|'|'<}+|'|'<}|+'|'<|+}'|'<|}+'|'}|<+'|'}|+<'|'}+<|'|'}+|<'|'}<|+'|'}<+|'|'|+<}'|'|+}<'|'|}<+'|'|}+<'|'|<+}'|'|<}+';
literal_h: '+<}'|'+}<'|'}+<'|'}<+'|'<}+'|'<+}';
literal_i: '<|'|'|<';
literal_j: '|}<'|'|<}'|'<|}'|'<}|'|'<}|'|'}|<'|'}<|';
literal_k: '+.'|'.+';
literal_l: '+<.'|'+.<'|'<.+'|'<+.'|'.+<'|'.<+';
literal_m: '.+|'|'.|+'|'|+.'|'|.+'|'+|.'|'+.|';
literal_n: '+|.}'|'+|}.'|'+}|.'|'+}.|'|'+.|}'|'+.}|'|'.+|}'|'.+}|'|'.}+|'|'.}|+'|'.|+}'|'.|}+'|'}|.+'|'}|+.'|'}+.|'|'}+|.'|'}.|+'|'}.+|'|'|+.}'|'|+}.'|'|}.+'|'|}+.'|'|.+}'|'|.}+';
literal_o: '+}.'|'+.}'|'}+.'|'}.+'|'.}+'|'.+}';
literal_p: '+<.|'|'+<|.'|'+|<.'|'+|.<'|'+.<|'|'+.|<'|'.+<|'|'.+|<'|'.|+<'|'.|<+'|'.<+|'|'.<|+'|'|<.+'|'|<+.'|'|+.<'|'|+<.'|'|.<+'|'|.+<'|'<+.|'|'<+|.'|'<|.+'|'<|+.'|'<.+|'|'<.|+';
//literal_q:  ;
literal_r: '+<.}'|'+<}.'|'+}<.'|'+}.<'|'+.<}'|'+.}<'|'.+<}'|'.+}<'|'.}+<'|'.}<+'|'.<+}'|'.<}+'|'}<.+'|'}<+.'|'}+.<'|'}+<.'|'}.<+'|'}.+<'|'<+.}'|'<+}.'|'<}.+'|'<}+.'|'<.+}'|'<.}+';
literal_s: '|.<'|'|<.'|'.<|'|'.|<'|'<.|'|'<|.';
//literal_t: ;
literal_u: '+.-'|'+-.'|'.+-'|'.-+'|'-.+'|'-+.';
literal_w: '}<-|'|'}<|-'|'}|<-'|'}|-<'|'}-<|'|'}-|<'|'-}<|'|'-}|<'|'-|}<'|'-|<}'|'-<}|'|'-<|}'|'|<-}'|'|<}-'|'|}-<'|'|}<-'|'|-<}'|'|-}<'|'<}-|'|'<}|-'|'<|-}'|'<|}-'|'<-}|'|'<-|}';
literal_v: '+<.-'|'+<-.'|'+-<.'|'+-.<'|'+.<-'|'+.-<'|'.+<-'|'.+-<'|'.-+<'|'.-<+'|'.<+-'|'.<-+'|'-<.+'|'-<+.'|'-+.<'|'-+<.'|'-.<+'|'-.+<'|'<+.-'|'<+-.'|'<-.+'|'<-+.'|'<.+-'|'<.-+';
literal_x: '+|.-'|'+|-.'|'+-|.'|'+-.|'|'+.|-'|'+.-|'|'.+|-'|'.+-|'|'.-+|'|'.-|+'|'.|+-'|'.|-+'|'-|.+'|'-|+.'|'-+.|'|'-+|.'|'-.|+'|'-.+|'|'|+.-'|'|+-.'|'|-.+'|'|-+.'|'|.+-'|'|.-+';
//literal_y: ;
literal_z: '+}.-'|'+}-.'|'+-}.'|'+-.}'|'+.}-'|'+.-}'|'.+}-'|'.+-}'|'.-+}'|'.-}+'|'.}+-'|'.}-+'|'-}.+'|'-}+.'|'-+.}'|'-+}.'|'-.}+'|'-.+}'|'}+.-'|'}+-.'|'}-.+'|'}-+.'|'}.+-'|'}.-+';

start_statement: '...';

end_statement: '..';

IF: '.-.';

ELSE: '.--.';

ELSEIF: '.---.';

WHILE: '-.-';

FOR: '-..-';

FUNCTION: '-...-';

RETURN: '--.--';

INTEGER_DEC: '.';
FLOAT_DEC: '....';

PRINT: '<<<<<';

// Braille Alphabet controller for numbers
START_NUMBER: '||';
END_NUMBER: '}}';

// Braille Alphabet controller for letters
START_LETTER: '++';
END_LETTER: '<<';



TOKEN_PERIOD: '||||';

TOKEN_SEMICOLON: '++++';

//Binary Operators

TKN_GREAT: '<' ; // >
TKN_GEQ: '<}' ; // >=
TOKEN_LESS: '<-'; // <
TOKEN_NEQ: '<.'; // !=
TKN_EQUAL: '+|'; // ==
TKN_PLUS: '<|}'; // +
TKN_MINUS: '<|-' ; //  -
TKN_TIMES: '<<||'; // *
TKN_MOD: '|<|<'; // %
TOKEN_DIV: '||<<' ;// /
TOKEN_LEQ: '|+'; // <=
TOKEN_ASSIGN: '<-<'; // =

AND: '<<<';
OR: '}}}';
NOT: '<<}}';
TOKEN_OPEN_PAR: '|..'; // (
TOKEN_CLOSE_PAR: '..|'; // )

TOKEN_OPEN_BRA: '}..'; // [
TOKEN_CLOSE_BRA: '..}';// ]


// Logic operators



fragment ESC: '\\"' | '\\\\' | '\\n' |'\\t'|'/"'|'\n';
WS : [ \n\t\r]+ -> skip ;

