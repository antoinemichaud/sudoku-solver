package com.toinouf.functional;

import java.util.ArrayList;
import java.util.List;

public class FunctionalList<T> {

    private List<T> internalList;

    public FunctionalList() {
        this.internalList = new ArrayList<>();
    }

    public FunctionalList(List<T> internalList) {
        this.internalList = new ArrayList<>(internalList);
    }

    public FunctionalList(FunctionalList<T> functionalList) {
        this.internalList = new ArrayList<>(functionalList.internalList);
    }

    public FunctionalList<T> withHead(T elt) {
        FunctionalList<T> result = new FunctionalList<>();
        result.internalList.add(elt);
        result.internalList.addAll(this.internalList);
        return result;
    }

    public FunctionalList<T> withLastElement(T elt) {
        FunctionalList<T> result = new FunctionalList<>();
        result.internalList.addAll(this.internalList);
        result.internalList.add(elt);
        return result;
    }

    public T removeElementAt(int index) {
        this.internalList = new ArrayList<>(this.internalList);
        return this.internalList.remove(index);
    }

    public FunctionalList<T> copy() {
        return new FunctionalList<>(this);
    }

    public int size() {
        return internalList.size();
    }
}
