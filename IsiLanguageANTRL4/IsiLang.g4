grammar IsiLang;

prog    : 'programa'  bloco  'fimprog;'
        ;

bloco   : (cmd)+
        ;

cmd     : cmdleitura {System.out.println("Identificado o comando de leitura");}
        | cmdescrita
        | cmdattrib
        ;

cmdleitura  : 'leia' AP
                     ID { System.out.println("ID = "+ _input.LT(-1).getText());}
                     FP
                     SC
            ;

cmdescrita  : 'escreva' AP ID FP SC
            ;

cmdattrib   :   ID  ATTR    expr    SC
            ;

expr        :   termo   ( OP    termo )*
            ;

termo       : ID | NUMBER
            ;

AP  :   '('
    ;

FP  :   ')'
    ;

SC  :   ';'
    ;

OP  :   '+' | '-' | '*' | '/'
    ;

ATTR    : '='
        ;

ID  : [a-z] ([a-z] | [A-Z] | [0-9])*
    ;

NUMBER : [0-9]+ ('.'[0-9])?
       ;

WS : (' ' | '\t' | '\n' | '\r') -> skip;

