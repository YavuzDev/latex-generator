package com.emrage.latex.position;

import com.emrage.latex.LatexGenerator;

public class Right extends PositionNode {

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\begin{center}");
        getNodes().forEach(n -> n.write(generator));
        generator.addln("\\end{center}");
    }
}
