package com.toinouf.sudoku;

import com.toinouf.util.Pair;

import java.util.Optional;

public class Grid {

    protected GridHints gridHints;
    private int size;

    public Grid(GridHints gridHints, int size) {
        this.gridHints = gridHints;
        this.size = size;
    }

    public int size() {
        return size;
    }

    public LineHints getRow(int rowNum) {
        LineHints lineHints = new LineHints();
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
        LineHints lineHints = new LineHints();
        for (int i = 0; i < size; i++) {
            Optional<Integer> optionalHint = gridHints.get(i, columnNum);
            if (optionalHint.isPresent()) {
                lineHints.lineHints.put(i, optionalHint.get());
            }
        }
        return lineHints;
    }

    public LineHints getSquare(Pair<Integer> topLeftCornerPos, int size) {
        LineHints lineHints = new LineHints();
        int pos = 0;
        for (int row = topLeftCornerPos.left; row < size + topLeftCornerPos.left; row++) {
            for (int column = topLeftCornerPos.right; column < size + topLeftCornerPos.right; column++) {
                lineHints.lineHints.put(pos, gridHints.get(row, column).orElse(0));
                pos++;
            }
        }
        return lineHints;
    }
}
