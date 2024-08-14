public class EditDistance {
    /*Recursive Approach*/
    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return editDistance(s1.substring(1), s2.substring(1));
        } else {
            //Insert
            int op1 = editDistance(s1, s2.substring(1));
            //Delete
            int op2 = editDistance(s1.substring(1), s2);
            //Substibtute
            int op3 = editDistance(s1.substring(1), s2.substring(1));

            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }

    /*************************************************************************/
    /*Memozation Recusive*/
    public static int editDistanceMemoRec(String s1, String s2) {
        int[][] storage = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                storage[i][j] = -1;
            }
        }
        return editDistanceMemoRecHel(s1, s2, storage);
    }

    private static int editDistanceMemoRecHel(String s1, String s2, int[][] storage) {

        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        int row = s1.length();
        int col = s2.length();
        if (storage[row][col] != -1) {
            return storage[s1.length()][s2.length()];
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            storage[row][col] = editDistanceMemoRecHel(s1.substring(1), s2.substring(1), storage);
            return storage[row][col];
        } else {
            int op1 = editDistanceMemoRecHel(s1, s2.substring(1), storage);
            int op2 = editDistanceMemoRecHel(s1.substring(1), s2, storage);
            int op3 = editDistanceMemoRecHel(s1.substring(1), s2.substring(1), storage);
            storage[row][col] = 1 + Math.min(op1, Math.min(op2, op3));
            return storage[row][col];
        }
    }

    /*************************************************************************/
    /*Memozation Iterative Approach*/

    public static int editDistanceMemoIter(String s1, String s2) {
        int[][] storage = new int[s1.length() + 1][s2.length() + 1];
        int row = s1.length();
        int col = s2.length();
        for (int i = 0; i <= row; i++) {
            storage[i][0] = i; //Every time its returting the length of the string
        }
        for (int j = 0; j <= col; j++) {
            storage[0][j] = j; //Every time its send the length of the col if the string length is zero
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    storage[i][j] = storage[i - 1][j - 1];
                } else {
                    storage[i][j] = 1 + Math.min(storage[i][j - 1], Math.min(storage[i - 1][j], storage[i - 1][j - 1]));
                }
            }
        }
        return storage[s1.length()][s2.length()];
    }

}
