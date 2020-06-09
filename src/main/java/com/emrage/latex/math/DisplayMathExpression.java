package com.emrage.latex.math;

import com.emrage.latex.LatexGenerator;

public class DisplayMathExpression extends MathNode {
    @Override
    public void write(LatexGenerator generator) {
        generator.add(getAsString());
    }

    @Override
    public String getAsString() {
        return "\\begin{displaymath}\n" + getStringBuilder() + "\n\\end{displaymath}\n";
    }
}
