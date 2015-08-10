package com.toinouf.sudoku;

import com.toinouf.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class GridHintsIncrementalBuilder {

    private Map<Pair<Integer>, Integer> gridHints = new HashMap<>();
    private int row = 0, column = 0;

    public static GridHintsIncrementalBuilder gridHints() {
        return new GridHintsIncrementalBuilder();
    }

    public GridHintsIncrementalBuilder then(int a, int b, int c) {
        then(a);
        then(b);
        return then(c);
    }

    public GridHintsIncrementalBuilder then(int value) {
        if (value == 0) {
            increment();
            return this;
        }
        this.gridHints.put(new Pair<>(row, column), value);
        increment();
        return this;
    }

    private void increment() {
        if (column == 8) {
            row++;
            column = 0;
        } else {
            column++;
        }
    }

    public GridHints build() {
        return new GridHints(gridHints);
    }
}
