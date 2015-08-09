package com.toinouf.sudoku;

import com.toinouf.util.Pair;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class SudokuSolverTest {

    @Test
    public void should_resolve_this() throws Exception {
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
}