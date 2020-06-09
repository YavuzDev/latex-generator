package com.emrage.latex.position;

import com.emrage.latex.LatexNode;

import java.util.ArrayList;
import java.util.List;

abstract class PositionNode extends LatexNode {

    private final List<LatexNode> nodes;

    public PositionNode() {
        this.nodes = new ArrayList<>();
    }

    public void add(LatexNode node) {
        this.nodes.add(node);
    }

    protected List<LatexNode> getNodes() {
        return nodes;
    }
}
