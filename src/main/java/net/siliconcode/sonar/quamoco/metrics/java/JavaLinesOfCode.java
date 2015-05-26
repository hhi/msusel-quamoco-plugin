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

import java.util.List;

import org.sonar.squidbridge.SquidAstVisitor;
import org.sonar.sslr.parser.LexerlessGrammar;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;

/**
 * JavaLinesOfCode -
 * 
 * @author Isaac Griffith
 */
public class JavaLinesOfCode extends SquidAstVisitor<LexerlessGrammar> {

    /* (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#init()
     */
    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }

    /* (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#visitFile(com.sonar.sslr.api.AstNode)
     */
    @Override
    public void visitFile(AstNode astNode)
    {
        // TODO Auto-generated method stub
        super.visitFile(astNode);
    }

    /* (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#visitNode(com.sonar.sslr.api.AstNode)
     */
    @Override
    public void visitNode(AstNode astNode)
    {
        // TODO Auto-generated method stub
        super.visitNode(astNode);
    }

    /* (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#leaveNode(com.sonar.sslr.api.AstNode)
     */
    @Override
    public void leaveNode(AstNode astNode)
    {
        // TODO Auto-generated method stub
        super.leaveNode(astNode);
    }

    /* (non-Javadoc)
     * @see org.sonar.squidbridge.SquidAstVisitor#leaveFile(com.sonar.sslr.api.AstNode)
     */
    @Override
    public void leaveFile(AstNode astNode)
    {
        // TODO Auto-generated method stub
        super.leaveFile(astNode);
    }

}
