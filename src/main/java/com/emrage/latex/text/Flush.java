package com.emrage.latex.text;

public enum Flush {
    LEFT,
    RIGHT,
    CENTER,
    NONE;

    protected String asString() {
        return switch (this) {
            case LEFT:
                yield "\\flushleft";
            case RIGHT:
                yield "\\flushright";
            case CENTER:
                yield "\\centering";
            case NONE:
                yield "";
        };
    }
}
