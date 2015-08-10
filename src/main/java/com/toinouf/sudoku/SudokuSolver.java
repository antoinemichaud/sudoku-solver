package com.toinouf.sudoku;

import com.toinouf.sudoku.permutations.PermutationsFinder;

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
            PermutationsFinder permutationsFinder = new PermutationsFinder(missingFigures);
            List<List<Integer>> possiblePermutations = permutationsFinder.permutations();

            for (List<Integer> possiblePermutation : possiblePermutations) {
                GridLineFiller gridLineFiller = new GridLineFiller(9, rowToSolve);
                List<Integer> filledLine = gridLineFiller.constituteLine(possiblePermutation);
                currentGrid.setRow(0, LineHintsBuilder.from(filledLine));
                boolean isGridValid = true;
                for (int i = 0; i < REGULAR_SUDOKU_SIZE; i++) {
                    isGridValid = currentGrid.getColumn(i).isValidForSize(REGULAR_SUDOKU_SIZE);
                    if (!isGridValid)
                        break;
                }
                if (isGridValid) {
                    break;
                }
            }
        }

        return currentGrid.gridHints;
    }
}
