package jsaf.ast.fighter;

import jsaf.ast.util.Ident;
import jsaf.ast.util.Int;
import jsaf.ast.util.Visitor;

public class Strength extends Def {

	private final Ident name;
	private final Int value;

	public Strength(Ident name, Int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public void addToFighter(Fighter fighter) {
		fighter.addStrength(this);
	}

	public Ident getName() {
		return name;
	}
	
	public Int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return getName() + " = " + getValue();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
