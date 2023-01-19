package com.github.Ikhideifidon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements a dynamic Maximum Heap using an array as the underlying data structure.
 * @param <E>
 */
public class MaxHeap<E extends Object & Comparable<E>> extends HeapSort<E> implements Heap<E>, Iterator<E>  {
    private static final int DEFAULT_CAPACITY = 16;
    private E[] container;
    private int t;

    public MaxHeap(int capacity) {
        if (capacity < 1)
            throw new ArrayStoreException("Heap underflow");
        this.t = 0;
        //noinspection unchecked
        this.container = (E[]) new Object[capacity + 1];
    }

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create a Maximum Heap from a given array.
     * @param keys: The given array.
     */
    public MaxHeap(E[] keys) {
        this(keys.length);
        for (E key : keys)
            this.insert(key);
    }

    @Override
    public int size() {
        return t;
    }

    @Override
    public void insert(E data) {
        // Check if capacity is full
        if (t >= container.length - 1)
            ensureCapacity(2 * container.length);
        container[++t] = data;
        trickleUp(t);
    }

    @Override
    public E peek() {
        if (this.isEmpty()) throw new NullPointerException("Heap is empty");
        return container[1];
    }


    private static int index = 0;
    @Override
    public boolean hasNext() {
        return ++index != t;
    }

    @Override
    public E next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return container[index];
    }

    @Override
    public E delete() {
        if (this.isEmpty())
            throw new NullPointerException("Heap is empty");

        E root = this.peek();
        swap(t, 1);
        // Deallocate the space at t
        container[t--] = null;
        trickleDown(1);

        // Underlying array size halving.
        // Space conservation
        if (t < container.length / 4)
            ensureCapacity(container.length / 2);
        return root;
    }

    @Override
    public boolean isEmpty() {
        return (t == 0);
    }

    /**
     * Increase the key of container[position] to key
     * @param position : An array index
     * @param key : A new key greater than container[position]
     */
    @Override
    public void increaseKey(int position, E key) {
        if (position < 1 || position > t)
            throw new ArrayIndexOutOfBoundsException(position + " is out of range");
        if (key.compareTo(container[position]) <= 0)
            throw new IllegalArgumentException(key + " cannot be less than or equal to " + container[position]);

        container[position] = key;
        trickleUp(position);
    }

    @Override
    public void decreaseKey(int position, E key) {
        if (position < 1 || position > t)
            throw new ArrayIndexOutOfBoundsException(position + " is out of range");
        if (key.compareTo(container[position]) >= 0)
            throw new IllegalArgumentException(key + " cannot be greater than or equal to " + container[position]);

        container[position] = key;
        trickleDown(position);

    }

    @Override
    public E keyOf(int position) {
        if (position < 1 || position > t)
            throw new ArrayIndexOutOfBoundsException(position + " is out of range");
        return container[position];
    }

    private void trickleUp(int position) {
        if (position == 1) return;                  // Does the heap contains only one element?

        // Find the parent of this position
        int parent = position >> 1;
        if (container[parent].compareTo(container[position]) < 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }

    private void trickleDown(int parent) {
        // Find the left and the right children
        int left = parent << 1;
        int right = 1 + (parent << 1);

        // Check out of bounds
        if (left > t || right > t) return;

        // if left is a leaf node
        if (left == t && container[left].compareTo(container[parent]) > 0) {
            swap(parent, left);
            return;
        }

        // If right is a leaf node
        if (right == t && container[right].compareTo(container[parent]) > 0) {
            swap(parent, right);
            return;
        }

        // If both left and right children are not leaves
        int maxChildIndex = container[left].compareTo(container[right]) > 0 ? left : right;
        if (container[maxChildIndex].compareTo(container[parent]) > 0) {
            swap(parent, maxChildIndex);
            trickleDown(maxChildIndex);
        }
    }

    private void ensureCapacity(int newCapacity) {
        this.container = Arrays.copyOf(this.container, newCapacity);
    }

    private void swap(int from, int to) {
        E temp = container[from];
        container[from] = container[to];
        container[to] = temp;
    }

    @Override
    public String toString() {
        this.container = Arrays.copyOfRange(this.container, 1, this.container.length);
        return Arrays.toString(this.container);
    }
}
