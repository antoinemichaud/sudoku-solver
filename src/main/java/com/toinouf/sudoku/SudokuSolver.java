package com.toinouf.sudoku;

import java.util.List;

public class SudokuSolver {

    public static final int REGULAR_SUDOKU_SIZE = 9;
    private Grid originalGrid;
    private LinkedGrid currentGrid;

    public SudokuSolver(GridHints gridHints) {
        this.originalGrid = new Grid(gridHints, REGULAR_SUDOKU_SIZE);
        this.currentGrid = new LinkedGrid(originalGrid);
    }

    public GridHints solve() {
        LineHints rowToSolve = currentGrid.getRow(0);
        if (!rowToSolve.isValidForSize(9)) {
            List<Integer> missingFigures = GridLineFiller.missingFigures(rowToSolve, 9);
            GridLineFiller gridLineFiller = new GridLineFiller(9, rowToSolve);
            List<Integer> filledLine = gridLineFiller.constituteLine(missingFigures);
            currentGrid.setRow(0, LineHintsBuilder.from(filledLine));
        }

        return currentGrid.gridHints;
    }
}
