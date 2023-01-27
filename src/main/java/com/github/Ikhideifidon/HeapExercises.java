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
    public int extractMin(int[][] Y) {
        int m = Y.length;
        int n = Y[0].length;
        int min  = Y[0][0];
        if (min == Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Young Tableau is empty");
        Y[0][0] = Integer.MAX_VALUE;
        youngifyTopDown(Y, 0, 0, m, n);
        return min;
    }

    public void insert(int[][] Y, int key) {
        // Check if Y is non-full.
        // If non-full put key in the last available spot (ideally, this should be at Y[m - 1][n - 1])
        // This will violate the Young Tableau order.
        // To correct this violation, minHeapify Y.
        // Order is now restored.

        int i = Y.length - 1;
        int j = Y[0].length - 1;
        if (Y[i][j] != Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Young Tableau is full");

        Y[i][j] = key;
        // MinHeapify
        // Allowed directions
        int x, y;
        x = i;
        y = j;
        int max = Integer.MAX_VALUE;
        int temp = 0;

        while ((i > 0 || i > 0) && max > Y[i][j]) {
            // Swap Y[i][j] with Y[x][y]
            temp = Y[i][j];
            Y[i][j] = Y[x][y];
            Y[x][y] = temp;

            // Set the new values for i and j
            i = x;
            j = y;

            // Upward
            if (j > 0 && Y[i][j] < Y[i][j - 1]) {
                x = i;
                y = j - 1;
            }

            // Leftward
            if (i > 0 && Y[x][y] < Y[i - 1][j]) {
                x = i - 1;
                y = j;
            }

            max = Y[x][y];
        }
    }

    public void insertRecursively(int[][] Y, int key) {
        // Check if Y is non-full.
        // If non-full put key in the last available spot (ideally, this should be at Y[m - 1][n - 1])
        // This will violate the Young Tableau order.
        // To correct this violation, minHeapify Y.
        // Order is now restored.

        int i = Y.length - 1;
        int j = Y[0].length - 1;
        if (Y[i][j] != Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Young Tableau is full");

        Y[i][j] = key;
        helper(Y, i, j);
    }

    private void helper(int[][] Y, int i, int j) {
        int upward = i > 0 ? Y[i - 1][j] : Integer.MIN_VALUE;
        int leftward = j > 0 ? Y[i][j - 1] : Integer.MIN_VALUE;

        // Base case
        // Stable position (No swap)
        if (Y[i][j] > upward && Y[i][j] > leftward) return;

        int temp = Y[i][j];
        if (leftward > upward) {
            // Must be greater than Y[i][j]
            // Swap Y[i][j] with Y[i][j - 1]
            Y[i][j] = Y[i][j - 1];
            Y[i][j - 1] = temp;
            helper(Y, i, j - 1);
        } else {
            // Swap Y[i][j] with Y[i - 1][j]
            Y[i][j] = Y[i - 1][j];
            Y[i - 1][j] = temp;
            helper(Y, i - 1, j);
        }


        
    }


    // MinHeapify
    private void youngifyTopDown(int[][] Y, int i, int j, int m, int n) {
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


