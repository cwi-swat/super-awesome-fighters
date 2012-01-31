package jsaf.ast.util;

import jsaf.ast.ASTNode;

public class Ident extends ASTNode {

	private final String name;
	
	public String getName() {
		return name;
	}

	public Ident(String name) {
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
