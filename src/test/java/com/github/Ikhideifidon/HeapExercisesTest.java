package com.github.Ikhideifidon;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapExercisesTest {

    HeapExercises solution;
    Random rand;
    int m = 11;
    int n = 11;
    int[][] YoungTableau = new int[m][n];

    // Utility Method
    private void swap(int[] A, int from, int to) {
        int temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }

    @BeforeAll
    public void setUp() {
        solution = new HeapExercises();
        int[] A = new int[100];
        rand = new Random(0);
        // Initialize the array A
        Arrays.setAll(A, i -> i + 1);
        
        // Shuffle the array A
        for (int i = A.length; i > 0; i--) {
            int upperLimit = rand.nextInt(i);
            swap(A, i - 1, upperLimit);
        }

        // Populate YT with Integer.MAX_VALUE
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                YoungTableau[i][j] = Integer.MAX_VALUE;
        }

        // Insert data into YT
        for (int data : A) {
            solution.insert(YoungTableau, data);
        }
    }
    
    @Test
    void testExtractMin() {
        System.out.println(solution.extractMin(YoungTableau));
    }

    @Test
    void testInsert() {

    }

    @Test
    void testInsertRecursively() {

    }
}
