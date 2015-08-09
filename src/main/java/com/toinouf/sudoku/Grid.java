package com.toinouf.sudoku;

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
}
