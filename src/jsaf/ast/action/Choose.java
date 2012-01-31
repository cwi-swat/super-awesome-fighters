package jsaf.ast.action;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.util.Ident;
import jsaf.ast.util.Pair;
import jsaf.ast.util.Visitor;

public class Choose extends Action {

	private final List<String> actions;

	public Choose(Pair<Ident> actions) {
		this.actions = new ArrayList<String>();
		for (Ident ident: actions) {
			this.actions.add(ident.getName());
		}
	}
	
	public List<String> getActions() {
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
