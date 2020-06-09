package com.emrage.latex.math;

import com.emrage.latex.LatexGenerator;

public class SquareRootExpression extends MathNode {

    @Override
    public String getAsString() {
        return "\\sqrt{" + getStringBuilder() + "}";
    }

    @Override
    public void write(LatexGenerator generator) {
        throw new UnsupportedOperationException("Not allowed to add directly, add to a math expresion");
    }
}
