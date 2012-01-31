package jsaf.ast.util;

import jsaf.ast.action.Choose;
import jsaf.ast.action.Simple;
import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;

public abstract class NoOpVisitor implements Visitor {

	@Override
	public void visit(Choose choose) {
	}

	@Override
	public void visit(Simple simple) {
	}

	@Override
	public void visit(And and) {
		and.getLhs().accept(this);
		and.getRhs().accept(this);
	}

	@Override
	public void visit(Or or) {
		or.getLhs().accept(this);
		or.getRhs().accept(this);
	}

	@Override
	public void visit(Atom atom) {
	}

	@Override
	public void visit(Behavior behavior) {
	}

	@Override
	public void visit(Strength strength) {
	}

	@Override
	public void visit(Fighter fighter) {
		for (Strength strength: fighter.getStrengths()) {
			strength.accept(this);
		}
		for (Behavior behavior: fighter.getBehaviors()) {
			behavior.accept(this);
		}
	}

	@Override
	public void visit(Ident ident) {
	}

	@Override
	public void visit(Int n) {
	}

}
