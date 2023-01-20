package com.github.Ikhideifidon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(5);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(12);
        maxHeap.insert(17);

        System.out.println(maxHeap);
    }
}