package jsaf.eval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jsaf.ast.action.Ident;
import jsaf.ast.action.Simple;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.util.NoOpVisitor;

public class PickBehavior extends NoOpVisitor {

	private static final Random RANDOM = new Random();
	
	public static ActionPair pickBehavior(Fighter fighter, State state) {
		PickBehavior pick = new PickBehavior(fighter, state);
		fighter.accept(pick);
		return new ActionPair(pick.pickMove(), pick.pickFight());
	}
	
	private final Fighter fighter;
	private final State state;
	private final List<String> possibleMoves, possibleFights;

	private PickBehavior(Fighter fighter, State state) {
		this.fighter = fighter;
		this.state = state;
		this.possibleMoves = new ArrayList<String>();
		this.possibleFights = new ArrayList<String>();
	}

	private String pickMove() {
		return pickRandomly(possibleMoves);
	}
	
	private String pickFight() {
		return pickRandomly(possibleFights);
	}
	
	private String pickRandomly(List<String> actions) {
		return actions.get(RANDOM.nextInt(actions.size()));
	}

	private static class Collect extends NoOpVisitor {
		private final List<String> coll;

		public Collect(List<String> coll) {
			this.coll = coll;
		}
		
		@Override
		public void visit(Simple simple) {
			coll.add(simple.getName());
		}
		
		@Override
		public void visit(Ident ident) {
			coll.add(ident.getName());
		}
	}
	
	
	@Override
	public void visit(Behavior behavior) {
		if (EvalCondition.eval(fighter, behavior.getGuard(), state)) {
			behavior.getMove().accept(new Collect(possibleMoves));
			behavior.getFight().accept(new Collect(possibleFights));
		}
	}

}
