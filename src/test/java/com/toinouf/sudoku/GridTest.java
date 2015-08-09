package com.toinouf.sudoku;

import org.junit.Test;

import java.util.HashMap;

import static com.toinouf.sudoku.GridHintsBuilder.gridHints;
import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    public void should_get_first_row_when_empty() throws Exception {
        // Given
        Grid grid = new Grid(new GridHints(new HashMap<>()), 9);

        // When
        LineHints lineHints = grid.getRow(0);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHints().build());
    }

    @Test
    public void should_get_first_row_when_one_row() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(0, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(0);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHints().withHint(0, 3).withHint(8, 9).build());
    }

    @Test
    public void should_get_second_row_when_two_rows() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(1, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(1);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHints().withHint(0, 3).build());
    }

    @Test
    public void should_get_columns() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(1, 0, 3).withHint(2, 7, 9).build(), 9);

        // When
        LineHints lineHintsCollection = grid.getColumn(0);

        // Then
        assertThat(grid.getColumn(0)).isEqualTo(LineHintsBuilder.lineHints().withHint(1, 3).build());
        assertThat(grid.getColumn(1)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(2)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(3)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(4)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(5)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(6)).isEqualTo(LineHintsBuilder.lineHints().build());
        assertThat(grid.getColumn(7)).isEqualTo(LineHintsBuilder.lineHints().withHint(2, 9).build());
        assertThat(grid.getColumn(8)).isEqualTo(LineHintsBuilder.lineHints().build());
    }
}