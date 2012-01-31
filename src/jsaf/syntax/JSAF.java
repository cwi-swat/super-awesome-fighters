package jsaf.syntax;

import java.io.Reader;

import jsaf.ast.Fighter;

public class JSAF {
	public static Fighter parse(Reader input) {
		Lexer lexer = new Lexer(input);
		Parser parser = new Parser(lexer);
		lexer.nextToken();
		boolean success = parser.parse();
		if (success) {
			return parser.getResult();
		}
		return null;
	}

}
