package com.toinouf.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

    private int size;
    private LineHints lineHints;
    private List<Integer> lineFigures = new ArrayList<>();

    public SudokuSolver(int size, LineHints lineHints) {
        this.size = size;
        this.lineHints = lineHints;
    }

    public List<Integer> solveLine() {
        lineFigures.addAll(missingFigures());
        completeLineWithHints();

        return lineFigures;
    }

    private List<Integer> missingFigures() {
        List<Integer> lineFigures = new ArrayList<>();

        Set<Integer> lineHintsSet = lineHints.values();
        for (int i = 1; i <= size; i++) {
            if (!lineHintsSet.contains(i)) {
                lineFigures.add(i);
            }
        }

        return lineFigures;
    }

    private void completeLineWithHints() {
        for (int i = 0; i < size; i++) {
            if (lineHints.get(i).isPresent()) {
                lineFigures.add(i, lineHints.get(i).get());
            }
        }
    }

}
