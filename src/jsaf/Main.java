package jsaf;

import java.io.InputStreamReader;

import jsaf.ast.Fighter;
import jsaf.syntax.JSAF;

public class Main {
	
	public static void main(String[] args) {
		Fighter pt = JSAF.parse(new InputStreamReader(System.in));
		System.out.println(pt);
	}
	
}
