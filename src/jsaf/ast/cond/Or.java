package jsaf.ast.cond;


public class Or extends Connective {

	public Or(Condition lhs, Condition rhs) {
		super(lhs, rhs);
	}

	@Override
	public String toString() {
		return getLhs() + " or " + getRhs();
	}
}
