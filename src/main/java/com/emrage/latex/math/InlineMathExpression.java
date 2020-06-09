package com.emrage.latex.math;

import com.emrage.latex.LatexGenerator;

public class InlineMathExpression extends MathNode {
    @Override
    public void write(LatexGenerator generator) {
        generator.add(getAsString());
    }

    @Override
    public String getAsString() {
        return "\\begin{math}\n" + getStringBuilder() + "\n\\end{math}\n";
    }
}
