package com.emrage.latex.text;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

import java.util.ArrayList;
import java.util.List;

abstract class TextNode extends LatexNode {

    private final List<String> text;

    private Flush flush;

    public TextNode() {
        this.text = new ArrayList<>();
        this.flush = Flush.NONE;
    }

    public void add(String text) {
        this.text.add(text);
    }

    public void addln(String text) {
        this.text.add(text + "\n");
    }

    protected void addFlushText(LatexGenerator generator) {
        generator.add(flush == Flush.NONE ? "" : flush.asString() + "\n");
    }

    protected List<String> getText() {
        return text;
    }

    public void setFlush(Flush flush) {
        this.flush = flush;
    }
}
