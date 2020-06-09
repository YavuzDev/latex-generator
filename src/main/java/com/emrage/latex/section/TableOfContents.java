package com.emrage.latex.section;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

public class TableOfContents extends LatexNode {

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\tableofcontents");
    }
}
