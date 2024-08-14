public class FibonaciSeries {

    /*Time Complexity is O(2^n)*/
    public static int fibnoaciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibnoaciRecursive(n - 1) + fibnoaciRecursive(n - 2);
    }

    /*****************************************************************/
    /* Memoziation Recursive Approach */
    /*  Top to Bottom Approach*/
    /* Time complexity is O(n)*/
    public static int fibnoaciMemoziatinRecurive(int n) {
        int[] store = new int[n + 1];
        for (int i = 0; i < store.length; i++) {
            store[i] = -1;
        }
        return fibnoaciMemozationRecurHel(store, n);
    }

    /* Hence this storing the value is known as Memoization */
    /*In this resucrsice approach we are doing the redudant call (Means doing the same thing
     *  every time) so in dynamic programming we store the value for not calculating every time */
    private static int fibnoaciMemozationRecurHel(int[] store, int n) {
        if (n == 0 || n == 1) {
            store[n] = n;
            return store[n];
        }
        if (store[n] != -1) {
            return store[n];
        }
        store[n] = fibnoaciMemozationRecurHel(store, n - 1) + fibnoaciMemozationRecurHel(store, n - 2);
        return store[n];
    }

    /**********************************************************************/

    /* Memoziation Iterative Approach this is called the Dynamic Approach */
    /* Bottom to Top   Approach*/
    public static int fibnoaciIterativeMemozation(int n) {
        int[] store = new int[n + 1];
        store[0] = 0;
        store[1] = 1;
        for (int i = 2; i <= n; i++) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[n];
    }


    public static void main(String[] args) {
        int n = 40;
        System.out.println("Memozation Recursive :" + fibnoaciMemoziatinRecurive(n));
        System.out.println("Memozation Iterative(DP) :" + fibnoaciIterativeMemozation(n));
        System.out.println("Recurive :" + fibnoaciRecursive(n));
    }

}
