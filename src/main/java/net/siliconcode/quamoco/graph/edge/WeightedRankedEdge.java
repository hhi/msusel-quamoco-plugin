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
package net.siliconcode.quamoco.graph.edge;

import net.siliconcode.quamoco.graph.node.Node;
import net.siliconcode.quamoco.processor.LinearDistribution;
import net.siliconcode.quamoco.processor.Normalizer;

/**
 * WeightedRankedEdge -
 *
 * @author Isaac Griffith
 */
public abstract class WeightedRankedEdge extends AbstractEdge implements WeightedEdge, RankedEdge {

	protected double weight;
	protected double lowerBound;
	protected double upperBound;
	protected boolean usesLinearDist;
	protected LinearDistribution dist;
	protected double maxPoints;

	/**
	 * @param name
	 */
	public WeightedRankedEdge(final String name, final Node src, final Node dest) {
		super(name, src, dest);
		weight = 1.0;
		lowerBound = 0;
		upperBound = 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#getLowerBound()
	 */
	@Override
	public double getLowerBound() {
		return lowerBound;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#getUpperBound()
	 */
	@Override
	public double getUpperBound() {
		return upperBound;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#setLowerBound(
	 * double)
	 */
	@Override
	public void setLowerBound(final double lowerBound) {
		if (Double.compare(upperBound, lowerBound) < 0) {
			throw new IllegalArgumentException(
					"Value of upperbound: " + upperBound + " cannot be less than value of lowerbound: " + lowerBound);
		}

		this.lowerBound = lowerBound;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#setUpperBound(
	 * double)
	 */
	@Override
	public void setUpperBound(final double upperBound) {
		if (Double.compare(upperBound, lowerBound) < 0) {
			throw new IllegalArgumentException(
					"Value of upperbound: " + upperBound + " cannot be less than value of lowerbound: " + lowerBound);
		}

		this.upperBound = upperBound;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#setWeight(
	 * double)
	 */
	@Override
	public void setWeight(final double weight) {
		if (Double.compare(weight, 0.0) < 0) {
			throw new IllegalArgumentException("Value of weight cannot be less than 0.0.");
		}
		if (Double.compare(weight, 1.0) > 0) {
			throw new IllegalArgumentException("Value of weight cannot be greater than 1.0.");
		}

		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.RankedEdge#setNormalizer(
	 * net.siliconcode.quamoco.processor.Normalizer)
	 */
	@Override
	public void setNormalizer(final Normalizer normalizer) {
		norm = normalizer;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * net.siliconcode.quamoco.aggregator.graph.edge.WeightedEdge#getWeight()
	 */
	@Override
	public double getWeight() {
		return weight;
	}

	/**
	 * @return the usesLinearDist
	 */
	@Override
	public boolean isUsesLinearDist() {
		return usesLinearDist;
	}

	/**
	 * @param usesLinearDist
	 *            the usesLinearDist to set
	 */
	@Override
	public void setUsesLinearDist(final boolean usesLinearDist) {
		this.usesLinearDist = usesLinearDist;
	}

	/**
	 * @return the dist
	 */
	@Override
	public LinearDistribution getDist() {
		return dist;
	}

	/**
	 * @param dist
	 *            the dist to set
	 */
	@Override
	public void setDist(final LinearDistribution dist) {
		this.dist = dist;
	}

	/**
	 * @return the maxPoints
	 */
	@Override
	public double getMaxPoints() {
		return maxPoints;
	}

	/**
	 * @param maxPoints
	 *            the maxPoints to set
	 */
	@Override
	public void setMaxPoints(final double maxPoints) {
		if (Double.compare(maxPoints, 0) < 0) {
			throw new IllegalArgumentException("Value of maximum points cannot be less than 0");
		}

		this.maxPoints = maxPoints;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.siliconcode.quamoco.graph.edge.RankedEdge#getNormalizer()
	 */
	@Override
	public Normalizer getNormalizer() {
		return norm;
	}
}