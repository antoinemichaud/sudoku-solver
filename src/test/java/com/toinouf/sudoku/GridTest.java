package com.toinouf.sudoku;

import com.toinouf.util.Pair;
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
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
    }

    @Test
    public void should_get_first_row_when_one_row() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(0, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(0);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).withHint(0, 3).withHint(8, 9).build());
    }

    @Test
    public void should_get_second_row_when_two_rows() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(1, 0, 3).withHint(0, 8, 9).build(), 9);

        // When
        LineHints lineHints = grid.getRow(1);

        // Then
        assertThat(lineHints).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).withHint(0, 3).build());
    }

    @Test
    public void should_get_columns() throws Exception {
        // Given
        Grid grid = new Grid(gridHints().withHint(1, 0, 3).withHint(2, 7, 9).build(), 9);

        // When / Then
        assertThat(grid.getColumn(0)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).withHint(1, 3).build());
        assertThat(grid.getColumn(1)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(2)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(3)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(4)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(5)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(6)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
        assertThat(grid.getColumn(7)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).withHint(2, 9).build());
        assertThat(grid.getColumn(8)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9).build());
    }

    @Test
    public void should_get_square() throws Exception {
        // Given
        Grid grid = new Grid(GridHintsIncrementalBuilder.gridHints()
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build(), 9);

        // When / Then
        assertThat(grid.getSquare(new Pair<>(0, 0), 3)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9)
                .and(1).and(2).and(3)
                .and(7).and(8).and(9)
                .and(4).and(5).and(6)
                .build());
    }

    @Test
    public void should_get_square_of_index_non_zero_for_column() throws Exception {
        // Given
        Grid grid = new Grid(GridHintsIncrementalBuilder.gridHints()
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build(), 9);

        // When / Then
        assertThat(grid.getSquare(new Pair<>(0, 1), 3)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9)
                .and(2).and(3).and(4)
                .and(8).and(9).and(1)
                .and(5).and(6).and(7)
                .build());
    }

    @Test
    public void should_get_square_for_non_zero_index() throws Exception {
        // Given
        Grid grid = new Grid(GridHintsIncrementalBuilder.gridHints()
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build(), 9);

        // When / Then
        assertThat(grid.getSquare(new Pair<>(1, 1), 3)).isEqualTo(LineHintsBuilder.lineHintsWithSize(9)
                .and(8).and(9).and(1)
                .and(5).and(6).and(7)
                .and(3).and(4).and(5)
                .build());
    }
}