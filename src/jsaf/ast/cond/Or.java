package jsaf.ast.cond;

import jsaf.ast.util.Visitor;


public class Or extends Connective {

	public Or(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
