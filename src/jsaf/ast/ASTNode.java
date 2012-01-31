package jsaf.ast;

import jsaf.ast.util.Visitor;

public abstract class ASTNode implements ISemantic {

	public abstract void accept(Visitor visitor);

}
