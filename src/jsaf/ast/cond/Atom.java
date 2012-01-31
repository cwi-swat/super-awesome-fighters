package jsaf.ast.cond;

import jsaf.ast.util.Ident;
import jsaf.ast.util.Visitor;

public class Atom extends Condition {
	
	private final String name;

	public Atom(Ident name) {
		this.name = name.getName();
	}
	
	public String getName() {
		return name;
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
