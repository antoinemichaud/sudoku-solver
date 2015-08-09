package com.toinouf.sudoku;

public class LinkedGrid extends Grid {

    private Grid previousGrid;

    public LinkedGrid(GridHints gridHints, Grid previousGrid) {
        super(gridHints, previousGrid.size());
        this.previousGrid = previousGrid;
    }

    public LinkedGrid(Grid currentGrid) {
        super(currentGrid.gridHints, currentGrid.size());
        this.previousGrid = null;
    }
}
