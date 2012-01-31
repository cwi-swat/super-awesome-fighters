package jsaf.ast.cond;

import jsaf.ast.util.Visitor;


public class And extends Connective {

	public And(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
