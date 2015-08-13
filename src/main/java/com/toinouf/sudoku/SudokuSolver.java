package com.toinouf.sudoku;

import com.toinouf.sudoku.permutations.PermutationsFinder;

import java.util.List;

public class SudokuSolver {

    public static final int REGULAR_SUDOKU_SIZE = 9;
    private Grid currentGrid;
    private LineHints rowBeingSolvedNow;
    private int currentRowNum;

    public SudokuSolver(Grid grid, int currentRowNum) {
        this.currentGrid = new Grid(grid);
        this.currentRowNum = currentRowNum;
        this.rowBeingSolvedNow = currentGrid.getRow(currentRowNum);
    }

    public SudokuSolver(GridHints gridHints) {
        this(gridHints, 0);
    }

    public SudokuSolver(GridHints gridHints, int currentRowNum) {
        this.currentGrid = new Grid(gridHints, REGULAR_SUDOKU_SIZE);
        this.currentRowNum = currentRowNum;
        this.rowBeingSolvedNow = currentGrid.getRow(currentRowNum);
    }

    public GridHints solve() {
        PermutationsFinder permutationsFinder = new PermutationsFinder(rowBeingSolvedNow.missingFigures());
        return fillWithAValidPermutation(permutationsFinder.permutations());
    }

    private GridHints fillWithAValidPermutation(List<List<Integer>> possiblePermutations) {
        for (List<Integer> possiblePermutation : possiblePermutations) {
            GridLineFiller gridLineFiller = new GridLineFiller(9, rowBeingSolvedNow);
            List<Integer> filledLine = gridLineFiller.constituteLine(possiblePermutation);
            currentGrid.setRow(currentRowNum, LineHintsBuilder.from(filledLine));
            if (currentGrid.isValid()) {
                break;
            }
        }
        if (currentRowNum == 0)
            return new SudokuSolver(currentGrid, currentRowNum + 1).solve();
        return currentGrid.gridHints;
    }

}
