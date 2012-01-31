package jsaf.ast.cond;

public abstract class Connective extends Condition {
	private final Condition lhs;
	private final Condition rhs;

	public Connective(Condition lhs, Condition rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Condition getLhs() {
		return lhs;
	}
	
	public Condition getRhs() {
		return rhs;
	}

}
