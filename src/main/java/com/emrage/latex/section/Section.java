package com.emrage.latex.section;

import com.emrage.latex.LatexGenerator;

public class Section extends SectionNode {

    public Section(String section) {
        super(section);
    }

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\section{" + getSection() + "}");
        getNodes().forEach(n -> n.write(generator));
    }
}
