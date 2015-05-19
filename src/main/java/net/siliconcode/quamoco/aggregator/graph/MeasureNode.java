/**
 * The MIT License (MIT)
 * 
 * Sonar Quamoco Plugin
 * Copyright (c) 2015 Isaac Griffith, SiliconCode, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.siliconcode.quamoco.aggregator.graph;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;

import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * MeasureNode -
 *
 * @author Isaac Griffith
 */
public class MeasureNode extends Node {

    private String             description;
    private boolean            normalized;
    private Set<String>        evaluatedBy;
    public static final String NUMBER   = "Number";
    public static final String FINDINGS = "Findings";
    private String             type;

    /**
     * @param graph
     * @param name
     * @param owner
     */
    public MeasureNode(DirectedSparseGraph<Node, Edge> graph, String name, String owner)
    {
        super(graph, name, owner);
        evaluatedBy = new HashSet<>();
    }

    public MeasureNode(DirectedSparseGraph<Node, Edge> graph, String name, String owner, long id)
    {
        super(graph, name, owner, id);
        evaluatedBy = new HashSet<>();
    }

    /**
     * @return the normalized
     */
    public boolean isNormalized()
    {
        return normalized;
    }

    /**
     * @param normalized
     *            the normalized to set
     */
    public void setNormalized(boolean normalized)
    {
        this.normalized = normalized;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        if (description == null)
            this.description = "";
        else
            this.description = description;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.quamoco.swing.distiller.Node#getValue()
     */
    @Override
    public double getValue()
    {
        double norm = 1;
        for (Edge e : graph.getInEdges(this))
        {
            if (e instanceof NormalizationEdge)
            {
                Node n = graph.getOpposite(this, e);
                norm = n.getValue();
            }
            else
            {
                Node n = graph.getOpposite(this, e);
                if (n instanceof ValueNode)
                    value = n.getValue();
            }
        }
        return (value / norm);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.quamoco.swing.distiller.Node#getXMLTag()
     */
    @Override
    public String getXMLTag()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "<nodes name=\"%s\" description=\"%s\" id=\"%d\" owner=\"%s\" type=\"MEASURE\">\n",
                StringEscapeUtils.escapeXml10(this.name), StringEscapeUtils.escapeXml10(this.description), this.id,
                this.ownedBy));
        builder.append("\t</nodes>");
        return builder.toString();
    }

    /**
     * @param id
     */
    public void addEvaluatedBy(String id)
    {
        if (id == null)
            return;

        evaluatedBy.add(id);
    }

    public void removeEvaluatedBy(String id)
    {
        if (id == null)
            return;

        evaluatedBy.remove(id);
    }

}