package com.toinouf.sudoku;

import com.toinouf.sudoku.permutations.PermutationsFinder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SudokuSolver {

    public static final int REGULAR_SUDOKU_SIZE = 9;
    private Grid currentGrid;
    private LineHints rowBeingSolvedNow;
    private int currentRowNum;
    private PermutationsFinder permutationsFinder;

    public SudokuSolver(Grid grid, int currentRowNum) {
        this.currentGrid = new Grid(grid);
        this.currentRowNum = currentRowNum;
        this.rowBeingSolvedNow = currentGrid.getRow(currentRowNum);
        this.permutationsFinder = new PermutationsFinder(rowBeingSolvedNow.missingFigures());
    }

    public SudokuSolver(GridHints gridHints) {
        this(gridHints, 0);
    }

    public SudokuSolver(GridHints gridHints, int currentRowNum) {
        this.currentGrid = new Grid(gridHints, REGULAR_SUDOKU_SIZE);
        this.currentRowNum = currentRowNum;
        this.rowBeingSolvedNow = currentGrid.getRow(currentRowNum);
        permutationsFinder = new PermutationsFinder(rowBeingSolvedNow.missingFigures());
    }

    public GridHints solve() {
        return fillWithAValidPermutation().get();
    }

    private Optional<GridHints> fillWithAValidPermutation() {
        return fillWithAValidPermutation(new LinkedList<>(permutationsFinder.permutations()));
    }

    private Optional<GridHints> fillWithAValidPermutation(Deque<List<Integer>> possiblePermutations) {
        if (possiblePermutations.isEmpty()) {
            return Optional.empty();
        }
        int initialSize = possiblePermutations.size();
        for (int i = 0; i < initialSize; i++) {
            List<Integer> possiblePermutation = possiblePermutations.removeFirst();
            GridLineFiller gridLineFiller = new GridLineFiller(9, rowBeingSolvedNow);
            List<Integer> filledLine = gridLineFiller.constituteLine(possiblePermutation);
            currentGrid.setRow(currentRowNum, LineHintsBuilder.from(filledLine));
            if (currentGrid.isValid()) {
                break;
            }
        }
        if (thisRowHaveChild()) {
            Optional<GridHints> childResolution = resolutionOfChild();
            if (childResolution.isPresent()) {
                return childResolution;
            } else {
                return fillWithAValidPermutation(possiblePermutations);
            }
        }
        if (currentGrid.isValid()) {
            return Optional.of(currentGrid.gridHints);
        }
        return Optional.empty();
    }

    private boolean thisRowHaveChild() {
        return currentRowNum < REGULAR_SUDOKU_SIZE - 1;
    }

    private Optional<GridHints> resolutionOfChild() {
        return new SudokuSolver(currentGrid, currentRowNum + 1).fillWithAValidPermutation();
    }

}
