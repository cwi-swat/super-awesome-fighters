package jsaf.ast.cond;

import jsaf.ast.action.Ident;
import jsaf.ast.util.Visitor;

public class Atom extends Condition {
	private static final String ALWAYS = "always";
	
	private final String name;

	public Atom(Ident name) {
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
	public boolean isAlways() {
		return name.equals(ALWAYS);
	}

}
