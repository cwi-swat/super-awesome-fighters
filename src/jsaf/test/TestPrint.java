package jsaf.test;

import jsaf.ast.fighter.Fighter;

import org.junit.Test;

import static junit.framework.Assert.*;

public class TestPrint extends Load {

	private void testToString(String name) {
		Fighter f1 = load(name);
		Fighter f2 = loadString(f1.toString());
		assertEquals(f1, f2);
	}

	
	@Test
	public void testAllWrong() {
		testToString("all-wrong.saf");
	}
	
	@Test
	public void testChallengingOutOfBounds() {
		testToString("challenging-outofbounds.saf");
	}
	
	@Test
	public void testChallenging() {
		testToString("challenging.saf");
	}
	
	@Test
	public void testChickenInvalid() {
		testToString("chicken-invalid-cond.saf");
	}
	
	@Test
	public void testChicken() {
		testToString("chicken.saf");
	}
	
	@Test
	public void testChuckInvalid() {
		testToString("chuck-invalid-move.saf");
	}
	
	@Test
	public void testChuck() {
		testToString("chuck.saf");
	}
	@Test
	public void testJackieInvalid() {
		testToString("jackie-invalid-fight.saf");
	}
	
	@Test
	public void testJackie() {
		testToString("jackie.saf");
	}
	
	@Test
	public void testKickingNoAlways() {
		testToString("kicking-no-always.saf");
	}
	
	@Test
	public void testKicking() {
		testToString("kicking.saf");
	}
	
	@Test
	public void testPrecendence() {
		testToString("precedence.saf");
	}
	
	@Test
	public void testUnbeatableWarning() {
		testToString("unbeatable-warning.saf");
	}
	
	@Test
	public void testUnbeatable() {
		testToString("unbeatable.saf");
	}

}
