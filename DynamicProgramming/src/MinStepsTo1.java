public class MinStepsTo1 {
    /*Recursive Approach Very High time complexity*/
    public static int countMinStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }
        int substract = Integer.MAX_VALUE;
        int divideby2 = Integer.MAX_VALUE;
        int divide3 = Integer.MAX_VALUE;
        substract = countMinStepsToOne(n - 1);
        if (n % 2 == 0) {
            divideby2 = countMinStepsToOne(n / 2);
        }
        if (n % 3 == 0) {
            divide3 = countMinStepsToOne(n / 3);
        }
        return 1 + Math.min(substract, Math.min(divide3, substract));
    }

    /*******************************************************/
    /*Memo Recursive*/ /* Time Is O(n)*/
    public static int countMinStepsToOneMemoRes(int n) {
        int[] storage = new int[n + 1];
        return helpcountMemoRes(storage, n);
    }

    private static int helpcountMemoRes(int[] storage, int n) {
        if (n == 1) {
            storage[n] = 0;
            return storage[n];
        }
        if (storage[n] != 0) {
            return storage[n];
        }
        int sub = helpcountMemoRes(storage, n - 1);
        int op2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            op2 = helpcountMemoRes(storage, n / 2);
        }
        int op3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            op3 = helpcountMemoRes(storage, n / 3);
        }
        storage[n] = 1 + Math.min(sub, Math.min(op2, op3));
        return storage[n];
    }

    /****************************************************************/
    /*Memo Iterative is known as DP*/ /* Time Is O(n)*/
    public static int countMinStepsToOneMemoIte(int n) {
        int[] storage = new int[n + 1];
        storage[1] = 0; //If we dont also so nothing happened
        for (int i = 2; i <= n; i++) {
            int min = storage[i - 1];
            if (i % 2 == 0) {
                min = Math.min(min, storage[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, storage[i / 3]);
            }
            storage[i] = min + 1;
        }
        return storage[n];
    }
}
