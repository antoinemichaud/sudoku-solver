package com.toinouf.sudoku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineHintsBuilder {

    private Map<Integer, Integer> lineHints = new HashMap<>();
    private int position = 0;

    public static LineHintsBuilder lineHints() {
        return new LineHintsBuilder();
    }

    public static LineHintsBuilder with(int value) {
        LineHintsBuilder lineHintsBuilder = new LineHintsBuilder();
        if (value != 0) {
            lineHintsBuilder.and(value);
        }
        return lineHintsBuilder;
    }

    public LineHintsBuilder and(int value) {
        if (value == 0) {
            return this;
        }
        this.lineHints.put(position, value);
        position++;
        return this;
    }

    public LineHintsBuilder withHint(int position, int value) {
        if (value == 0) {
            return this;
        }
        this.lineHints.put(position, value);
        return this;
    }

    public LineHints build() {
        return new LineHints(lineHints);
    }

    public static LineHints from(List<Integer> filledLine) {
        Map<Integer, Integer> lineHintsMap = new HashMap<>();
        for (int i = 0; i < filledLine.size(); i++) {
            Integer hint = filledLine.get(i);
            lineHintsMap.put(i, hint);
        }
        return new LineHints(lineHintsMap);
    }
}
