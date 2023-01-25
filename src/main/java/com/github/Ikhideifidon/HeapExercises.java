package com.github.Ikhideifidon;


public class HeapExercises {

    /**
     * Y = {
     *          {2,  4,  5,  8},
     *          {3,  9,  12, ∞},
     *          {14, 16,  ∞, ∞},
     *          {∞,  ∞,   ∞, ∞}
     *     }
     */
    public static int extractMin(int[][] Y) {
        int m = Y.length;
        int n = Y[0].length;
        int min  = Y[0][0];
        if (min == Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Young Tableau is empty");
        Y[0][0] = Integer.MAX_VALUE;
        youngifyTopDown(Y, 0, 0, m, n);
        return min;
    }

    public static void insert(int[][] Y, int key) {
        // Check if Y is non-full.
        // If non-full put key in the last available spot (ideally, this should be at Y[m - 1][n - 1])
        // This will violate the Young Tableau order.
        // To correct this violation, minHeapify Y (youngifyBottomUp).
        // Order is restored now.

        int m = Y.length;
        int n = Y[0].length;
        if (Y[m - 1][n - 1] != Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Young Tableau is full");

        Y[m - 1][n - 1] = key;
        youngifyBottomUp(Y, m - 1, n - 1, m, n);
    }

    // minHeapify
    private static void youngifyBottomUp(int[][] Y, int i, int j, int m, int n) {
        // Out of bounds
        if (i < 0 && j < 0) return;

        int parent = Y[i][j];
        int leftward = (j - 1 >= 0)? Y[i][j - 1] : Integer.MAX_VALUE;
        int upward = (i - 1 >= 0) ? Y[i - 1][j] : Integer.MAX_VALUE;

        // Base case
        // Check if upward (Y[i - 1][j]) and leftward (Y[i][j - 1]) are less than Y[i][j]
        if (parent > leftward && parent > upward) return;

        int temp = Y[i][j];
        if (upward < leftward) {
            // swap Y[i][j] with Y[i - 1][j]
            Y[i][j] = Y[i - 1][j];
            Y[i - 1][j] = temp;
            youngifyBottomUp(Y, i - 1, j, m, n);
        }

        else {
            // swap Y[i][j] with Y[i][j - 1]
            Y[i][j] = Y[i][j - 1];
            Y[i][j - 1] = temp;
            youngifyBottomUp(Y, i, j - 1, m, n);
        }
    }

    // MinHeapify
    private static void youngifyTopDown(int[][] Y, int i, int j, int m, int n) {
        // Out of bounds
        if (i + 1 >= m || j + 1 >= n) return;

        // Base case
        if (Y[i][j + 1] == Y[i + 1][j] && Y[i + 1][j] == Integer.MAX_VALUE) return;                 // is Y empty?

        int temp = Y[i][j];
        if (Y[i][j + 1] < Y[i + 1][j]) {
            // swap Y[i][j + 1] with Y[i][j]
            Y[i][j] = Y[i][j + 1];
            Y[i][j + 1] = temp;
            youngifyTopDown(Y, i, j + 1, m , n);
        }

        else {
            // swap Y[i + 1][j] with Y[i][j]
            Y[i][j] = Y[i + 1][j];
            Y[i + 1][j] = temp;
            youngifyTopDown(Y, i + 1, j, m, n);
        }
    }
}


