package com.toinouf.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class LineHints {

    Map<Integer, Integer> lineHints = new HashMap<>();


    public LineHints(Map<Integer, Integer> lineHints) {
        this.lineHints = lineHints;
    }

    public Optional<Integer> get(int pos) {
        return Optional.ofNullable(lineHints.get(pos));
    }

    public Set<Integer> values() {
        return lineHints.values().stream().collect(Collectors.toSet());
    }
}
