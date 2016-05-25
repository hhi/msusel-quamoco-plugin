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
package net.siliconcode.sonar.quamoco.sensor;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.sonar.api.batch.fs.FilePredicates;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.resources.Project;

import com.sparqline.parsers.QuamocoCSharpListener;
import com.sparqline.parsers.csharp.CSharp6Lexer;
import com.sparqline.parsers.csharp.CSharp6Parser;
import com.sparqline.parsers.csharp.CSharp6Parser.Compilation_unitContext;
import com.sparqline.parsers.csharp.CSharp6PreProcessor;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.FileNode;

import net.siliconcode.sonar.quamoco.QuamocoMetrics;
import net.siliconcode.sonar.quamoco.QuamocoSensor;

/**
 * QuamocoCSharpSensor -
 *
 * @author Isaac Griffith
 *
 */
public class QuamocoCSharpSensor extends QuamocoSensor {

    /**
     * @param fs
     * @param metrics
     */
    public QuamocoCSharpSensor(final FileSystem fs, final QuamocoMetrics metrics) {
        super(fs, metrics);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.siliconcode.sonar.quamoco.QuamocoSensor#utilizeParser(java.lang.
     * String, net.siliconcode.quamoco.codetree.CodeTree)
     */
    @Override
    public void utilizeParser(String key, final String file, final CodeTree tree) {
        try {
            // TODO Make this code specific to subclasses
            final FileNode node = new FileNode(key);
            tree.addFile(node);

            final CSharpParserConstructor pt = new CSharpParserConstructor();
            final CSharp6Parser parser = pt.loadFile(file);
            final Compilation_unitContext cuContext = parser.compilation_unit();
            final ParseTreeWalker walker = new ParseTreeWalker();
            final QuamocoCSharpListener listener = new QuamocoCSharpListener(node);
            walker.walk(listener, cuContext);
        }
        catch (final IOException e) {
            getLogger().warn(e.getMessage(), e);
        }
    }

    /**
     * ParserConstructor -
     *
     * @author Isaac Griffith
     */
    private class CSharpParserConstructor {

        /**
         * @param file
         * @return
         * @throws IOException
         */
        private synchronized CSharp6Parser loadFile(final String file) throws IOException {
            final CSharp6Lexer lexer = new CSharp6Lexer(new ANTLRFileStream(file));
            final CSharp6PreProcessor pre = new CSharp6PreProcessor(new ANTLRFileStream(file));
            final CommonTokenStream tokens = new CommonTokenStream(pre);
            return new CSharp6Parser(tokens);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see net.siliconcode.sonar.quamoco.QuamocoSensor#getLanguage()
     */
    @Override
    protected String getLanguage() {
        return "cs";
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.sonar.api.batch.CheckProject#shouldExecuteOnProject(org.sonar.api.
     * resources.Project)
     */
    @Override
    public boolean shouldExecuteOnProject(final Project project) {
        final FilePredicates p = fs.predicates();
        return fs.hasFiles(p.hasLanguage("cs"));
    }
}
