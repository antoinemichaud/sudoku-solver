package com.toinouf.sudoku;

import java.util.HashMap;
import java.util.Map;

public class LineHintsBuilder {

    private Map<Integer, Integer> lineHints = new HashMap<>();
    private int position = 0;

    public static LineHintsBuilder lineHints() {
        return new LineHintsBuilder();
    }

    public static LineHintsBuilder with(int value) {
        LineHintsBuilder lineHintsBuilder = new LineHintsBuilder();
        lineHintsBuilder.and(value);
        return lineHintsBuilder;
    }

    public LineHintsBuilder and(int value) {
        this.lineHints.put(position, value);
        position++;
        return this;
    }

    public LineHintsBuilder withHint(int position, int value) {
        this.lineHints.put(position, value);
        return this;
    }

    public LineHints build() {
        return new LineHints(lineHints);
    }
}
