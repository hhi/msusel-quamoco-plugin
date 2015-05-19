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
package net.siliconcode.sonar.quamoco.metrics.java;

import net.siliconcode.sonar.quamoco.metrics.JavaMetrics;

import org.sonar.api.measures.Measure;
import org.sonar.java.ast.api.JavaKeyword;
import org.sonar.java.ast.parser.JavaLexer;
import org.sonar.squidbridge.SquidAstVisitor;
import org.sonar.sslr.parser.LexerlessGrammar;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Token;

/**
 * JavaNumFields - Class to count the number of fields in a Java Project
 * 
 * @author isaac
 */
public class JavaNumFields extends SquidAstVisitor<LexerlessGrammar> {

    private int totalNOF = 0;

    /*
     * (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#init()
     */
    @Override
    public void init()
    {
        subscribeTo(JavaLexer.FIELD_DECLARATION);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.sonar.squidbridge.SquidAstVisitor#visitNode(com.sonar.sslr.api.AstNode
     * )
     */
    @Override
    public void visitNode(AstNode astNode)
    {
        boolean isStatic = false;
        for (Token sib : astNode.getTokens())
        {
            if (sib.getType().equals(JavaKeyword.STATIC))
            {
                isStatic = true;
                break;
            }
        }

        if (!isStatic)
        {
            totalNOF += 1;
        }

        super.visitNode(astNode);
    }

    /**
     * @return
     */
    public Measure getTotalNOF()
    {
        return new Measure<Double>(JavaMetrics.NOF, (double) totalNOF);
    }
}