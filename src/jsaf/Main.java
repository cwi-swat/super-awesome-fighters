package jsaf;

import jsaf.test.Load;

public class Main extends Load {
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {
		System.out.println(load("challenging.saf"));
	}
	
}
