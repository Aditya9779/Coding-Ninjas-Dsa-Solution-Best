import java.util.HashMap;

public class Assignment {

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        if (n <= 1) {
            return n;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        long br = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);
        memo.put(n, Math.max(n, br));
        return memo.get(n);
    }

    /****************************************************************************************/
    public static int maxMoneyLooted(int[] houses) {
        int[] storage = new int[houses.length];
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        storage[0] = houses[0];
        storage[1] = Math.max(houses[1], houses[0]);
        for (int i = 2; i < houses.length; i++) {
            storage[i] = Math.max(storage[i - 1], storage[i - 2] + houses[i]);
        }
        return storage[houses.length - 1];
    }

    public static int maxMoneyLootedR(int[] houses) {
        return he(houses, houses.length);
    }

    private static int he(int[] houses, int n) {
        // Base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }

        // Include the current house and loot houses from the remaining n-2 houses
        int includeCurrent = houses[n - 1] + he(houses, n - 2);
        // Exclude the current house and loot houses from the remaining n-1 houses
        int excludeCurrent = he(houses, n - 1);

        // Return the maximum of both choices
        return Math.max(includeCurrent, excludeCurrent);

    }

    /****************************************************************************************/
    public static String findwinner(int n, int x, int y) {
        if (n == 1) {
            return "Beerus";
        }
        boolean beerusWins = false;
        if (n >= 1 && findwinner(n - 1, x, y).equals("Whis")) {
            beerusWins = true;
        }
        if (n >= x && findwinner(n - x, x, y).equals("Whis")) {
            beerusWins = true;
        }
        if (n >= y && findwinner(n - y, x, y).equals("Whis")) {
            beerusWins = true;
        }
        if (beerusWins) {
            return "Beerus";
        }
        return "Whis";
    }

    /*Memoziation Recursive*/
    public static String findWinnerMemoRecu(int n, int x, int y) {
        String[] storage = new String[n + 1];

        return helper(storage, n, x, y);
    }

    private static String helper(String[] storage, int n, int x, int y) {
        if (n == 1) {
            return "Beerus";
        }
        if (storage[n] != null) {
            return storage[n];
        }
        if (n >= 1 && helper(storage, n - 1, x, y).equals("Whis")) {
            storage[n] = "Beerus";
        } else if (n >= x && helper(storage, n - x, x, y).equals("Whis")) {
            storage[n] = "Beerus";
        } else if (n >= y && helper(storage, n - y, x, y).equals("Whis")) {
            storage[n] = "Beerus";
        } else {
            storage[n] = "Whis";
        }
        return storage[n];
    }
    /*Jis point mai khadha hai waha agar whis hai to pakka last mai haam hi aya ga
     * this is the trick of solving the question */

    /*Memozatin Iterative*/
    public static String findWinnerMemoIter(int n, int x, int y) {
        String[] storage = new String[n + 1];
        storage[0] = "Whis";
        storage[1] = "Beerus";
        for (int i = 2; i <= n; i++) {
            if (i >= 1 && storage[i - 1].equals("Whis")) {
                storage[i] = "Beerus";
            } else if (i >= x && storage[i - x].equals("Whis")) {
                storage[i] = "Beerus";
            } else if (i >= y && storage[i - y].equals("Whis")) {
                storage[i] = "Beerus";
            } else {
                storage[i] = "Whis";

            }
        }
        return storage[n];
    }


}






