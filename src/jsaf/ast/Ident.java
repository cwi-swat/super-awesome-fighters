package jsaf.ast;

public class Ident extends ASTNode {

	private final String name;
	
	public String getName() {
		return name;
	}

	public Ident(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
