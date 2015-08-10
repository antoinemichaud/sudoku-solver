package com.toinouf.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GridLineFiller {

    private int size;
    private LineHints lineHints;
    private List<Integer> lineFigures = new ArrayList<>();

    public GridLineFiller(int size, LineHints lineHints) {
        this.size = size;
        this.lineHints = lineHints;
    }

    public List<Integer> constituteLine() {
        return constituteLine(missingFigures(lineHints, size));
    }

    public List<Integer> constituteLine(List<Integer> missingFigures) {
        lineFigures.addAll(missingFigures);
        completeLineWithHints();

        return lineFigures;
    }

    public static List<Integer> missingFigures(LineHints lineHints, int size) {
        List<Integer> missingFigures = new ArrayList<>();

        Set<Integer> lineHintsSet = lineHints.values();
        for (int i = 1; i <= size; i++) {
            if (!lineHintsSet.contains(i)) {
                missingFigures.add(i);
            }
        }

        return missingFigures;
    }

    private void completeLineWithHints() {
        for (int i = 0; i < size; i++) {
            if (lineHints.get(i).isPresent()) {
                lineFigures.add(i, lineHints.get(i).get());
            }
        }
    }

}
