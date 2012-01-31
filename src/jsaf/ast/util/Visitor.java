package jsaf.ast.util;

import jsaf.ast.action.Choose;
import jsaf.ast.action.Simple;
import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;

public interface Visitor {
	public void visit(Choose choose);
	public void visit(Simple simple);
	public void visit(And and);
	public void visit(Or or);
	public void visit(Atom atom);
	public void visit(Behavior behavior);
	public void visit(Strength strength);
	public void visit(Fighter fighter);
	public void visit(Ident ident);
	public void visit(Int n);
}
