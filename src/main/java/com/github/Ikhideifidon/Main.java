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
        int inf = Integer.MAX_VALUE;
        int[][] Y = {
                {2,   3,   4,   5},
                {8,   9,   12,  14},
                {16,  inf, inf, inf},
                {inf, inf, inf, inf}
        };

        HeapExercises solution = new HeapExercises();
        System.out.println(Arrays.deepToString(Y));
        solution.insertRecursively(Y, 7);
        System.out.println(solution.search(Y, 12));
        // System.out.println(Arrays.deepToString(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // solution.insert(Y, 1);
        // System.out.println(Arrays.deepToString(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));
        // System.out.println(solution.extractMin(Y));

    }
}