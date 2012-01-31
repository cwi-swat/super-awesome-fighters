package jsaf.test;

import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Condition;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Fighter;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

public class TestParse extends Load {

	private Fighter fighter;

	@Before
	public void setup() {
		this.fighter = load("precedence.saf");
	}
	
	@Test
	public void testAndLeftAssoc() {
		assertNotNull(fighter);
		Condition c = fighter.getBehaviors().get(0).getGuard();
		assertEquals(And.class, c.getClass());
		assertEquals(And.class, ((And)c).getLhs().getClass());
		assertEquals(Atom.class, ((And)c).getRhs().getClass());
	}


	@Test
	public void testOrLeftAssoc() {
		Condition c = fighter.getBehaviors().get(1).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Or.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}

	
	@Test
	public void testAndStrongerThanOrLeft() {
		Condition c = fighter.getBehaviors().get(2).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testAndStrongerThanOrRight() {
		Condition c = fighter.getBehaviors().get(3).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Atom.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testBracketAnds() {
		Condition c = fighter.getBehaviors().get(4).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testNoBracketAnds() {
		Condition c = fighter.getBehaviors().get(5).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testAndStrongerLeftRight() {
		Condition c = fighter.getBehaviors().get(6).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Or.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)((Or)c).getLhs()).getLhs().getClass());
		assertEquals(And.class, ((Or)((Or)c).getLhs()).getRhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testBracketOrs() {
		Condition c = fighter.getBehaviors().get(7).getGuard();
		assertEquals(And.class, c.getClass());
		assertEquals(Or.class, ((And)c).getLhs().getClass());
		assertEquals(Or.class, ((And)c).getRhs().getClass());
	}
	
}