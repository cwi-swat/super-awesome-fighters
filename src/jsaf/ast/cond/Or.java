package jsaf.ast.cond;

import jsaf.ast.Visitor;


public class Or extends Connective {

	public Or(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}

	@Override
	public String toString() {
		return getLhs() + " or " + getRhs();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
