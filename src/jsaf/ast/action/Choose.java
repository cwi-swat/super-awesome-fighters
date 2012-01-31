package jsaf.ast.action;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.Ident;
import jsaf.ast.Visitor;
import jsaf.ast.util.Pair;

public class Choose extends Action {

	private final List<Ident> actions;

	public Choose(Pair<Ident> actions) {
		this.actions = new ArrayList<Ident>();
		for (Ident ident: actions) {
			this.actions.add(ident);
		}
	}
	
	public List<Ident> getActions() {
		return actions;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < actions.size(); i++) {
			s += actions.get(i);
			if (i < actions.size() - 1) {
				s += " ";
			}
		}
		return "choose(" + s + ")";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
