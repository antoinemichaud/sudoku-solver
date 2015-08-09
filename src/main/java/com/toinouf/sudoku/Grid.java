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
}
