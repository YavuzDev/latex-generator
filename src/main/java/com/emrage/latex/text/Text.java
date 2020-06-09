package com.emrage.latex.text;

import com.emrage.latex.LatexGenerator;

public class Text extends TextNode {

    @Override
    public void write(LatexGenerator generator) {
        addFlushText(generator);
        generator.addAll(getText());
    }
}
