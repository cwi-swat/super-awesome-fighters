package jsaf.ast.util;

import jsaf.ast.ISemantic;

public class Int implements ISemantic {

	private final Integer value;

	public Int(Integer value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
