package jsaf.ast;

import jsaf.ast.action.Action;
import jsaf.ast.cond.Condition;

public class Behavior extends Def {
	
	private final Condition guard;
	private final Action move;
	private final Action fight;

	public Behavior(Condition guard, Action move, Action fight) {
		this.guard = guard;
		this.move = move;
		this.fight = fight;
	}

	@Override
	public void addToFighter(Fighter fighter) {
		fighter.addBehavior(this);
	}
	
	public Action getFight() {
		return fight;
	}
	
	public Condition getGuard() {
		return guard;
	}
	
	public Action getMove() {
		return move;
	}
	
	@Override
	public String toString() {
		return getGuard() + " [" + getMove() + " " + getFight() + "]";
	}

}
