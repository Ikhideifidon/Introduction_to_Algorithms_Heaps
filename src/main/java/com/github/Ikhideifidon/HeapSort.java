package com.github.Ikhideifidon;

public class HeapSort<E extends Object & Comparable<E>> {

    public void sort(E[] keys) {
        int n = keys.length;
        // Build a heap
        for (int i = n / 2; i >= 0; i--)
            heapify(keys, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(keys, i, 0);
            heapify(keys, i, 0);
        }
    }

    private void heapify(E[] keys, int n, int parent) {
        // Find the left and the right indices for the leftChild and the rightChild respectively
        int maxChildIndex = parent;
        int left = 1 + (parent << 1);
        int right = 2 + (parent << 1);

        // Is left within the bounds and is the left child larger than the  root node?
        if (left < n && keys[left].compareTo(keys[maxChildIndex]) > 0)
            maxChildIndex = left;

        // Is right within the bounds and is the right child greater than the root node?
        if (right < n && keys[right].compareTo(keys[maxChildIndex]) > 0)
            maxChildIndex = right;

        if (maxChildIndex != parent) {
            swap(keys, parent, maxChildIndex);
            heapify(keys, n, maxChildIndex);
        }
    }

    private void swap(E[] keys, int from, int to) {
        E temp = keys[from];
        keys[from] = keys[to];
        keys[to] = temp;
    }
}
