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
package net.siliconcode.quamoco.processor.aggregators;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.siliconcode.quamoco.graph.node.Node;
import net.siliconcode.quamoco.processor.Aggregator;

/**
 * NumberMedianAggregator -
 *
 * @author Isaac Griffith
 */
public class NumberMedianAggregator extends Aggregator {

	/**
	 *
	 */
	public NumberMedianAggregator(final Node owner) {
		super(owner);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.siliconcode.quamoco.processor.Aggregator#aggregate()
	 */
	@Override
	protected double aggregate(final List<Double> values) {
		if (values == null || values.isEmpty()) {
			return 0.0;
		}

		final List<Double> temp = Lists.newArrayList();
		temp.addAll(values);
		Collections.sort(temp);
		if (temp.size() % 2 == 0) {
			return (temp.get(temp.size() / 2 - 1) + temp.get(temp.size() / 2)) / 2;
		} else {
			return temp.get(temp.size() / 2);
		}
	}

}