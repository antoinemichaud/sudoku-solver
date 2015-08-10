package com.toinouf.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class LineHints {

    Map<Integer, Integer> lineHints = new HashMap<>();
    private int size;

    public LineHints(int size) {
        this.size = size;
    }

    public LineHints(int size, Map<Integer, Integer> lineHints) {
        this.size = size;
        this.lineHints = lineHints;
    }

    public Optional<Integer> get(int pos) {
        return Optional.ofNullable(lineHints.get(pos));
    }

    public Set<Integer> valuesSet() {
        return lineHints.values().stream().collect(Collectors.toSet());
    }

    public Collection<Integer> values() {
        return lineHints.values();
    }

    public List<Integer> missingFigures() {
        List<Integer> missingFigures = new ArrayList<>();

        Set<Integer> lineHintsSet = valuesSet();
        for (int i = 1; i <= size; i++) {
            if (!lineHintsSet.contains(i)) {
                missingFigures.add(i);
            }
        }

        return missingFigures;
    }

    public boolean isValid() {
        Set<Integer> undiscoveredIntegers = new HashSet<>();
        for (int i = 1; i <= this.size; i++) {
            undiscoveredIntegers.add(i);
        }
        for (Integer foundHint : values()) {
            if (!undiscoveredIntegers.remove(foundHint)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineHints lineHints1 = (LineHints) o;
        if (this.lineHints.size() != lineHints1.lineHints.size()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> indexWithHintEntry : lineHints.entrySet()) {
            if (!indexWithHintEntry.getValue().equals(lineHints1.lineHints.get(indexWithHintEntry.getKey()))) {
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
            stringBuilder.append(get(pos).map(Object::toString).orElse("*")).append(" ");
            if (per3ColumnCounter == 3 || per3ColumnCounter == 6) {
                stringBuilder.append("\t");
            }
        }

        return "LineHints{" +
                "lineHints=\n" + stringBuilder +
                '}';
    }
}
