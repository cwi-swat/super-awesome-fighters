package jsaf.ast.util;

import java.util.Collections;
import java.util.Iterator;

import jsaf.ast.ASTNode;

public class Nil<X extends ASTNode> extends Pair<X> {

	@Override
	public Iterator<X> iterator() {
		return Collections.<X>emptyList().iterator();
	}

}
