package jsaf.ast.action;

import java.util.ArrayList;
import java.util.List;

import jsaf.ast.util.Pair;
import jsaf.ast.util.Visitor;

public class Choose extends Action {

	private final List<Ident> actions = new ArrayList<Ident>();

	public Choose(Pair<Ident> actions) {
		for (Ident ident: actions) {
			this.actions.add(ident);
		}
	}
	
	public List<Ident> getActions() {
		return actions;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Choose)) {
			return false;
		}
		return getActions().equals(((Choose)obj).getActions());
	}
	
}
