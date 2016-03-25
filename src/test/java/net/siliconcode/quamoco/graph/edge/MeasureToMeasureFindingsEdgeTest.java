package net.siliconcode.quamoco.graph.edge;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import net.siliconcode.quamoco.codetree.FileNode;
import net.siliconcode.quamoco.graph.node.Finding;
import net.siliconcode.quamoco.graph.node.FindingNode;
import net.siliconcode.quamoco.graph.node.MeasureNode;
import net.siliconcode.quamoco.graph.node.MeasureType;
import net.siliconcode.quamoco.graph.node.Node;
import net.siliconcode.quamoco.processor.aggregators.FindingsUnionAggregator;

/**
 * The class <code>MeasureToMeasureFindingsEdgeTest</code> contains tests for
 * the class <code>{@link MeasureToMeasureFindingsEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class MeasureToMeasureFindingsEdgeTest {

	private MeasureToMeasureFindingsEdge fixture;

	/**
	 * Run the MeasureToMeasureFindingsEdge(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testMeasureToMeasureFindingsEdge_1() throws Exception {
		final String name = "edge";

		final MeasureToMeasureFindingsEdge result = new MeasureToMeasureFindingsEdge(name, null, null);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(0.0, result.getValue(), 1.0);
		Assert.assertEquals("edge", result.getName());
	}

	/**
	 * Run the Set<Finding> getFindings() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testGetFindings_1() throws Exception {
		final Set<Finding> result = fixture.getFindings();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
	}

	/**
	 * Run the double getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testGetValue_1() throws Exception {
		final double result = fixture.getValue();

		// add additional test code here
		Assert.assertEquals(0.0, result, 0.1);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Before
	public void setUp() throws Exception {
		final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
		final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
		dest.setType(MeasureType.FINDINGS);
		final MeasureNode src = new MeasureNode(graph, "src", "owner");
		src.setType(MeasureType.FINDINGS);
		final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
		final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
		fixture = new MeasureToMeasureFindingsEdge("fixture", src, dest);
		src.setProcessor(new FindingsUnionAggregator(src));

		srcsrc.addFinding(new Finding(new FileNode("path0"), "issue", "issue"));
		srcsrc.addFinding(new Finding(new FileNode("path1"), "issue", "issue"));
		srcsrc.addFinding(new Finding(new FileNode("path2"), "issue", "issue"));

		graph.addEdge(fixture, src, dest);
		graph.addEdge(f2m, srcsrc, src);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(MeasureToMeasureFindingsEdgeTest.class);
	}
}