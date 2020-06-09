package com.emrage.latex.figure;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

import java.util.ArrayList;
import java.util.List;

public class Figure extends LatexNode {

    private final List<LatexNode> nodes;

    private final FigureType figureType;

    public Figure(FigureType figureType) {
        this.nodes = new ArrayList<>();
        this.figureType = figureType;
    }

    @Override
    public void write(LatexGenerator generator) {
        generator.addln("\\begin{figure}" + "[" + figureType.name().substring(0, 1).toLowerCase() + "]");
        nodes.forEach(n -> n.write(generator));
        generator.addln("\\end{figure}");
    }

    public void add(LatexNode node) {
        this.nodes.add(node);
    }
}
