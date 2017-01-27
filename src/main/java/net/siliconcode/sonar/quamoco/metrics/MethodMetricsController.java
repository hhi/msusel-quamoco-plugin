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
package net.siliconcode.sonar.quamoco.metrics;

import java.util.Set;

import org.sonar.api.internal.google.common.collect.Sets;

import com.sparqline.metrics.Metric;
import com.sparqline.metrics.method.NOS;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

import net.siliconcode.sonar.quamoco.QuamocoMetricsController;

/**
 * MethodMetricsController - 
 * 
 * @author Isaac Griffith
 *
 */
public class MethodMetricsController extends QuamocoMetricsController {

    /**
     * {@inheritDoc}
     */
    @Override
    public void measure(CodeNode node, CodeTree tree)
    {
        if (!(node instanceof TypeNode))
        {
            return;
        }

        Set<Metric> metrics = Sets.newHashSet();
        metrics.add(NOS.getInstance(node, tree));
        
        metrics.parallelStream().forEach((metric) -> {
            node.addMetric(metric.getAcronym(), metric.measure());
        });
    }

}
