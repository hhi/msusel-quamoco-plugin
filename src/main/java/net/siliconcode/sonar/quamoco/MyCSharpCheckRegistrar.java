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
package net.siliconcode.sonar.quamoco;

import java.util.Arrays;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.squid.api.CodeVisitor;

/**
 * MyCSharpCheckRegistrar -
 * 
 * @author Isaac Griffith
 */
public class MyCSharpCheckRegistrar implements CheckRegistrar {

    /**
     * Register the classes that will be used to instantiate checks during
     * analysis.
     */
    @Override
    public void register(RegistrarContext registrarContext)
    {
        // Call to registerClassesForRepository to associate the classes with
        // the correct repository key
        // registrarContext.registerClassesForRepository(MyCSharpRulesDefinition.REPOSITORY_KEY,
        // Arrays.asList(checkClasses()));
    }

    /**
     * Lists all the checks provided by the plugin
     */
    public static Class<? extends CodeVisitor>[] checkClasses()
    {
        return new Class[] { AvoidAnnotationCheck.class };
    }

}
