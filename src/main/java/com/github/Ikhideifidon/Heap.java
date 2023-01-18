package com.github.Ikhideifidon;

public interface Heap<E extends Object & Comparable<E>> {
    int size();
    E peek();
    E remove();
    E delete(E data);
    E keyOf(int position);
    boolean isEmpty();
    void insert(E data);
    void increaseKey(int position, E key);
    void decreaseKey(int position, E key);
    void sort();

}
