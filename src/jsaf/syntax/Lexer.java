package jsaf.syntax;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import jsaf.ast.ASTNode;
import jsaf.ast.Ident;
import jsaf.ast.Int;


public class Lexer implements Tokens {
	private static final Map<String, Integer> KEYWORDS = new HashMap<String, Integer>();
	static {
		KEYWORDS.put("choose", CHOOSE);
		KEYWORDS.put("and", AND);
		KEYWORDS.put("or", OR);
	}
	
	private ASTNode yyval;
	private int token;
	private final Reader input;
	private int c = ' ';
	
	public Lexer(Reader input) {
		this.input = input;
	}
	
	
	private void nextChar() {
		if (c < 0) {
			return;
		}
		try {
			c = input.read();
		}
		catch (IOException e) {
			c = -1;
		}
	}
	
	public int nextToken() {
		for (;;) {
			while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
				nextChar();
			}
			
			if (c < 0) {
				return token = ENDINPUT;
			}
			
			switch (c) {
			    case '(':
			    case ')': 
			    case '[':
			    case ']':
			    case '=': 
			    case '{':
			    case '}': token = c; nextChar(); return token;
			    default: {
			    	if (Character.isDigit(c)) {
			    		return parseInteger();
			    	}
			    	if (Character.isLetter(c)) {
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
			    	return token = error;
			    }
			}
		}
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
	
	public int getToken() {
		return token;
	}

	public ASTNode getSemantic() {
		return yyval;
	}

	
}
