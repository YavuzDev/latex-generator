package com.emrage.latex.helper;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

public class NewLine extends LatexNode {
    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\newline");
    }
}
