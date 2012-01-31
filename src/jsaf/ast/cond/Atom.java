package jsaf.ast.cond;

import jsaf.ast.Ident;

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

}
