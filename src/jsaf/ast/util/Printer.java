package jsaf.ast.util;

import java.util.List;

import jsaf.ast.ASTNode;
import jsaf.ast.action.Choose;
import jsaf.ast.action.Ident;
import jsaf.ast.action.Simple;
import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Condition;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;

public class Printer implements Visitor {
	
	public static <Node extends ASTNode> String print(Node node) {
		Printer printer = new Printer();
		node.accept(printer);
		return printer.builder.toString();
	}

	private StringBuilder builder;
	
	private Printer() {
		builder = new StringBuilder();
	}

	@Override
	public void visit(Choose choose) {
		builder.append("choose(");
		List<Ident> actions = choose.getActions();
		for (int i = 0; i < actions.size(); i++) {
			actions.get(i).accept(this);
			if (i < actions.size() - 1) {
				builder.append(" ");
			}
		}
		builder.append(")");
	}

	@Override
	public void visit(Simple simple) {
		builder.append(simple.getName());
	}

	@Override
	public void visit(And and) {
		bracket(and.getLhs(), and);
		builder.append(" and ");
		bracket(and.getRhs(), and);
	}
	
	@Override
	public void visit(Or or) {
		bracket(or.getLhs(), or);
		builder.append(" or ");
		bracket(or.getRhs(), or);
	}

	// These two methods: truly unfortunate.
	private void bracket(Condition cond, And parent) {
		if (cond.needBracket(parent)) {
			builder.append("(");
		}
		cond.accept(this);
		if (cond.needBracket(parent)) {
			builder.append(")");
		}
	}
	
	private void bracket(Condition cond, Or parent) {
		if (cond.needBracket(parent)) {
			builder.append("(");
		}
		cond.accept(this);
		if (cond.needBracket(parent)) {
			builder.append(")");
		}
	}

	@Override
	public void visit(Atom atom) {
		builder.append(atom.getName());
	}

	@Override
	public void visit(Behavior behavior) {
		behavior.getGuard().accept(this);
		builder.append(" [");
		behavior.getMove().accept(this);
		builder.append(" ");
		behavior.getFight().accept(this);
		builder.append("]");
	}

	@Override
	public void visit(Strength strength) {
		builder.append(strength.getName());
		builder.append(" = ");
		builder.append(strength.getValue());
	}

	@Override
	public void visit(Fighter fighter) {
		builder.append(fighter.getName());
		builder.append(" {\n");
		for (Strength strength: fighter.getStrengths()) {
			builder.append("\t");
			strength.accept(this);
			builder.append("\n");
		}
		for (Behavior behavior: fighter.getBehaviors()) {
			builder.append("\t");
			behavior.accept(this);
			builder.append("\n");
		}
		builder.append("}");
	}

	@Override
	public void visit(Ident ident) {
		builder.append(ident.getName());
	}

}
