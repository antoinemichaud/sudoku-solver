package com.toinouf.sudoku;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class LineHints {

    Map<Integer, Integer> lineHints = new HashMap<>();

    public LineHints() {
    }

    public LineHints(Map<Integer, Integer> lineHints) {
        this.lineHints = lineHints;
    }

    public Optional<Integer> get(int pos) {
        return Optional.ofNullable(lineHints.get(pos));
    }

    public Set<Integer> values() {
        return lineHints.values().stream().collect(Collectors.toSet());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineHints lineHints1 = (LineHints) o;
        for (Map.Entry<Integer, Integer> indexWithHintEntry : lineHints.entrySet()) {
            if (!indexWithHintEntry.getValue().equals(lineHints1.get(indexWithHintEntry.getKey()).orElse(0))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Map.Entry<Integer, Integer> indexWithHintEntry : lineHints.entrySet()) {
            hash += Objects.hash(indexWithHintEntry.getKey(), indexWithHintEntry.getValue());
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int per3ColumnCounter = 0;
        for (int pos = 0; pos < 9; pos++) {
            per3ColumnCounter++;
            stringBuilder.append(get(pos).map(identity()).orElse(0)).append(" ");
            if (per3ColumnCounter == 3 || per3ColumnCounter == 6) {
                stringBuilder.append("\t");
            }
        }

        return "LineHints{" +
                "lineHints=\n" + stringBuilder +
                '}';
    }
}
