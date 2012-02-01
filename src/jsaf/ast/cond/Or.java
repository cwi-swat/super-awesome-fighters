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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Or)) {
			return false;
		}
		return getLhs().equals(((Or)obj).getLhs()) &&
				 getRhs().equals(((Or)obj).getRhs()); 
	}
	
	@Override
	public boolean needBracket(And and) {
		return true;
	}
	
	@Override
	public boolean needBracket(Or or) {
		if (or.getRhs() == this) {
			return true;
		}
		return false;
	}



}
