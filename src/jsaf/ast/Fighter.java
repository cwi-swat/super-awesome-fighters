package jsaf.ast;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.util.Pair;

public class Fighter implements ASTNode {

	private final Ident name;
	private final List<Strength> strengths;
	private final List<Behavior> behaviors;
	

	public Fighter(Ident name, Pair<Def> defs) {
		this.name = name;
		this.strengths = new ArrayList<Strength>();
		this.behaviors = new ArrayList<Behavior>();
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
	
	public Ident getName() {
		return name;
	}
	
	public List<Behavior> getBehaviors() {
		return behaviors;
	}
	
	public List<Strength> getStrengths() {
		return strengths;
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

}
