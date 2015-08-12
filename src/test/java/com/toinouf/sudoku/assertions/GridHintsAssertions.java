package com.toinouf.sudoku.assertions;

import com.toinouf.sudoku.GridHints;
import com.toinouf.util.Pair;
import org.assertj.core.api.AbstractAssert;

import java.util.Optional;

public class GridHintsAssertions extends AbstractAssert<GridHintsAssertions, GridHints> {
    private GridHintsAssertions(GridHints actual) {
        super(actual, GridHintsAssertions.class);
    }

    public static GridHintsAssertions assertThat(GridHints actual) {
        return new GridHintsAssertions(actual);
    }

    public GridHintsAssertions includes(GridHints gridHints) {
        for (Pair<Integer> hintPosition : gridHints.getKeys()) {
            Integer row = hintPosition.left;
            Integer column = hintPosition.right;
            Optional<Integer> hintOptional = gridHints.get(row, column);
            if (!hintOptional.equals(actual.get(row, column))) {
                failWithMessage("\nExpected hints grid to contain <%s> at position [%d, %d]\n" +
                                "but instead contains <%s>.",
                        hintOptional.map(Object::toString).orElse("*"), row, column,
                        actual.get(row, column).map(Object::toString).orElse("*"));
            }
        }
        return this;
    }
}
