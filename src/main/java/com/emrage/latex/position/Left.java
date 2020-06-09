package com.emrage.latex.position;

import com.emrage.latex.LatexGenerator;

public class Left extends PositionNode {

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\begin{left}");
        getNodes().forEach(n -> n.write(generator));
        generator.addln("\\end{left}");
    }
}
