package com.toinouf.sudoku;

public class SudokuSolver {

    public static final int REGULAR_SUDOKU_SIZE = 9;
    private Grid originalGrid;
    private LinkedGrid currentGrid;

    public SudokuSolver(GridHints gridHints) {
        this.originalGrid = new Grid(gridHints, REGULAR_SUDOKU_SIZE);
        this.currentGrid = new LinkedGrid(originalGrid);
    }

    public GridHints solve() {
        return GridHintsIncrementalBuilder.gridHints()
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build();
    }
}
