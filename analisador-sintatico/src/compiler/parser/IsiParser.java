package compiler.parser;

import compiler.exceptions.IsiSyntaxException;
import compiler.lexico.IsiScanner;
import compiler.lexico.Token;

public class IsiParser {
    private IsiScanner scanner;
    private Token currToken;

    public IsiParser(IsiScanner scanner){
        this.scanner = scanner;
    }

    public void E(){
        T();
        El();
    }

    public void El(){
        currToken = scanner.nextToken();
        if(currToken != null){
            OP();
            T();
            El();
        }

    }

    public void OP(){
        if (currToken.getType() != Token.TK_OPERATOR){
            throw new IsiSyntaxException(
                    "Expected OPERATOR, found " + Token.TK_TEXT[currToken.getType()] + " (" + currToken.getText() + ") at line " +
                            currToken.getLine() +  " column " + currToken.getColumn()
            );
        }
    }

    public void T(){
        currToken = scanner.nextToken();
        if(currToken.getType() != Token.TK_IDENTIFIER && currToken.getType() != Token.TK_NUMBER){
            throw new IsiSyntaxException(
                    "Expected NUMBER or ID, found " + Token.TK_TEXT[currToken.getType()] +
                    " (" + currToken.getText() + ") at line " +
                            currToken.getLine() +  " column " + currToken.getColumn()
            );
        }
    }
}
