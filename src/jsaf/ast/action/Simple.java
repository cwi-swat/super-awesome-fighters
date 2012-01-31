package jsaf.ast.action;

import jsaf.ast.Ident;

public class Simple extends Action {
	
	private final Ident name;

	public Simple(Ident name) {
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
