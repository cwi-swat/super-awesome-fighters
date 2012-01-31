package jsaf.ast;

public class Ident implements ASTNode {

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
}
