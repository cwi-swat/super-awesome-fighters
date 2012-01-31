package jsaf.test;

import jsaf.ast.cond.And;
import jsaf.ast.cond.Atom;
import jsaf.ast.cond.Condition;
import jsaf.ast.cond.Or;
import jsaf.ast.fighter.Fighter;

import org.junit.Test;
import static junit.framework.Assert.*;

public class TestParse extends Load {

	
	@Test
	public void testAndLeftAssoc() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(0).getGuard();
		assertEquals(And.class, c.getClass());
		assertEquals(And.class, ((And)c).getLhs().getClass());
		assertEquals(Atom.class, ((And)c).getRhs().getClass());
	}


	@Test
	public void testOrLeftAssoc() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(1).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Or.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}

	
	@Test
	public void testAndStrongerThanOrLeft() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(2).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testAndStrongerThanOrRight() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(3).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Atom.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testBracketAnds() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(4).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testNoBracketAnds() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(5).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(And.class, ((Or)c).getLhs().getClass());
		assertEquals(And.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testAndStrongerLeftRight() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(6).getGuard();
		assertEquals(Or.class, c.getClass());
		assertEquals(Or.class, ((Or)c).getLhs().getClass());
		assertEquals(Atom.class, ((Or)((Or)c).getLhs()).getLhs().getClass());
		assertEquals(And.class, ((Or)((Or)c).getLhs()).getRhs().getClass());
		assertEquals(Atom.class, ((Or)c).getRhs().getClass());
	}
	
	@Test
	public void testBracketOrs() {
		Fighter f = load("precedence.saf");
		assertNotNull(f);
		Condition c = f.getBehaviors().get(7).getGuard();
		assertEquals(And.class, c.getClass());
		assertEquals(Or.class, ((And)c).getLhs().getClass());
		assertEquals(Or.class, ((And)c).getRhs().getClass());
	}
	
}
