public class MimumCountToMakeSqu {
    /*Recursive Approach*/
    public static int minCount(int n) {
        if (n == 0) {
            return 0;
        }
        int minCountSteps = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minCountSteps = Math.min(minCountSteps, minCount(n - i * i));
        }
        return minCountSteps + 1;
    }

    /* Memozation Recursive*/
    public static int minCountMemoRe(int n) {
        int stoage[] = new int[n + 1];
        return helper(stoage, n);
    }

    private static int helper(int[] stoage, int n) {
        if (n == 0) {
            stoage[0] = 0;
            return stoage[0];
        }
        if (stoage[n] != 0) {
            return stoage[n];
        }
        int mincount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int cur = helper(stoage, n - i * i);
            mincount = Math.min(mincount, cur);
        }
        stoage[n] = mincount + 1;
        return stoage[n];
    }

    /*Memozation Iterative Approach*/
    public static int minCountMemoIT(int n) {
        int storage[] = new int[n + 1];
        storage[0] = 0;
        for (int i = 1; i * i <= n; i++) {
        int mincount = Integer.MAX_VALUE;
         for (int j = 1; j*j<=i; j ++) {
             mincount = Math.min(mincount, storage[i-j*j]);
         }
         storage[i] = mincount +1;
        }
        return storage[n];
    }

}
