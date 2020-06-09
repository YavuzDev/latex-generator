package com.emrage.latex.section;

import com.emrage.latex.LatexGenerator;

public class SubSection extends SectionNode {
    public SubSection(String section) {
        super(section);
    }

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\subsection{" + getSection() + "}");
        getNodes().forEach(n -> n.write(generator));
    }
}
