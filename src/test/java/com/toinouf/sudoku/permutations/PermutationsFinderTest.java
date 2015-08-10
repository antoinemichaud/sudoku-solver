package com.toinouf.sudoku.permutations;

import org.junit.Test;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

public class PermutationsFinderTest {

    @Test
    public void should_have_empty_list_of_permutation_when_parameter_is_an_empty_list() throws Exception {
        // Given
        PermutationsFinder permutationsFinder = new PermutationsFinder(new ArrayList<>());

        // When / Then
        assertThat(permutationsFinder.permutations()).isEmpty();
    }

    @Test
    public void should_have_one_list_containing_1_integer() throws Exception {
        // Given
        PermutationsFinder permutationsFinder = new PermutationsFinder(newArrayList(1));

        // When / Then
        assertThat(permutationsFinder.permutations()).hasSize(1);
        assertThat(permutationsFinder.permutations().get(0)).containsExactly(1);
    }

    @Test
    public void should_have_two_lists_containing_1_2_and_2_1() throws Exception {
        // Given
        PermutationsFinder permutationsFinder = new PermutationsFinder(newArrayList(1, 2));

        // When / Then
        assertThat(permutationsFinder.permutations()).hasSize(2);
        assertThat(permutationsFinder.permutations().get(0)).containsExactly(1, 2);
        assertThat(permutationsFinder.permutations().get(1)).containsExactly(2, 1);
    }

    @Test
    public void should_have_6_lists_containing_many_things() throws Exception {
        // Given
        PermutationsFinder permutationsFinder = new PermutationsFinder(newArrayList(1, 2, 3));

        // When / Then
        assertThat(permutationsFinder.permutations()).hasSize(6);
        assertThat(permutationsFinder.permutations().get(0)).containsExactly(1, 2, 3);
        assertThat(permutationsFinder.permutations().get(1)).containsExactly(1, 3, 2);
        assertThat(permutationsFinder.permutations().get(2)).containsExactly(2, 1, 3);
        assertThat(permutationsFinder.permutations().get(3)).containsExactly(2, 3, 1);
        assertThat(permutationsFinder.permutations().get(4)).containsExactly(3, 1, 2);
        assertThat(permutationsFinder.permutations().get(5)).containsExactly(3, 2, 1);
    }

}