package com.toinouf.sudoku;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuSolverTest {

    @Test
    public void should_resolve_one_grid() throws Exception {
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
    @Ignore
    public void should_resolve_another_grid() throws Exception {
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
    @Ignore
    public void should_resolve_grid_with_hole() throws Exception {
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
}