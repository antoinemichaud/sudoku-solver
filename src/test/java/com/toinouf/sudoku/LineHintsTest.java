package com.toinouf.sudoku;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LineHintsTest {

    @Test
    public void should_be_valid_when_a_2_numbers_list_have_1_and_2() throws Exception {
        // Given
        LineHints lineHints = LineHintsBuilder.lineHints().withHint(0, 1).withHint(1, 2).build();

        // When
        boolean valid = lineHints.isValidForSize(2);

        // Then
        assertThat(valid).isTrue();
    }

    @Test
    public void should_be_invalid_when_a_2_numbers_list_have_1_and_1() throws Exception {
        // Given
        LineHints lineHints = LineHintsBuilder.lineHints().withHint(0, 1).withHint(1, 1).build();

        // When
        boolean valid = lineHints.isValidForSize(2);

        // Then
        assertThat(valid).isFalse();
    }

    @Test
    public void should_be_valid_when_a_3_numbers_list_have_1_and_2() throws Exception {
        // Given
        LineHints lineHints = LineHintsBuilder.lineHints().withHint(0, 1).withHint(1, 2).build();

        // When
        boolean valid = lineHints.isValidForSize(3);

        // Then
        assertThat(valid).isTrue();
    }

    @Test
    public void should_be_valid_when_a_3_numbers_list_have_3_1_and_2() throws Exception {
        // Given
        LineHints lineHints = LineHintsBuilder.lineHints().withHint(0, 3).withHint(1, 1).withHint(2, 2).build();

        // When
        boolean valid = lineHints.isValidForSize(3);

        // Then
        assertThat(valid).isTrue();
    }
}