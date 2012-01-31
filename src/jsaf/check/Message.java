package jsaf.check;

import jsaf.ast.ASTNode;

public abstract class Message {
	private final String message;
	private final ASTNode node;

	public Message(String message, ASTNode node) {
		this.message = message;
		this.node = node;
	}

	@Override
	public String toString() {
		return message + " (" + node + ")";
	}
	
}
