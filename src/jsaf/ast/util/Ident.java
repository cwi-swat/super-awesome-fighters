package jsaf.ast.util;

import jsaf.ast.ISemantic;

public class Ident implements ISemantic {

	private final String name;
	
	public String getName() {
		return name;
	}

	public Ident(String name) {
		this.name = name;
	}

}
