package jsaf.syntax;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import jsaf.ast.ISemantic;
import jsaf.ast.action.Ident;
import jsaf.ast.util.Int;


public class Lexer implements Tokens {
	private static final Map<String, Integer> KEYWORDS = new HashMap<String, Integer>();
	static {
		KEYWORDS.put("choose", CHOOSE);
		KEYWORDS.put("and", AND);
		KEYWORDS.put("or", OR);
	}
	
	private final Reader input;
	private ISemantic yyval;
	private int token;
	private int c = ' ';
	
	public Lexer(Reader input) {
		this.input = input;
	}

	public int nextToken() {
		skipWhitespace();
		return parseToken();
	}
	
	public int getToken() {
		return token;
	}
	
	public ISemantic getSemantic() {
		return yyval;
	}

	private void nextChar() {
		if (c < 0) {
			return;
		}
		try {
			c = input.read();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int parseToken() {
		if (c < 0) {
			return token = ENDINPUT;
		}
		if (isDelimiter(c)) {
			token = c; 
			nextChar(); 
			return token;
		}
		if (Character.isDigit(c)) {
			return parseInteger();
		}
		if (Character.isLetter(c)) {
			return parseIdentOrKeyword();
		}
		return token = error;
	}

	private boolean isDelimiter(int c) {
		return c == '(' || c == ')' || c == '[' || c == ']'
				|| c == '=' || c == '{' || c == '}';
	}

	private void skipWhitespace() {
		while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
			nextChar();
		}
	}


	private int parseIdentOrKeyword() {
		StringBuilder sb = new StringBuilder();
		do {
			sb.append((char)c);
			nextChar();
		}
		while (Character.isLetterOrDigit(c) || c == '_');
		String name = sb.toString();
		if (KEYWORDS.containsKey(name)) {
			return token = KEYWORDS.get(name);
		}
		yyval = new Ident(name);
		return token = IDENT;
	}


	private int parseInteger() {
		int n = 0; 
		do {
			n = 10 * n + (c - '0');
			nextChar(); 
		} while (Character.isDigit(c)); 
		yyval = new Int(n);
		return token = INTEGER;
	}
	
	
}
