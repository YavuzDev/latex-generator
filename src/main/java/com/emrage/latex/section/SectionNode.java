package com.emrage.latex.section;

import com.emrage.latex.LatexNode;

import java.util.ArrayList;
import java.util.List;

abstract class SectionNode extends LatexNode {

    private final String section;

    private final List<LatexNode> nodes;

    public SectionNode(String section) {
        this.section = section;
        this.nodes = new ArrayList<>();
    }

    public void add(LatexNode node) {
        this.nodes.add(node);
    }

    protected String getSection() {
        return section;
    }

    protected List<LatexNode> getNodes() {
        return nodes;
    }
}
