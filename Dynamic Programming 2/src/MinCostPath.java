public class MinCostPath {

    /*Input.length refers to the number of rows in the input array.
input[0].length refers to the number of columns in the first row of the input array.
Therefore, in int storage[][] = new int[input.length][input[0].length];:

The first dimension (input.length) specifies the number of rows.
The second dimension (input[0].length) specifies the number of columns.*/ //How to declare the two dimensional array in rows and columns

    /********************************************************************************************/
    public static int minCostPath(int[][] input) {
        return recursiveHelper(input, 0, 0);
    }

    private static int recursiveHelper(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;
        if (i == m - 1 && j == n - 1) {  //We are stand on the last point
            return arr[i][j];
        }
        if (i >= m || j >= n) {   //Checking the condition if they are in limit of range
            return Integer.MAX_VALUE;
        }
        int op1 = recursiveHelper(arr, i + 1, j);
        int op2 = recursiveHelper(arr, i, j + 1);
        int op3 = recursiveHelper(arr, i + 1, j + 1);
        return arr[i][j] + Math.min(op1, Math.min(op2, op3));
    }

    /********************************************************************************************/
    /*Memozation Recurisve*/
    public static int minCostPathMemoRe(int[][] input) {
        int storage[][] = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                storage[i][j] = -1;
            }
        }
        return helperMinCostPathMemoRe(input, 0, 0, storage);
    }

    private static int helperMinCostPathMemoRe(int[][] input, int i, int j, int[][] storage) {
        int m = input.length;
        int n = input[0].length;
        if (i == m - 1 && j == n - 1) {
            storage[i][j] = input[i][j];
            return storage[i][j];
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (storage[i][j] != -1) {
            return storage[i][j];
        }
        int op1 = helperMinCostPathMemoRe(input, i + 1, j, storage);
        int op2 = helperMinCostPathMemoRe(input, i, j + 1, storage);
        int op3 = helperMinCostPathMemoRe(input, i + 1, j + 1, storage);
        storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));
        return storage[i][j];
    }

    /*********************************************************************************************/
    /*Momozation Iterative*/
    public static int minCostPathDP(int[][] input) {
        int row = input.length;
        int column = input[0].length;
        int[][] storage = new int[row][column];
        storage[0][0] = input[0][0];
        //For row and column very imp
        /*https://study.com/cimages/multimages/16/matrix432714309408327411.png*/
        for (int i = 1; i < column; i++) {
            storage[0][i] = storage[0][i - 1] + input[0][i];
        }
        for (int i = 1; i < row; i++) {
            storage[i][0] = storage[i - 1][0] + input[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                storage[i][j] = Math.min(storage[i - 1][j], Math.min(storage[i][j - 1], storage[i - 1][j - 1])) + input[i][j];
            }
        }
        return storage[row - 1][column - 1];
    }


}
