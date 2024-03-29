package jsaf.check;

import jsaf.ast.ASTNode;

public class Error extends Message {

	public Error(String message, ASTNode node) {
		super(message, node);
	}
	
	@Override
	public String toString() {
		return "ERROR: " + super.toString();
	}

}
