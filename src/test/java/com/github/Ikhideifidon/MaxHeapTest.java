package com.github.Ikhideifidon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import java.util.Arrays;

import static java.lang.System.out;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaxHeapTest {

    Heap<String> maxHeap;
    String[] strings;

    @BeforeEach
    public void setMaxHeap() {
        strings = new String[]{"please", "always", "be", "a", "good", "representative", "of", "your", "family", "everywhere", "you", "go"};
        maxHeap = new MaxHeap<>(strings);
    }

    @Test
    void size() {
        Assertions.assertEquals(maxHeap.size(), strings.length);
    }

    @Test
    void insert() {
        maxHeap.insert("christian");
        Assertions.assertEquals(maxHeap.size(), strings.length + 1);
    }

    @Test
    void peek() {
        String answer = "your";
        Assertions.assertEquals(maxHeap.peek(), answer);
    }

    @Test
    void delete() {
        int size = maxHeap.size();
        Assertions.assertEquals(maxHeap.peek(), maxHeap.delete());
        Assertions.assertEquals(maxHeap.size(), size - 1);
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(maxHeap.isEmpty());
    }

    @Test
    void increaseKey() {
    }

    @Test
    void decreaseKey() {
    }

    @Test
    void sort() {
        Integer[] keys = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Integer[] clonedKeys = keys.clone();
        MaxHeap<Integer> heap = new MaxHeap<>(keys);
        heap.sort(keys);
        Arrays.sort(clonedKeys);
        Assertions.assertEquals(Arrays.toString(keys), Arrays.toString(clonedKeys));
    }

    @Test
    void keyOf() {
        out.println(maxHeap.keyOf(1));
    }
}