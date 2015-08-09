package com.toinouf.sudoku;


import org.junit.Test;

import java.util.List;

import static com.toinouf.sudoku.LineHintsBuilder.lineHints;
import static org.assertj.core.api.Assertions.assertThat;

public class GridLineFillerTest {

    @Test
    public void should_be_able_to_find_combination_for_one_line_of_1_figure() {
        // Given
        GridLineFiller gridLineFiller = new GridLineFiller(1, lineHints().build());

        // When
        List<Integer> lineFigures = gridLineFiller.constituteLine();

        // Then
        assertThat(lineFigures).containsExactly(1);
    }

    @Test
    public void should_be_able_to_find_combination_for_one_line_of_2_figures() {
        // Given
        GridLineFiller gridLineFiller = new GridLineFiller(2, lineHints().build());

        // When
        List<Integer> lineFigures = gridLineFiller.constituteLine();

        // Then
        assertThat(lineFigures).containsExactly(1, 2);
    }

    @Test
    public void should_be_able_to_find_combination_for_one_line_of_2_figures_and_one_hint() {
        // Given
        GridLineFiller gridLineFiller = new GridLineFiller(2, lineHints().withLineHint(0, 2).build());

        // When
        List<Integer> lineFigures = gridLineFiller.constituteLine();

        // Then
        assertThat(lineFigures).containsExactly(2, 1);
    }

    @Test
    public void should_be_able_to_find_combination_for_one_line_of_9_figures_and_two_hints() {
        // Given
        GridLineFiller gridLineFiller = new GridLineFiller(9, lineHints().withLineHint(0, 2).withLineHint(5, 1).build());

        // When
        List<Integer> lineFigures = gridLineFiller.constituteLine();

        // Then
        assertThat(lineFigures).containsExactly(2, 3, 4, 5, 6, 1, 7, 8, 9);
    }

}
