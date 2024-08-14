public class LCS {
    /* Recursive Approach*/
    public static int lcs(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            int op1 = lcs(s.substring(1), t.substring(1));
            int op2 = lcs(s.substring(1), t);
            int op3 = lcs(s, t.substring(1));
            return Math.max(op1, Math.max(op2, op3));
        }

    }

    /*****************************************************************************/

    /*Meomzation Recusive*/
    public static int lcsMemoRec(String s, String t) {
        int storage[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                storage[i][j] = -1;
            }
        }
        return lcsMemoRecHelper(s, t, storage);
    }

    private static int lcsMemoRecHelper(String s, String t, int[][] store) {
        int n = s.length();
        int m = t.length();
        if (n == 0 || m == 0) {
            return 0;
        }
        if (store[n][m] != -1) {
            return store[n][m];
        }
        if (s.charAt(0) == t.charAt(0)) {
            store[n][m] = 1 + lcsMemoRecHelper(s.substring(1), t.substring(1), store);
            return store[n][m];
        } else {
            int op1 = lcsMemoRecHelper(s.substring(1), t, store);
            int op2 = lcsMemoRecHelper(s, t.substring(1), store);
            //   int op3 = lcsMemoRecHelper(s.substring(1), t.substring(1), store);
            //We can skip this line because we store this thing in the first recusion call in the array
            store[n][m] = Math.max(op1, op2);
            return store[n][m];
        }
    }

    /*******************************************************************************/

    /*Memozation Iterative Approach*/
    public static int lcsDP(String s, String t) {
        int m = s.length(); //row
        int n = t.length(); //col
        int[][] store = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            store[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            store[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    store[i][j] = 1 + store[i - 1][j - 1];
                } else {
                    store[i][j] = Math.max(store[i - 1][j], Math.max(store[i - 1][j - 1],store[i][j - 1]));
                }
            }
        }
        return store[m][n];
    }
}

