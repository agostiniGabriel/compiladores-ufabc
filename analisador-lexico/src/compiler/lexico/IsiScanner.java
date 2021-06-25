package compiler.lexico;

import compiler.exceptions.IsiLexicalException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IsiScanner {
    private char[] content;
    private int state;
    private int pos;

    public IsiScanner(String filename){
        try{
            String txtContent;
            txtContent = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
            System.out.println("Debug Start @@ ------");
            System.out.println(txtContent);
            System.out.println("Debug End @@ ------");
            content = txtContent.toCharArray();
            pos = 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Token nextToken(){
        char currentChar;
        String text="";
        Token token;
        if(isEOF()){
            return null;
        }
        state = 0;
        while(true){
            currentChar = nextChar();
            switch(state){
                case 0:
                    if(isChar(currentChar)){
                        text +=currentChar;
                        state = 1;
                    } else if(isDigit(currentChar)){
                        text +=currentChar;
                        state = 3;
                    } else if(isSpace(currentChar)){
                        state = 0;
                    } else if(isOperator(currentChar)){
                        state = 5;
                    } else {
                        throw new IsiLexicalException("Unrecognized Symbol ----- " + currentChar);
                    }
                    break;
                case 1:
                    if(isChar(currentChar) || isDigit(currentChar)){
                        text +=currentChar;
                        state = 1;
                    } else if (isSpace(currentChar) || isOperator(currentChar)){
                        state = 2;
                    } else {
                        throw new IsiLexicalException("Unknow Identifier ----- " + currentChar);
                    }
                    break;
                case 2:
                    back();
                    token = new Token();
                    token.setType(Token.TK_IDENTIFIER);
                    token.setText(text);
                    return token;
                case 3:
                    if(isDigit(currentChar)){
                        text +=currentChar;
                        state = 3;
                    } else if(!isChar(currentChar)){
                        state = 4;
                    } else {
                        throw new IsiLexicalException("Unrecognized Number");
                    }
                    break;
                case 4:
                    token = new Token();
                    token.setType(Token.TK_NUMBER);
                    token.setText(text);
                    back();
                    return token;
                case 5:
                    text += currentChar;
                    token = new Token();
                    token.setType(Token.TK_OPERATOR);
                    token.setText(text);
                    return token;
            }
        }
    }

    private boolean isDigit(char c){
        return c >= '0' &&  c <= '9';
    }

    private boolean isChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isOperator(char c){
        return (c == '>' || c == '<' || c == '=' || c == '!' );
    }

    private boolean isSpace(char c){
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }

    private char nextChar(){
        return content[pos++];
    }

    private boolean isEOF(){
        return pos == content.length;
    }

    private void back(){
        pos--;
    }
}
