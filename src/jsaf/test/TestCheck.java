package jsaf.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import jsaf.ast.action.Choose;
import jsaf.ast.action.Ident;
import jsaf.ast.fighter.Fighter;
import jsaf.check.Check;
import jsaf.check.Message;

import org.junit.Test;


public class TestCheck extends Load {
	
	private static final List<Message> empty = Collections.emptyList();
	
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

	@Test
	public void testInvalidCond() {
		Fighter f = load("chicken-invalid-cond.saf");
		List<Message> errs = Check.check(f);
		assertEquals(1, errs.size());
		Message error = errs.get(0);
		assertTrue(error instanceof jsaf.check.Error);
		assertNotNull(error.getMessage().matches("invalid condition"));
		assertEquals(f.getBehaviors().get(1).getGuard(), error.getNode());
	}
	
	@Test
	public void testInvalidMove() {
		Fighter f = load("chuck-invalid-move.saf");
		List<Message> errs = Check.check(f);
		assertEquals(1, errs.size());
		Message error = errs.get(0);
		assertTrue(error instanceof jsaf.check.Error);
		assertNotNull(error.getMessage().matches("invalid move"));
		assertEquals(f.getBehaviors().get(0).getMove(), error.getNode());
	}

	@Test
	public void testInvalidFight() {
		Fighter f = load("jackie-invalid-fight.saf");
		List<Message> errs = Check.check(f);
		assertEquals(1, errs.size());
		Message error = errs.get(0);
		assertTrue(error instanceof jsaf.check.Error);
		assertNotNull(error.getMessage().matches("invalid fight"));
		Ident a = ((Choose)f.getBehaviors().get(3).getFight()).getActions().get(1);
		assertEquals(a, error.getNode());
	}

	@Test
	public void testDuplicateInChoose() {
		Fighter f = load("unbeatable-warning.saf");
		List<Message> errs = Check.check(f);
		assertEquals(1, errs.size());
		Message error = errs.get(0);
		assertTrue(error instanceof jsaf.check.Warning);
		assertNotNull(error.getMessage().matches("duplicate action"));
		Ident a = ((Choose)f.getBehaviors().get(0).getMove()).getActions().get(1);
		assertEquals(a, error.getNode());
	}
}
