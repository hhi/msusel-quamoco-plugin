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
package net.siliconcode.quamoco.codetree;

import com.google.gson.annotations.Expose;

import net.siliconcode.quamoco.distiller.keys.FlyweightKeyFactory;

/**
 * MethodNOde -
 *
 * @author Isaac Griffith
 */
public class MethodNode extends CodeNode {

    @Expose
    private boolean constructor;

    private MethodNode() {
        super();
        constructor = false;
    }

    /**
     * @param identifier
     * @param start
     * @param end
     */
    public MethodNode(final CodeNode owner, final String identifier, final boolean constructor, final int start,
            final int end) {
        super(owner, identifier, start, end);
        this.constructor = constructor;
    }

    public boolean isConstructor() {
        return constructor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.siliconcode.quamoco.codetree.CodeNode#getType()
     */
    @Override
    public String getType() {
        return CodeNodeType.METHOD;
    }

    /**
     * @param constructor
     */
    public void setConstructor(final boolean constructor) {
        this.constructor = constructor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.siliconcode.quamoco.codetree.CodeNode#updateKey()
     */
    @Override
    protected void updateKey() {
        if (identifier != null) {
            final String shortName = identifier.getShortKey();
            if (owner != null) {
                identifier = FlyweightKeyFactory.getInstance().getKey(owner.getQIdentifier() + "#" + shortName,
                        shortName);
            }
            else {
                identifier = FlyweightKeyFactory.getInstance().getKey(shortName, shortName);
            }
        }
    }
}