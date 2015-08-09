package com.toinouf.sudoku;

import org.junit.Test;

import java.util.HashMap;

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
        Grid grid = new Grid(GridHintsBuilder.gridHints().withHint(0, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(0);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHints().withHint(0, 3).withHint(8, 9).build());
    }

    @Test
    public void should_get_second_row_when_two_rows() throws Exception {
        // Given
        Grid grid = new Grid(GridHintsBuilder.gridHints().withHint(1, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(1);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHints().withHint(0, 3).build());
    }
}