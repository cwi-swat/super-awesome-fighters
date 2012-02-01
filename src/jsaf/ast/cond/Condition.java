package jsaf.ast.cond;

import jsaf.ast.ASTNode;

public abstract class Condition extends ASTNode {

	public boolean isAlways() {
		return false;
	}
	
	public boolean needBracket(And and) {
		return false;
	}

	public boolean needBracket(Or or) {
		return false;
	}
	
	public boolean needBracket(Atom atom) {
		return false;
	}


}
