package com.toinouf.sudoku;

import com.toinouf.util.Pair;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class GridHints {

    Map<Pair<Integer>, Integer> gridHints = new HashMap<>();


    public GridHints(Map<Pair<Integer>, Integer> gridHints) {
        this.gridHints = gridHints;
    }

    public Optional<Integer> get(int row, int column) {
        return Optional.ofNullable(gridHints.get(new Pair<>(row, column)));
    }

    public Set<Integer> values() {
        return gridHints.values().stream().collect(toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridHints gridHints1 = (GridHints) o;
        for (Map.Entry<Pair<Integer>, Integer> indexWithHintEntry : gridHints.entrySet()) {
            if (!gridHints1.gridHints.get(indexWithHintEntry.getKey()).equals(indexWithHintEntry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Map.Entry<Pair<Integer>, Integer> indexWithHintEntry : gridHints.entrySet()) {
            hash += Objects.hash(indexWithHintEntry.getKey(), indexWithHintEntry.getValue());
        }

        return hash;
    }
}
