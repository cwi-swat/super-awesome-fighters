package jsaf.test;

import java.io.File;
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
		String subPath = "jsaf" + File.separator + "test" + File.separator +  name;
		InputStream input = getClass().getClassLoader().getResourceAsStream(subPath);
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


	@Test
	public void testOutOfBounds() {
		Fighter f = load("challenging-outofbounds.saf");
		List<Message> errs = Check.check(f);
		assertEquals(1, errs.size());
		Message error = errs.get(0);
		assertTrue(error instanceof jsaf.check.Error);
		assertNotNull(error.getMessage().matches("out of bounds"));
		assertEquals(f.getStrengths().get(0), error.getNode());
	}
}
