package com.toinouf.sudoku;

import com.toinouf.util.Pair;

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
            lineHints.lineHints.put(i, gridHints.get(rowNum, i).orElse(0));
        }
        return lineHints;
    }

    public LineHints getColumn(int columnNum) {
        LineHints lineHints = new LineHints();
        for (int i = 0; i < size; i++) {
            lineHints.lineHints.put(i, gridHints.get(i, columnNum).orElse(0));
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
