public class BalancedTree {
    /* Recursive Approach*/
    public static long balancedBTs(long n) {
        int mod = (int) Math.pow(10, 9) + 7;
        return helperModular(n, mod);
    }

    private static long helperModular(long n, int mod) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long left = balancedBTs(n - 1);
        long right = balancedBTs(n - 2);
        long ansLeftMod = left * left % mod;
        long ansRightMod = 2 * left * right % mod;
        return (ansLeftMod + ansRightMod) % mod;
    }

    /**************************************************************************/
    /*Memoziation Recursive*/
    public static long balancedBTsRecursive(long n) {
        long storage[] = new long[(int) (n + 1)];
        return helperBtRe(storage, n);
    }

    private static long helperBtRe(long[] storage, long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (storage[(int) n] != 0) {
            return storage[(int) n];
        }
        long left = helperBtRe(storage, n - 1);
        long right = helperBtRe(storage, n - 2);
        storage[(int) n] = left * left + 2 * right * left;
        return storage[(int) n];
    }

    /****************************************************************************/
    /* Meomoziation Iterative*/

    public static long balancedBTsIterative(int n) {
        int storage[] = new int[n + 1];
        storage[0] = 1;
        storage[1] = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 2; i <= n; i++) {
            long left = (long) storage[i - 1] * storage[i - 1] % mod;
            long right = (long) 2 * storage[i - 1] * storage[i - 2] % mod;
            storage[i] = (int) ((left + right) % mod);
        }
        return storage[n];
    }

    public static void main(String[] args) {

        long n = 16; /* For the number is too big we are getting in negatibe
        so we have to learn the new concept of the Module */
        System.out.println(balancedBTs(n));
    }
}
