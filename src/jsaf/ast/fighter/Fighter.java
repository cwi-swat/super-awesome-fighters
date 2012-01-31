package jsaf.ast.fighter;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.ASTNode;
import jsaf.ast.util.Ident;
import jsaf.ast.util.Pair;
import jsaf.ast.util.Visitor;

public class Fighter extends ASTNode {

	private final String name;
	private final List<Strength> strengths;
	private final List<Behavior> behaviors;
	

	public Fighter(Ident name, Pair<Def> defs) {
		this.name = name.getName();
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
	
	public String getName() {
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
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}


}
