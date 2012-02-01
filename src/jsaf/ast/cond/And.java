package jsaf.ast.cond;

import jsaf.ast.action.Choose;
import jsaf.ast.util.Visitor;


public class And extends Connective {

	public And(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof And)) {
			return false;
		}
		return getLhs().equals(((And)obj).getLhs()) &&
				 getRhs().equals(((And)obj).getRhs()); 
	}

	@Override
	public boolean needBracket(And and) {
		if (and.getRhs() == this) {
			return true;
		}
		return false;
	}
}
