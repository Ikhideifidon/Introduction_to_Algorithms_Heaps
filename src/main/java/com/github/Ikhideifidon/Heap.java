package com.github.Ikhideifidon;

public interface Heap<E extends Object & Comparable<E>> {
    int size();
    void insert(E data);
    E peek();
    E remove();
    E delete(E data);
    boolean isEmpty();
    void increaseKey(int position, E key);
    void decreaseKey(int position, E key);
    void sort();
    E keyOf(int position);
}
