package jsaf.ast;

public class Int extends ASTNode {

	private final Integer value;

	public Int(Integer value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
