package net.siliconcode.quamoco.aggregator.strategy;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>NumberMinAggregationStrategyTest</code> contains tests for the class <code>{@link NumberMinAggregationStrategy}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:43 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class NumberMinAggregationStrategyTest {
    /**
     * Run the NumberMinAggregationStrategy(NormalizationStrategy) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 5/30/15 3:43 PM
     */
    @Test
    public void testNumberMinAggregationStrategy_1()
        throws Exception
    {
        NormalizationStrategy ns = EasyMock.createMock(NormalizationStrategy.class);
        // TODO: add mock object expectations here

        EasyMock.replay(ns);

        NumberMinAggregationStrategy result = new NumberMinAggregationStrategy(ns);

        // TODO: add additional test code here
        EasyMock.verify(ns);
        assertNotNull(result);
        fail("unverified");
    }

    /**
     * Run the double evaluate(Double[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 5/30/15 3:43 PM
     */
    @Test
    public void testEvaluate_1()
        throws Exception
    {
        NumberMinAggregationStrategy fixture = new NumberMinAggregationStrategy(EasyMock.createNiceMock(NormalizationStrategy.class));
        fixture.normstrategy = EasyMock.createNiceMock(NormalizationStrategy.class);

        double result = fixture.evaluate();

        // TODO: add additional test code here
        // An unexpected exception was thrown in user code while executing this test:
        //    java.lang.ArrayIndexOutOfBoundsException: 0
        //       at net.siliconcode.quamoco.aggregator.strategy.NumberMinAggregationStrategy.evaluate(NumberMinAggregationStrategy.java:53)
        assertEquals(0.0, result, 0.1);
        fail("unverified");
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @generatedBy CodePro at 5/30/15 3:43 PM
     */
    @Before
    public void setUp()
        throws Exception
    {
        // TODO: add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     * @generatedBy CodePro at 5/30/15 3:43 PM
     */
    @After
    public void tearDown()
        throws Exception
    {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 5/30/15 3:43 PM
     */
    public static void main(String[] args)
    {
        new org.junit.runner.JUnitCore().run(NumberMinAggregationStrategyTest.class);
    }
}