package com.emrage.latex.helper;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

public class Break extends LatexNode {
    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\break");
    }
}
