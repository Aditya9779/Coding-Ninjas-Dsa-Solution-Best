public class Knapscak {

    /*Recursive Approach*/
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        if (maxWeight == 0 || n == 0) {
            return 0;
        }
        if (weights[n - 1] > maxWeight) {
            return knapsack(weights, values, n - 1, maxWeight);
        } else {
            int includItem = values[n - 1] + knapsack(weights, values, n - 1, maxWeight - weights[n - 1]);
            int excludedItem = knapsack(weights, values, n - 1, maxWeight);
            return Math.max(includItem, excludedItem);
        }
    }

    /***********************************************************************************/
    /*Memozation Recursive*/
    public static int knapsackMemoRec(int[] weights, int[] values, int n, int maxWeight) {
        int store[][] = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                store[i][j] = -1;
            }
        }
        return knapsackHelper(weights, values, n, maxWeight, store);
    }

    private static int knapsackHelper(int[] weights, int[] values, int n, int maxWeight, int[][] store) {
        if (maxWeight == 0 || n == 0) {
            return 0;
        }
        if (store[n][maxWeight] != -1) {
            return store[n][maxWeight];
        }
        if (weights[n - 1] > maxWeight) {
            store[n][maxWeight] = knapsackHelper(weights, values, n - 1, maxWeight, store);
            return store[n][maxWeight];
        } else {
            int incl = values[n - 1] + knapsackHelper(weights, values, n - 1, maxWeight - weights[n - 1], store);
            int elc = knapsackHelper(weights, values, n - 1, maxWeight, store);
            return store[n][maxWeight] = Math.max(incl, elc);
        }
    }

    /***********************************************************************************************/
    /*Memozation Iterative Approach*/
    public static int knapsackDp(int[] weights, int[] values, int n, int maxWeight) {
        int store[][] = new int[n + 1][maxWeight + 1];
        //Row
        for (int i = 0; i <= n; i++) {
            store[i][0] = 0;
        }
        //Col
        for (int i = 0; i <= maxWeight; i++) {
            store[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i - 1] > j) {
                    store[i][j] = store[i - 1][j];
                } else {
                    store[i][j] = Math.max(values[i - 1] + store[i - 1][j - weights[i - 1]], store[i - 1][j]);
                }
            }
        }
        return store[n][maxWeight];
    }

}
