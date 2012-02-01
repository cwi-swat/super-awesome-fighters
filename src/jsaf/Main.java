package jsaf;

import jsaf.ast.fighter.Fighter;
import jsaf.check.Check;
import jsaf.check.Message;
import jsaf.test.Load;

public class Main extends Load {
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {
		Fighter f = load("all-wrong.saf");
		System.out.println(f);
		for (Message m: Check.check(f)) {
			System.out.println(m);
		}
		System.out.println(load("precedence.saf"));
	}
	
}
