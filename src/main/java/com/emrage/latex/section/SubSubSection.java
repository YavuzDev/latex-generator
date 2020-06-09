package com.emrage.latex.section;

import com.emrage.latex.LatexGenerator;

public class SubSubSection extends SectionNode {
    public SubSubSection(String section) {
        super(section);
    }

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\subsubsection{" + getSection() + "}");
        getNodes().forEach(n -> n.write(generator));
    }
}
