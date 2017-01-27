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
package net.siliconcode.sonar.quamoco.rules;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

import net.siliconcode.sonar.quamoco.rules.xml.CustomizedDomDriver;
import net.siliconcode.sonar.quamoco.rules.xml.Parameter;
import net.siliconcode.sonar.quamoco.rules.xml.Rule;

/**
 * RuleSet -
 *
 * @author Isaac Griffith
 *
 */
@XStreamAlias("rules")
public class RuleSet {

	@XStreamImplicit
	private final List<Rule> rules;

	@XStreamOmitField
	private Map<String, Rule> ruleMap;

	public RuleSet() {
		rules = Lists.newArrayList();
	}

	public void addRule(final Rule r) {
		rules.add(r);
	}

	public List<Rule> getRules() {
		return rules;
	}

	public Rule getRule(final String key) {
		if (ruleMap.isEmpty() && !rules.isEmpty()) {
			initRuleMap();
		}

		if (ruleMap.containsKey(key)) {
			return ruleMap.get(key);
		}

		return null;
	}

	private void initRuleMap() {
		for (final Rule rule : rules) {
			ruleMap.put(rule.key(), rule);
		}
	}

	/**
	 * @param location
	 */
	public void writeXML(final String location) {
		try {
			final FileOutputStream out = new FileOutputStream(location);
			final PrintWriter pw = new PrintWriter(out);
			pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			pw.print(RuleSet.createXStream().toXML(this));
			pw.close();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static RuleSet readXML(final InputStream location) {
		final CustomizedDomDriver custom = new CustomizedDomDriver();
		final XStream xstream = new XStream(custom);
		xstream.setClassLoader(RuleSet.class.getClassLoader());
		xstream.processAnnotations(RuleSet.class);
		xstream.processAnnotations(Rule.class);
		xstream.registerConverter(new EnumToStringConverter<>(Rule.Priority.class, Rule.Priority.map));
		xstream.registerConverter(new EnumToStringConverter<>(Rule.Cardinality.class, Rule.Cardinality.map));
		xstream.registerConverter(new EnumToStringConverter<>(Parameter.Type.class, Parameter.Type.map));

		final RuleSet set = (RuleSet) xstream.fromXML(location);
		return set;
	}

	public static XStream createXStream() {
		final CustomizedDomDriver custom = new CustomizedDomDriver();
		final XStream xstream = new XStream(custom);
		xstream.setClassLoader(RuleSet.class.getClassLoader());
		xstream.processAnnotations(RuleSet.class);
		xstream.processAnnotations(Rule.class);
		return xstream;
	}
}
