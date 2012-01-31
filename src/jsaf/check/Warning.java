package jsaf.check;

import jsaf.ast.ASTNode;

public class Warning extends Message {
	public Warning(String message, ASTNode node) {
		super(message, node);
	}
	
	@Override
	public String toString() {
		return "WARNING: " + super.toString();
	}
}
