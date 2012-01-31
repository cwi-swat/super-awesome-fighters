package jsaf.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jsaf.ast.action.Choose;
import jsaf.ast.action.Simple;
import jsaf.ast.cond.Atom;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;
import jsaf.ast.util.NoOpVisitor;

public class Check extends NoOpVisitor {
	private static final List<String> ATOMS =
		Arrays.asList("near", "even", "far", "always", "stronger", "weaker", "much_stronger", "much_weaker");
	
	private static final List<String> MOVES =
			Arrays.asList("jump", "crouch", "stand", "run_towards", "run_away", "walk_towards", "walk_away");

	private static final List<String> FIGHTS =
			Arrays.asList("punch_low", "punch_high", "kick_low", "kick_high", "block_low", "block_high");
	
	private static final List<String> STRENGTHS =
			Arrays.asList("punchReach", "kickReach", "kickPower", "punchPower");

	private static final Integer MIN_STRENGTH = 1;
	private static final Integer MAX_STRENGTH = 10;
	
	
	private final List<Message> messages;

	public static List<Message> check(Fighter fighter) {
		Check check = new Check();
		fighter.accept(check);
		return check.messages;
	}
	
	private Check() {
		this.messages = new ArrayList<Message>();
	}
	
	@Override
	public void visit(Choose choose) {
		Set<String> actions = new HashSet<String>();
		for (String action: choose.getActions()) {
			if (actions.contains(action)) {
				messages.add(new Warning("Duplicate action in choose", choose));
			}
			actions.add(action);
		}
	}

	@Override
	public void visit(Atom atom) {
		if (!ATOMS.contains(atom.getName())) {
			addMessage(new Error("invalid condition atom", atom));
		}
		
	}
	
	private class FightChecker extends NoOpVisitor {
		@Override
		public void visit(Simple simple) {
			if (!FIGHTS.contains(simple.getName())) {
				addMessage(new Error("invalid fight", simple));
			}
		}
	}
	
	private class MoveChecker extends NoOpVisitor {
		@Override
		public void visit(Simple simple) {
			if (!MOVES.contains(simple.getName())) {
				addMessage(new Error("invalid move", simple));
			}
		}
	}

	@Override
	public void visit(Behavior behavior) {
		behavior.getGuard().accept(this);
		behavior.getFight().accept(new FightChecker());
		behavior.getMove().accept(new MoveChecker());
	}

	@Override
	public void visit(Strength strength) {
		if (!STRENGTHS.contains(strength.getName())) {
			addMessage(new Error("invalid strength", strength));
		}
		if (!isInBounds(strength)) {
			addMessage(new Error("strength out of bounds", strength));
		}
	}

	private boolean isInBounds(Strength strength){
		return MIN_STRENGTH <= strength.getValue()  && strength.getValue() <= MAX_STRENGTH;
	}


	private void addMessage(Message message) {
		messages.add(message);
	}

}
