package jsaf.ast;

import jsaf.ast.util.Printer;
import jsaf.ast.util.Visitor;

public abstract class ASTNode implements ISemantic {

	public abstract void accept(Visitor visitor);

	@Override
	public String toString() {
		return Printer.print(this);
	}
	
}
