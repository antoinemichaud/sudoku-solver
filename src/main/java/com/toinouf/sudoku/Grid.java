package com.toinouf.sudoku;

import com.toinouf.util.Pair;

import java.util.Optional;

import static com.toinouf.sudoku.SudokuSolver.REGULAR_SUDOKU_SIZE;

public class Grid {

    protected GridHints gridHints;
    private int size;

    public Grid(GridHints gridHints, int size) {
        this.gridHints = gridHints;
        this.size = size;
    }

    public Grid(Grid grid) {
        this.gridHints = new GridHints(grid.gridHints);
        this.size = grid.size;
    }

    public int size() {
        return size;
    }

    public LineHints getRow(int rowNum) {
        LineHints lineHints = new LineHints(size);
        for (int i = 0; i < size; i++) {
            Optional<Integer> optionalHint = gridHints.get(rowNum, i);
            if (optionalHint.isPresent()) {
                lineHints.lineHints.put(i, optionalHint.get());
            }
        }
        return lineHints;
    }

    public void setRow(int rowNum, LineHints lineHints) {
        for (int i = 0; i < size; i++) {
            gridHints.gridHints.put(new Pair<>(rowNum, i), lineHints.get(i).orElse(0));
        }
    }

    public LineHints getColumn(int columnNum) {
        LineHints lineHints = new LineHints(size);
        for (int i = 0; i < size; i++) {
            Optional<Integer> optionalHint = gridHints.get(i, columnNum);
            if (optionalHint.isPresent()) {
                lineHints.lineHints.put(i, optionalHint.get());
            }
        }
        return lineHints;
    }

    public LineHints getSquare(Pair<Integer> topLeftCornerPos, int size) {
        LineHints lineHints = new LineHints(size * size);
        int pos = 0;
        for (int row = topLeftCornerPos.left; row < size + topLeftCornerPos.left; row++) {
            for (int column = topLeftCornerPos.right; column < size + topLeftCornerPos.right; column++) {
                Optional<Integer> optionalHint = gridHints.get(row, column);
                if (optionalHint.isPresent()) {
                    lineHints.lineHints.put(pos, optionalHint.orElse(0));
                }
                pos++;
            }
        }
        return lineHints;
    }

    public boolean isValid() {
        return allColumnsAreValid() && allSquaresAreValid();
    }

    private boolean allColumnsAreValid() {
        for (int i = 0; i < REGULAR_SUDOKU_SIZE; i++) {
            if (!getColumn(i).isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean allSquaresAreValid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!getSquare(new Pair<>(i * 3, j * 3), 3).isValid()) {
                    return false;
                }
            }
        }
        return true;
    }
}
