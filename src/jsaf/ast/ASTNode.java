package jsaf.ast;

public abstract class ASTNode implements ISemantic {

	public abstract void accept(Visitor visitor);

}
