package net.siliconcode.quamoco.graph.edge;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>AbstractEdgeTest</code> contains tests for the class
 * <code>{@link AbstractEdge}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:38 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AbstractEdgeTest {

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge();
		final Object obj = AbstractEdgeFactory.createAbstractEdge2();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testEquals_2() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge3();
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testEquals_3() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge4();
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge5();
		final Object obj = AbstractEdgeFactory.createAbstractEdge6();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testEquals_5() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge7();
		final Object obj = AbstractEdgeFactory.createAbstractEdge8();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the long getId() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge();
		final long id = 1;
		fixture.setId(id);
		final long result = fixture.getId();

		// TODO: add additional test code here
		Assert.assertEquals(id, result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testGetName_1() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge2();

		final String result = fixture.getName();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Test
	public void testToString_1() throws Exception {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge5();

		final String result = fixture.toString();

		// TODO: add additional test code here
		Assert.assertEquals("Edge: " + fixture.getId(), result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@Before
	public void setUp() throws Exception {
		// TODO: add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	@After
	public void tearDown() throws Exception {
		// TODO: add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 * @generatedBy CodePro at 5/30/15 3:38 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(AbstractEdgeTest.class);
	}
}