package jsaf.ast.action;

import jsaf.ast.util.Visitor;

public class Simple extends Action {
	
	private final String name;

	public Simple(Ident name) {
		this.name = name.getName();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Simple)) {
			return false;
		}
		return getName().equals(((Simple)obj).getName());
	}
}
