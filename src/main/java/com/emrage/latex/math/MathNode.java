package com.emrage.latex.math;

import com.emrage.latex.LatexNode;

abstract class MathNode extends LatexNode {

    private final StringBuilder stringBuilder;

    public MathNode() {
        this.stringBuilder = new StringBuilder();
    }

    public abstract String getAsString();

    public void addCharacter(char character) {
        stringBuilder.append(character);
    }

    public void addSquareRoot(String text) {
        stringBuilder.append("\\sqrt{").append(text).append("}");
    }

    public void addText(String text) {
        stringBuilder.append(text);
    }

    public void addPowerOf(char powerOf) {
        stringBuilder.append("^").append(powerOf);
    }

    protected StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
