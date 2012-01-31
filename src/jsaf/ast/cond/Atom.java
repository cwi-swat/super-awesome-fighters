package jsaf.ast.cond;

import jsaf.ast.util.Ident;
import jsaf.ast.util.Visitor;

public class Atom extends Condition {
	
	private final Ident name;

	public Atom(Ident name) {
		this.name = name;
	}
	
	public Ident getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName().toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
