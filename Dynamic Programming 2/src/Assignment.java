import java.util.Arrays;
import java.util.HashMap;

public class Assignment {
    public static int findMaxSquareWithAllZerosRe(int[][] input) {
        if (input.length == 0 || input[0].length == 0) {
            return 0;
        }
        int maxSero = 0;
        int rows = input.length;
        int cols = input[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxSero = Math.max(maxSero, helperrecu(input, i, j));
            }
        }
        return maxSero;
    }

    private static int helperrecu(int[][] input, int row, int col) {
        if (row < 0 || col < 0) {  //We cant write like row and col == zero because its the condition for
            //finding the output in the maxzero
            return 0;
        }
        if (input[row][col] == 1) {  //We are not writting row-1 and col-1 because this case is never come
            // because of the above for loop
            return 0;
        } else {
            int op1 = helperrecu(input, row - 1, col);
            int op2 = helperrecu(input, row, col - 1);
            int op3 = helperrecu(input, row - 1, col - 1);
            return 1 + Math.min(op1, Math.min(op2, op3));
        }

    }

    /*_________________________________________________________________________*/
    public static int findMaxSquareWithAllZerosMemoRecursive(int[][] input) {
        if (input.length == 0 || input[0].length == 0) {
            return 0;
        }
        int maxSquareZero = 0;
        int rows = input.length, cols = input[0].length;
        int[][] store = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                store[i][j] = -1;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxSquareZero = Math.max(maxSquareZero, helperRecur(input, i, j, store));
            }

        }
        return maxSquareZero;
    }

    private static int helperRecur(int[][] input, int row, int col, int[][] store) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (store[row][col] != -1) {
            return store[row][col];
        }
        if (input[row][col] == 1) {
            store[row][col] = 0;
            return 0;
        } else {
            int op1 = helperRecur(input, row - 1, col, store);
            int op2 = helperRecur(input, row, col - 1, store);
            int op3 = helperRecur(input, row - 1, col - 1, store);
            store[row][col] = 1 + Math.min(op1, Math.min(op2, op3));
            return store[row][col];
        }
    }

    /*_____________________________________________________________________________*/
    public static int findMaxSquareWithAllZerosDP(int[][] input) {
        if (input.length == 0 || input[0].length == 0) {
            return 0;
        }
        int maxSquareZero = 0;
        int rows = input.length, cols = input[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (input[i][0] == 0) {
                dp[i][0] = 1;
                maxSquareZero = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (input[0][j] == 0) {
                dp[0][j] = 1;
                maxSquareZero = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (input[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));

                    if (dp[i][j] > maxSquareZero) {
                        maxSquareZero = dp[i][j];
                    }
                }
            }
        }
        return maxSquareZero;
    }


    /*********************************************************************************************************/


    public static int smallestSuperSequence(String str1, String str2) {
        // Get lengths of the strings
        int m = str1.length();
        int n = str2.length();

        // Call the recursive function with string lengths
        return smallestSuperSequence(str1, str2, m, n);
    }

    public static int smallestSuperSequence(String str1, String str2, int m, int n) {
        // If either string is empty, return the length of the other string
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        // If the last characters are the same, include them both and recur for the remaining strings
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + smallestSuperSequence(str1, str2, m - 1, n - 1);
        }

        // Otherwise, consider including the last character of either string and recur
        return 1 + Math.min(smallestSuperSequence(str1, str2, m - 1, n), smallestSuperSequence(str1, str2, m, n - 1));
    }

    /*___________________________________________________________________________*/
    public static int smallestSuperSequenceMemoRec(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();
        int[][] store = new int[row + 1][col + 1];

        // Initialize the memoization table with -1
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                store[i][j] = -1;
            }
        }

        return smallestHelper(str1, str2, store, row, col);
    }

    private static int smallestHelper(String str1, String str2, int[][] store, int row, int col) {
        // Base cases
        if (row == 0) {
            return col;
        }
        if (col == 0) {
            return row;
        }

        // Check if the value is already computed
        if (store[row][col] != -1) {
            return store[row][col];
        }

        // If the characters are the same, move to the next characters in both strings
        if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
            store[row][col] = 1 + smallestHelper(str1, str2, store, row - 1, col - 1);
        } else {
            // Calculate all possible options
            int op1 = smallestHelper(str1, str2, store, row, col - 1);
            int op2 = smallestHelper(str1, str2, store, row - 1, col);
            store[row][col] = 1 + Math.min(op1, op2);
        }

        return store[row][col];
    }
    /*___________________________________________________________________________________________________________*/

    public static int smallestSuperSequenceMemoIter(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();
        if (row == 0) {
            return col;
        }
        if (col == 0) {
            return row;
        }
        int store[][] = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            store[i][0] = i;
        }
        for (int i = 0; i <= col; i++) {
            store[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    store[i][j] = store[i - 1][j - 1] + 1;
                } else {
                    store[i][j] = 1 + Math.min(store[i - 1][j], store[i][j - 1]);
                }
            }
        }
        return store[row][col];
    }

    /**************************************************************************************************************/

    public static int getMinimumStrength(int grid[][]) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0; // Empty grid requires no strength
        }
        return getMinimumRecHelper(grid, 0, 0);
    }

    /*The provided code defines two methods: `getMinimumStrength` and `getMinimumRecHelper`, which together calculate the minimum initial strength required for a character to traverse from the top-left corner to the bottom-right corner of a grid.

### Explanation:

1. **`getMinimumStrength` Method**:
- This is the public method that users can call to get the minimum strength required.
- It checks if the grid is empty and returns 0 if it is.
- Otherwise, it calls the recursive helper method `getMinimumRecHelper` to compute the minimum strength needed, starting from the top-left corner of the grid.

2. **`getMinimumRecHelper` Method**:
- This is the private recursive helper method that actually computes the minimum strength needed.
- It takes the grid, the current row, and the current column as input parameters.
- It first checks if the current cell is the bottom-right corner of the grid.
- If it is, it calculates the minimum required strength to survive this cell based on its value. The expression `Math.max(1, 1 - grid[row][col])` ensures that the character always has at least 1 strength after considering the cell's value.
- If the current cell is not the bottom-right corner, it recursively explores two possible moves: right and down.
- For each move, it calculates the minimum strength needed considering the grid value and the strength needed for the next cell.
- It updates the `minValueSurv`, which represents the minimum required strength to survive the current cell.
- After exploring both moves, it returns the maximum of `minValueSurv` and 1. This ensures that the character has at least 1 strength to survive, even if the calculated value for `minValueSurv` is less than 1.

### Conclusion:
The code correctly computes the minimum initial strength required for the character to traverse the grid from the top-left corner to the bottom-right corner while ensuring survival at each cell.*/
    private static int getMinimumRecHelper(int[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        if (row == rowLength - 1 && col == colLength - 1) {
            return Math.max(1, 1 - grid[row][col]);
        }
        int minValueSurv = Integer.MAX_VALUE;
        if (row < rowLength - 1) {
            int downGrid = getMinimumRecHelper(grid, row + 1, col);
            minValueSurv = Math.min(minValueSurv, downGrid - grid[row][col]);
        }
        if (col < colLength - 1) {
            int rightGrid = getMinimumRecHelper(grid, row, col + 1);
            minValueSurv = Math.min(minValueSurv, rightGrid - grid[row][col]);
        }
        return Math.max(minValueSurv, 1);
    }

    /*__________________________________________________________________________________________________________________*/
    /*Memozation Recursive*/
    public static int getMinimumStrengthMemoRe(int grid[][]) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int store[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                store[i][j] = -1;
            }
        }
        /*Short Way to declare*/
        /*for (int i = 0; i < grid.length; i++) {
            Arrays.fill(store[i], -1);
        }*/
        return MemoRecurHelper(grid, store, 0, 0);
    }

    private static int MemoRecurHelper(int[][] grid, int[][] store, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (store[row][col] != -1) {
            return store[row][col];
        }
        if (row == rowLength - 1 && col == colLength - 1) {
            store[row][col] = Math.max(1, 1 - grid[row][col]);
            return store[row][col];
        }
        int minValue = Integer.MAX_VALUE;
        if (row < rowLength - 1) {
            int downGrid = MemoRecurHelper(grid, store, row + 1, col);
            minValue = Math.min(minValue, downGrid - grid[row][col]);
        }
        if (col < colLength - 1) {
            int rightGrid = MemoRecurHelper(grid, store, row, col + 1);
            minValue = Math.min(minValue, rightGrid - grid[row][col]);
        }
        store[row][col] = Math.max(minValue, 1);

        return store[row][col];
    }

    /*___________________________________________________________________________________________________________________*/
    public static int getMinimumStrengthDP(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0; // Empty grid requires no strength
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];

        // Initialize the bottom-right cell
        dp[rowLength - 1][colLength - 1] = Math.max(1, 1 - grid[rowLength - 1][colLength - 1]);

        // Fill the last row
        for (int j = colLength - 2; j >= 0; j--) {
            dp[rowLength - 1][j] = Math.max(1, dp[rowLength - 1][j + 1] - grid[rowLength - 1][j]);
            //in this row is fixed
        }

        // Fill the last column
        for (int i = rowLength - 2; i >= 0; i--) {
            dp[i][colLength - 1] = Math.max(1, dp[i + 1][colLength - 1] - grid[i][colLength - 1]);
        }

        // Fill the rest of the matrix
        for (int i = rowLength - 2; i >= 0; i--) {
            for (int j = colLength - 2; j >= 0; j--) {
                int minNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minNext - grid[i][j]);
            }
        }

        return dp[0][0];
    }

    /*********************************************************************************************************************/

    public static int getMin(int[] arr, int N) {
        if (N <= 0) {
            return 0;
        }

        // Array to store the number of chocolates for each student
        int[] chocolates = new int[N];

        // Calculate the chocolates for each student using a recursive approach
        for (int i = 0; i < N; i++) {
            chocolates[i] = getChocolates(arr, chocolates, i);
        }

        // Sum all chocolates
        int totalChocolates = 0;
        for (int choco : chocolates) {
            totalChocolates += choco;
        }

        return totalChocolates;
    }

    private static int getChocolates(int[] arr, int[] chocolates, int index) {
        // Base case: If chocolates are already assigned, return the value
        if (chocolates[index] != 0) {
            return chocolates[index];
        }

        // Give one chocolate initially
        int choco = 1;

        // If the current student has a higher score than the previous one
        if (index > 0 && arr[index] > arr[index - 1]) {
            choco = getChocolates(arr, chocolates, index - 1) + 1;
        }

        // If the current student has a higher score than the next one
        if (index < arr.length - 1 && arr[index] > arr[index + 1]) {
            choco = Math.max(choco, getChocolates(arr, chocolates, index + 1) + 1);
        }

        // Assign the calculated chocolates to the current student
        chocolates[index] = choco;
        return choco;
    }

    /*_______________________________________________________________________________________________________________________*/
    public static int getMinMemoRecu(int arr[], int n) {
        if (arr.length == 0 || n <= 0) {
            return 0;
        }
        int chocolate[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            chocolate[i] = chocolatrHelper(arr, i, chocolate, map);
        }
        int totalChocolates = 0;
        for (int choco : chocolate) {
            totalChocolates += choco;
        }
        return totalChocolates;
    }

    private static int chocolatrHelper(int[] arr, int index, int choclate[], HashMap<Integer, Integer> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (choclate[index] != 0) {
            return choclate[index];
        }
        int choco = 1;
        if (index > 0 && arr[index] > arr[index - 1]) {
            choco = chocolatrHelper(arr, index - 1, choclate, map) + 1;
        }
        if (index < arr.length - 1 && arr[index] > arr[index + 1]) {
            choco = Math.max(choco, chocolatrHelper(arr, index + 1, choclate, map) + 1);
        }
        choclate[index] = choco;
        map.put(index, choco);
        return choco;
    }

    /*_________________________________________________________________________________________________________________________*/
    public static int getMinChocDp(int arr[], int n) {
        if (arr.length == 0 || n <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] chocolates = new int[n];
        chocolates[0] = 1;
        map.put(arr[0], 1);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                chocolates[i] = chocolates[i - 1] + 1;
            } else {
                chocolates[i] = 1;
            }
            map.put(i, chocolates[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                chocolates[i] = Math.max(chocolates[i], chocolates[i + 1] + 1);
            }
            map.put(i, chocolates[i]);
        }
        int totalChocolates = 0;
        for (int choco : chocolates) {
            totalChocolates += choco;
        }
        return totalChocolates;
    }

    /**************************************************************************************************************************/

    public static boolean isSubsetPresent(int[] arr, int n, int sum) {
        if (arr.length == 0 || n <= 0) {
            return false;
        }

        // Remove unnecessary isPresent variable and early return within loop
        for (int i = 0; i < n; i++) {
            if (isHelper(arr, i, sum)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHelper(int[] arr, int index, int sum) {
        if (sum == 0) {
            return true; // Found a subset with sum 0 (empty subset)
        }
        if (index >= arr.length || sum < 0) {
            return false;
        }

        // Include the current element and check if the sum can be achieved
        if (arr[index] <= sum) {
            if (isHelper(arr, index + 1, sum - arr[index])) {
                return true;
            }
        }

        // Exclude the current element and check if the sum can be achieved
        return isHelper(arr, index + 1, sum);
    }

    /*__________________________________________________________________________________________________________________________*/
   /* public static boolean isSubsetPresentMemoRecur(int[] arr, int n, int sum) {
        if (arr.length == 0 || n <= 0) {
            return false;
        }
        boolean store[][] = new boolean[n][sum+1];
        for (int i = 0; i < n; i++) {
          Arrays.fill(store[i], null);
        }

          return isHelperRecur(arr, n, sum, store);

    }

    private static boolean isHelperRecur(int[] arr, int index, int sum, boolean[][] store) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length || sum < 0) {
            return false;
        }
        boolean ideHelp=store[index-1][sum];
        if (ide!=null) {
            return store[index-1][sum];
        }
        if (arr[index-1] <= sum) {
            store[index-1][sum] = isHelperRecur(arr, index+1, sum-arr[index], store);
            if(store[index-1][sum]){
                return true;
            }
        }
       store[index-1][sum] = isHelper(arr, index+1, sum);
        return store[index-1][sum];
    }*/

    public static boolean isSubsetPresentMemoRe(int[] arr, int n, int sum) {
        if (arr.length == 0 || n <= 0) {
            return false;
        }

        // Creating a memoization table to store results of subproblems
        Boolean[][] memo = new Boolean[n][sum + 1];

        // Boolean array to track if subproblem has been computed
        boolean[][] computed = new boolean[n][sum + 1];

        return isHelper(arr, n, sum, memo, computed);
    }

    private static boolean isHelper(int[] arr, int index, int sum, Boolean[][] memo, boolean[][] computed) {
        if (sum == 0) {
            return true; // Found a subset with sum 0 (empty subset)
        }
        if (index <= 0 || sum < 0) {
            return false;
        }

        // Check if result is already computed
        if (computed[index - 1][sum]) {
            return memo[index - 1][sum];
        }

        // Include the current element and check if the sum can be achieved
        if (arr[index - 1] <= sum) {
            memo[index - 1][sum] = isHelper(arr, index - 1, sum - arr[index - 1], memo, computed);
            if (memo[index - 1][sum]) {
                computed[index - 1][sum] = true;
                return true;
            }
        }

        // Exclude the current element and check if the sum can be achieved
        memo[index - 1][sum] = isHelper(arr, index - 1, sum, memo, computed);
        computed[index - 1][sum] = true;
        return memo[index - 1][sum];
    }

    /*_____________________________________________________________________________________________________________________________*/

    public static boolean isSubsetPresentDP(int[] arr, int n, int sum) {
        if (arr.length == 0 || n <= 0) {
            return false;
        }

        // Creating a memoization table to store results of subproblems
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // subset with sum 0 (empty subset) is always possible
        }

        // Filling the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element can contribute to the sum
                    // We have two choices:
                    // 1. Include the current element and check if the remaining sum can be achieved
                    //    using the elements up to index i - 1.
                    if (dp[i - 1][j - arr[i - 1]]) {
                        dp[i][j] = true;
                    } else {
                        // 2. Don't include the current element and check if the sum can be achieved
                        //    without it, using the elements up to index i - 1.
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    // If the current element is greater than the required sum
                    // We have no choice but to exclude it, as including it would
                    // make the sum exceed the required value.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }


}

