package com.toinouf.sudoku;

import java.util.HashMap;
import java.util.Map;

public class LineHintsBuilder {

    private Map<Integer, Integer> lineHints = new HashMap<>();

    public static LineHintsBuilder lineHints() {
        return new LineHintsBuilder();
    }

    public LineHintsBuilder withLineHint(int position, int value) {
        this.lineHints.put(position, value);
        return this;
    }

    public LineHints build() {
        return new LineHints(lineHints);
    }
}
