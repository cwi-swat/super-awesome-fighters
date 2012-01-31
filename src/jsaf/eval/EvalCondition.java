package jsaf.eval;

import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Condition;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.util.NoOpVisitor;

public class EvalCondition extends NoOpVisitor {
	private final State state;
	private final Fighter fighter;
	private boolean result = false;
	
	public static boolean eval(Fighter fighter, Condition cond, State state) {
		EvalCondition eval = new EvalCondition(fighter, state);
		cond.accept(eval);
		return eval.result;
	}
	
	private EvalCondition(Fighter fighter, State state) {
		this.fighter = fighter;
		this.state = state;
	}
	
	@Override
	public void visit(And and) {
		and.getLhs().accept(this);
		if (result) {
			and.getRhs().accept(this);
		}
	}
	
	@Override
	public void visit(Or or) {
		or.getLhs().accept(this);
		if (!result) {
			or.getRhs().accept(this);
		}
	}
	
	@Override
	public void visit(Atom atom) {
		result = state.isTheCaseFor(fighter, atom.getName());
	}
	
}
