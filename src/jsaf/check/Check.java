package jsaf.check;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jsaf.Config;
import jsaf.ast.ASTNode;
import jsaf.ast.action.Choose;
import jsaf.ast.action.Ident;
import jsaf.ast.action.Simple;
import jsaf.ast.cond.Atom;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;
import jsaf.ast.util.NoOpVisitor;

public class Check extends NoOpVisitor implements Config {
	public static List<Message> check(Fighter fighter) {
		Check check = new Check();
		fighter.accept(check);
		return check.messages;
	}

	private final List<Message> messages;

	private class ActionChecker extends NoOpVisitor {
		private final List<String> validActions;
		private final String kind;

		public ActionChecker(List<String> validActions, String kind) {
			this.validActions = validActions;
			this.kind = kind;
		}
		
		@Override
		public void visit(Choose choose) {
			Set<String> seen = new HashSet<String>();
			for (Ident action: choose.getActions()) {
				if (seen.contains(action.getName())) {
					addMessage(new Warning("duplicate action", action));
				}
				seen.add(action.getName());
				action.accept(this);
			}
		}
		
		@Override
		public void visit(Simple simple) {
			checkFight(simple.getName(), simple);
		}

		@Override
		public void visit(Ident ident) {
			checkFight(ident.getName(), ident);
		}

		private void checkFight(String name, ASTNode node) {
			if (!validActions.contains(name)) {
				addMessage(new Error("invalid " + kind, node));
			}
		}
	}

	private Check() {
		this.messages = new ArrayList<Message>();
	}

	@Override
	public void visit(Atom atom) {
		if (!ATOMS.contains(atom.getName())) {
			addMessage(new Error("invalid condition atom", atom));
		}
	}

	@Override
	public void visit(Behavior behavior) {
		behavior.getGuard().accept(this);
		behavior.getMove().accept(new ActionChecker(MOVES, "move"));
		behavior.getFight().accept(new ActionChecker(FIGHTS, "fight"));
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
		return MIN_STRENGTH <= strength.getValue()  
				&& strength.getValue() <= MAX_STRENGTH;
	}


	private void addMessage(Message message) {
		messages.add(message);
	}

}
