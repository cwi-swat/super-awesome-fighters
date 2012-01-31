package jsaf.ast.fighter;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.ASTNode;
import jsaf.ast.action.Ident;
import jsaf.ast.util.Pair;
import jsaf.ast.util.Visitor;

public class Fighter extends ASTNode  {

	private static final Integer DEFAULT_STRENGTH = 5;

	private final String name;
	private final List<Strength> strengths = new ArrayList<Strength>();
	private final List<Behavior> behaviors = new ArrayList<Behavior>();
	

	public Fighter(Ident name, Pair<Def> defs) {
		this.name = name.getName();
		for (Def d: defs) {
			d.addToFighter(this);
		}
	}
	
	public void addStrength(Strength strength) {
		strengths.add(strength);
	}
	
	public void addBehavior(Behavior behavior) {
		behaviors.add(behavior);
	}
	
	public String getName() {
		return name;
	}
	
	public List<Behavior> getBehaviors() {
		return behaviors;
	}
	
	public List<Strength> getStrengths() {
		return strengths;
	}
	
	public Integer getStrength(String name) {
		for (Strength strength: getStrengths()) {
			if (name.equals(strength.getName())) {
				return strength.getValue();
			}
		}
		return DEFAULT_STRENGTH;
	}
	
	@Override
	public String toString() {
		String s = getName() + " {\n";
		for (Strength strength: getStrengths()) {
			s += "\t" + strength + "\n";
		}
		for (Behavior behavior: getBehaviors()) {
			s += "\t" + behavior + "\n";
		}
		return s + "}";
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}


}
