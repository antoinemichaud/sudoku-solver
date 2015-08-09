package com.toinouf.sudoku;

import com.toinouf.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class GridHintsBuilder {

    private Map<Pair<Integer>, Integer> gridHints = new HashMap<>();

    public static GridHintsBuilder gridHints() {
        return new GridHintsBuilder();
    }

    public GridHintsBuilder withHint(int row, int column, int value) {
        this.gridHints.put(new Pair<>(row, column), value);
        return this;
    }

    public GridHints build() {
        return new GridHints(gridHints);
    }
}
