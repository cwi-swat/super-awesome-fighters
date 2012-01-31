package jsaf.ast.util;

import java.util.Iterator;

import jsaf.ast.ASTNode;

public class Cons<X extends ASTNode> extends Pair<X> {
	private final X head;
	private final Pair<X> tail;

	public Cons(X head, Pair<X> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public Cons(X head) {
		this(head, new Nil<X>());
	}

	@Override
	public Iterator<X> iterator() {
		return new Iterator<X>() {
			private boolean start = true;
			private Iterator<X> tailIter = tail.iterator();

			@Override
			public boolean hasNext() {
				if (start) {
					return true;
				}
				return tailIter.hasNext();
			}

			@Override
			public X next() {
				if (start) {
					start = false;
					return head;
				}
				return tailIter.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("no remove in pairs");
			}
			
		};
	}

}
