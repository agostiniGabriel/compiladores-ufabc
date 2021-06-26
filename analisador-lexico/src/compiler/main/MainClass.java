package compiler.main;

import compiler.exceptions.IsiLexicalException;
import compiler.exceptions.IsiSyntaxException;
import compiler.lexico.IsiScanner;
import compiler.parser.IsiParser;

public class MainClass {
    public static void main(String[] args) {
        try {
            IsiScanner sc = new IsiScanner("./analisador-lexico/input.isi");
            IsiParser pa = new IsiParser(sc);
            pa.E();
            System.out.println("Compilation Successful!");
        } catch (IsiLexicalException e) {
            System.out.println("Lexical Error: " + e.getMessage());
        } catch (IsiSyntaxException e) {
            System.out.println("Syntax Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic Error: " + e.getMessage());
        }

    }
}
