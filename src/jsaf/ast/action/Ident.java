package jsaf.ast.action;

import jsaf.ast.ASTNode;
import jsaf.ast.util.Visitor;

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
	
}
