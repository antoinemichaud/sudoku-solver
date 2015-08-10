package com.toinouf.sudoku;

import com.toinouf.sudoku.permutations.PermutationsFinder;

import java.util.List;

public class SudokuSolver {

    public static final int REGULAR_SUDOKU_SIZE = 9;
    private Grid originalGrid;
    private LinkedGrid currentGrid;
    private LineHints rowBeingSolvedNow;

    public SudokuSolver(GridHints gridHints) {
        this.originalGrid = new Grid(gridHints, REGULAR_SUDOKU_SIZE);
        this.currentGrid = new LinkedGrid(originalGrid);
    }

    public GridHints solve() {
        rowBeingSolvedNow = currentGrid.getRow(0);

        if (!rowBeingSolvedNow.isValid()) {
            PermutationsFinder permutationsFinder = new PermutationsFinder(rowBeingSolvedNow.missingFigures());
            fillWithAValidPermutation(permutationsFinder.permutations());
        }

        return currentGrid.gridHints;
    }

    private void fillWithAValidPermutation(List<List<Integer>> possiblePermutations) {
        for (List<Integer> possiblePermutation : possiblePermutations) {
            GridLineFiller gridLineFiller = new GridLineFiller(9, rowBeingSolvedNow);
            List<Integer> filledLine = gridLineFiller.constituteLine(possiblePermutation);
            currentGrid.setRow(0, LineHintsBuilder.from(filledLine));
            if (currentGrid.isValid()) {
                break;
            }
        }
    }

}
