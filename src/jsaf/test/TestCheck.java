package jsaf.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import jsaf.ast.fighter.Fighter;
import jsaf.check.Check;
import jsaf.check.Message;
import jsaf.syntax.JSAF;

import org.junit.Test;

import static junit.framework.Assert.*;


public class TestCheck {
	
	private static final List<Message> empty = Collections.emptyList();
	
	private Fighter load(String name) {
		InputStream input = getClass().getClassLoader().getResourceAsStream(name);
		return JSAF.parse(new InputStreamReader(input));
	}
	
	@Test
	public void testChicken() {
		assertEquals(empty, Check.check(load("chicken.saf")));
	}

	@Test
	public void testChuck() {
		assertEquals(empty, Check.check(load("chuck.saf")));
	}
	@Test
	public void testChallenging() {
		assertEquals(empty, Check.check(load("challenging.saf")));
	}
	@Test
	public void testJackie() {
		assertEquals(empty, Check.check(load("jackie.saf")));
	}
	
	@Test
	public void testKicking() {
		assertEquals(empty, Check.check(load("kicking.saf")));
	}
	
	@Test
	public void testUnbeatable() {
		assertEquals(empty, Check.check(load("unbeatable.saf")));
	}


	
}
