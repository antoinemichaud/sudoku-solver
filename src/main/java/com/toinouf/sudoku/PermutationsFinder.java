package com.toinouf.sudoku;

import java.util.ArrayList;
import java.util.List;

public class PermutationsFinder {
    private List<Integer> figuresToPermute;

    public PermutationsFinder(List<Integer> figuresToPermute) {
        this.figuresToPermute = figuresToPermute;
    }

    public List<List<Integer>> permutations() {
        return permutationsPrivate(new ArrayList<>(figuresToPermute));
    }

    public List<List<Integer>> permutationsPrivate(List<Integer> figuresToPermute) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < figuresToPermute.size(); i++) {
            ArrayList<Integer> figuresToPermuteForChildren = new ArrayList<>(figuresToPermute);
            Integer chosenHead = figuresToPermuteForChildren.remove(i);
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
