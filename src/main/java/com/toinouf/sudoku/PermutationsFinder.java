package com.toinouf.sudoku;

import com.toinouf.functional.FunctionalList;

import java.util.ArrayList;
import java.util.List;

public class PermutationsFinder {
    private FunctionalList<Integer> figuresToPermute;

    public PermutationsFinder(List<Integer> figuresToPermute) {
        this.figuresToPermute = new FunctionalList<>(figuresToPermute);
    }

    public List<List<Integer>> permutations() {
        return permutationsPrivate(figuresToPermute.copy());
    }

    public List<List<Integer>> permutationsPrivate(FunctionalList<Integer> figuresToPermute) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < figuresToPermute.size(); i++) {
            FunctionalList<Integer> figuresToPermuteForChildren = figuresToPermute.copy();
            Integer chosenHead = figuresToPermuteForChildren.removeElementAt(i);
            if (figuresToPermuteForChildren.size() > 0) {
                List<List<Integer>> childrenPermutations = permutationsPrivate(figuresToPermuteForChildren);
                for (List<Integer> childrenPermutation : childrenPermutations) {
                    List<Integer> onePermutation = new ArrayList<>();
                    onePermutation.add(chosenHead);
                    onePermutation.addAll(childrenPermutation);
                    permutations.add(onePermutation);
                }
            } else {
                ArrayList<Integer> finalPermutation = new ArrayList<>();
                finalPermutation.add(chosenHead);
                permutations.add(finalPermutation);
            }
        }
        return permutations;
    }
}
