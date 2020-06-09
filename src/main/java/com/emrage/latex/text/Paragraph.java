package com.emrage.latex.text;

import com.emrage.latex.LatexGenerator;

public class Paragraph extends TextNode {

    @Override
    public void write(LatexGenerator generator) {
        addFlushText(generator);
        generator.addln("\\par");
        generator.addAll(getText());
    }
}
