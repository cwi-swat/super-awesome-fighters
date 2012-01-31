package jsaf.ast.cond;

import jsaf.ast.Visitor;


public class And extends Connective {

	public And(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public String toString() {
		return getLhs() + " and " + getRhs();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
