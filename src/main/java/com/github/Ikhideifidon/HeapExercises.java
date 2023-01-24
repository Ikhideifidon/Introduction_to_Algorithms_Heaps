package com.github.Ikhideifidon;


public class HeapExercises {

    public static int youngTableauExtractMin(int[][] Y, int i, int j) {
        int m = Y.length;
        int n = Y[0].length;
        int inf = Integer.MAX_VALUE;
        /**
         * Y = {
         *          {2,  4,  5,  8},
         *          {3,  9,  12, ∞},
         *          {14, 16,  ∞, ∞},
         *          {∞,  ∞,   ∞, ∞}
         *     }
         */
        int result = Y[i][j];
        youngTableauMaxHeapify(Y, i, j);



        // Out of bounds
        if (i >= m || j >= n) return;

        if (Y[i][j] == inf)
            return;








    }

    private static void youngTableauMaxHeapify(int[][] Y, int i, int j, int m, int n) {
        // Out of bounds
        if (i >= m || j >= n) return;
        int parent = Y[i][j];
        int maxNeighbor = parent;
        int downward = Y[i + 1][j];
        int rightward = Y[i][j + 1];
        if (downward > maxNeighbor)
            maxNeighbor = downward;

        if (rightward > maxNeighbor)
            maxNeighbor = rightward;

        if (maxNeighbor != parent) {
            swap(Y, parent, maxNeighbor);
            if (maxNeighbor == downward)
                youngTableauMaxHeapify(Y, i, j + 1, m , n);
            else
                youngTableauMaxHeapify(Y, i + 1, j, m, n);
        }


    }

    private static void swap(int[][] Y, int parent, int neighbor) {
        int temp = parent;
        parent = neighbor;
        neighbor = temp;
    }
}
