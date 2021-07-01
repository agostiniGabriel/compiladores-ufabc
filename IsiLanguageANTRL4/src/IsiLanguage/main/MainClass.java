package IsiLanguage.main;

import IsiLanguage.parser.IsiLangLexer;
import IsiLanguage.parser.IsiLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MainClass {

    public static void main(String[] args){
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;
            lexer = new IsiLangLexer(CharStreams.fromFileName("IsiLanguageANTRL4/script.isi"));

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            parser = new IsiLangParser(tokenStream);

            parser.prog();

            System.out.println("Compilation Successful");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
