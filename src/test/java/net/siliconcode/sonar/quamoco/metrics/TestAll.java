package net.siliconcode.sonar.quamoco.metrics;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 5/30/15 3:48 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CSharpMetricsTest.class,
    CSharpSensorTest.class,
    CSharpPrintVisitorTest.class,
    JavaSensorTest.class,
    JavaMetricsTest.class,
    net.siliconcode.sonar.quamoco.metrics.csharp.TestAll.class,
    net.siliconcode.sonar.quamoco.metrics.java.TestAll.class,
})
public class TestAll {

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 5/30/15 3:48 PM
     */
    public static void main(String[] args)
    {
        JUnitCore.runClasses(new Class[] { TestAll.class });
    }
}