// Generated from C:/Users/Gabriel Agostini/IdeaProjects/compiladores-ufabc/IsiLanguageANTRL4\IsiLang.g4 by ANTLR 4.9.1
package IsiLanguage.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IsiLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IsiLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(IsiLangParser.TermoContext ctx);
}