public class StairCase {
    public static long staircase(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        long stairCase = staircase(n - 1);
        long stairCase2 = staircase(n - 2);
        long stairCase3 = staircase(n - 3);
        return stairCase + stairCase2 + stairCase3;
    }

    /*************************************************************/
    /* Recursive Memo*/
    public static long staircaseMe(int n) {
        long[] storage = new long[n + 1];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = -1;
        }
        return helper(storage, n);
    }

    private static long helper(long[] storage, int n) {
        if (n == 1) {
            return 1; // Base case: There is only one way to climb a staircase of size 1
        } else if (n == 2) {
            return 2; // Base case: There are two ways to climb a staircase of size 2
        } else if (n == 3) {
            return 4; // Base case: There are four ways to climb a staircase of size 3
        }
        if (storage[n] != -1) {
            return storage[n];
        }
        long stairCase = helper(storage, n - 1);
        long stairCase2 = helper(storage, n - 2);
        long stairCase3 = helper(storage, n - 3);
        storage[n] = stairCase + stairCase2 + stairCase3 + 1;
        return storage[n];
    }

    /***********************************************************/
    public static long staircasedp(int n) {
        if (n == 1) {
            return 1;
        }
        long[] storage = new long[n + 1];
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;
        for (int i = 3; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2] + storage[i - 3];
        }
        return storage[n];
    }
}
