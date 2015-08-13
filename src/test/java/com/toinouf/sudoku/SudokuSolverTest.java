package com.toinouf.sudoku;

import org.junit.Ignore;
import org.junit.Test;

import static com.toinouf.sudoku.GridHintsIncrementalBuilder.gridHints;
import static com.toinouf.sudoku.assertions.GridHintsAssertions.assertThat;

public class SudokuSolverTest {

    @Test
    public void should_return_a_resolved_grid_as_is() throws Exception {
        // Given
        GridHints gridHints = gridHints()
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
        GridHints gridHints = gridHints()
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
        GridHints gridHints = gridHints()
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
        assertThat(solvedGrid).isEqualTo(gridHints()
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
        GridHints gridHints = gridHints()
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
        assertThat(solvedGrid).isEqualTo(gridHints()
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
        GridHints gridHints = gridHints()
                .then(7, 0, 9).then(1, 0, 3).then(4, 5, 6)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)
                .then(0, 0, 0).then(0, 0, 0).then(0, 0, 0)

                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).includes(gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .build());
    }

    @Test
    public void should_resolve_grid_with_two_holes_in_first_row_according_invalid_square() throws Exception {
        // Given
        GridHints gridHints = gridHints()
                .then(7, 8, 0).then(0, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(0, 0, 0).then(7, 8, 9)
                .then(4, 5, 6).then(0, 0, 0).then(1, 2, 3)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).includes(gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .build());
    }

    @Test
    public void should_resolve_grid_with_one_hole_in_second_row() throws Exception {
        // Given
        GridHints gridHints = gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 0, 6).then(7, 8, 9)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).includes(gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .build());
    }

    @Test
    public void should_resolve_grid_with_one_hole_in_3rd_row() throws Exception {
        // Given
        GridHints gridHints = gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 0, 9).then(1, 2, 3)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).includes(gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 9).then(1, 2, 3)
                .build());
    }

    @Test
    @Ignore
    public void should_resolve_first_row_according_2nd_row_resolution() {
        // Given
        GridHints gridHints = gridHints()
                .then(7, 8, 0).then(1, 0, 3).then(4, 5, 6)
                .then(1, 0, 3).then(4, 5, 6).then(7, 8, 9)
                .then(4, 5, 6).then(7, 8, 0).then(1, 2, 3)
                .build();
        SudokuSolver sudokuSolver = new SudokuSolver(gridHints);

        // When
        GridHints solvedGrid = sudokuSolver.solve();

        // Then
        assertThat(solvedGrid).includes(gridHints()
                .then(7, 8, 9).then(1, 2, 3).then(4, 5, 6)
                .then(1, 2, 3).then(4, 5, 6).then(7, 8, 9)
                .build());
    }
}