package compiler.main;

import compiler.exceptions.IsiLexicalException;
import compiler.lexico.IsiScanner;
import compiler.lexico.Token;

public class MainClass {
    public static void main(String[] args) {
        try{
            IsiScanner sc = new IsiScanner("input.isi");
            Token token = null;
            do {
                token = sc.nextToken();
                if(token !=null) {
                    System.out.println(token);
                }
            } while (token !=null);
        } catch (IsiLexicalException e){
            System.out.println("Lexical Error " + e.getMessage());
        } catch (Exception e){
            System.out.println("Generic Error " + e.getMessage());
        }

    }
}
