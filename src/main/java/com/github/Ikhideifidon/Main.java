package com.github.Ikhideifidon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] keys = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(keys);
        System.out.println(Arrays.toString(keys));
    }
}