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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int per3ColumnCounter = 0;
        int per3RowCounter = 0;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                per3ColumnCounter++;
                stringBuilder.append(get(row, column).orElse(0)).append(" ");
                if (per3ColumnCounter == 3 || per3ColumnCounter == 6) {
                    stringBuilder.append("\t");
                }
                if (per3ColumnCounter == 9) {
                    per3ColumnCounter = 0;
                    per3RowCounter++;
                    stringBuilder.append("\n");
                    if (per3RowCounter == 3 || per3RowCounter == 6) {
                        stringBuilder.append("\n");
                    }
                }
            }
        }

        return "GridHints{" +
                "gridHints=\n" + stringBuilder +
                '}';
    }
}
