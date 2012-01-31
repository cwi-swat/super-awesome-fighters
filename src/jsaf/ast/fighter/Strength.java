package jsaf.ast.fighter;

import jsaf.ast.action.Ident;
import jsaf.ast.util.Int;
import jsaf.ast.util.Visitor;

public class Strength extends Def {

	private final String name;
	private final Integer value;

	public Strength(Ident name, Int value) {
		this.name = name.getName();
		this.value = value.getValue();
	}
	
	@Override
	public void addToFighter(Fighter fighter) {
		fighter.addStrength(this);
	}

	public String getName() {
		return name;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strength)) {
			return false;
		}
		Strength s = (Strength)obj;
		return getName().equals(s.getName()) &&
				getValue().equals(s.getValue());
	}
}
