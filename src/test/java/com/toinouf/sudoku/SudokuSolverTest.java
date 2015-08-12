package com.toinouf.sudoku;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuSolverTest {

    @Test
    public void should_return_a_resolved_grid_as_is() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).isEqualTo(gridHints);
    }

    @Test
    public void should_return_another_resolved_grid_as_is() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).isEqualTo(gridHints);
    }

    @Test
    public void should_resolve_grid_with_hole_in_position_1_1() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(0, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).isEqualTo(GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build());
    }

    @Test
    public void should_resolve_grid_with_hole_in_position_1_5() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 9).then(1, 0, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).isEqualTo(GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)

                .then(2, 3, 4).then(5, 6, 7).then(8, 9, 1)
                .then(5, 6, 7).then(8, 9, 1).then(2, 3, 4)
                .then(8, 9, 1).then(2, 3, 4).then(5, 6, 7)

                .then(3, 4, 5).then(6, 7, 8).then(9, 1, 2)
                .then(6, 7, 8).then(9, 1, 2).then(3, 4, 5)
                .then(9, 1, 2).then(3, 4, 5).then(6, 7, 8)
                .build());
    }

    @Test
    public void should_resolve_grid_with_two_holes_in_first_row_according_invalid_column() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(7, 0, 9).then(1, 0, 3).then(4, 5, 6)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)

                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).isEqualTo(GridHintsIncrementalBuilder.gridHints()

                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)

                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .build());
    }

    @Test
    public void should_resolve_grid_with_two_holes_in_first_row_according_invalid_square() throws Exception {
        // Given
        GridHints gridHints = GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 0).then(0, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(0, 0, 0).then(7, 8, 9)
                .then(4, 5, 6).then(0, 0, 0).then(1, 2, 3)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        GridHints expectedResult = GridHintsIncrementalBuilder.gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(0, 0, 0).then(7, 8, 9)
                .then(4, 5, 6).then(0, 0, 0).then(1, 2, 3)
                .build();
        assertThat(solvedGrid).isEqualTo(expectedResult);
    }
}