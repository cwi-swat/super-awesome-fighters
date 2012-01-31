package jsaf.ast.cond;


public class And extends Connective {

	public And(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public String toString() {
		return getLhs() + " and " + getRhs();
	}

}
