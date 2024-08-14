import java.util.Scanner;

public class isBST_QuesOnly extends BST_take_print {
    /* The code take as O(N^2)*/
    public static boolean isBST(BST<Integer> root) {
        if (root == null) {
            return true;
        }
        int lefMax = maximum(root.left);
        int rightMin = minium(root.right);

        if (lefMax >= root.data || rightMin <= root.data) {
            return false;
        }
        return isBST(root.right) && isBST(root.left);
    }

    private static int maximum(BST<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    private static int minium(BST<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minium(root.left), minium(root.right)));
    }

    /********************************************************************************************************************/

   //The Time is O(N)
    public static boolean isBSTBettterCalling(BST<Integer> root) {
        if (root == null) {
            return true;
        }
        pairIsBst<Integer, Boolean> ans = new pairIsBst<>();
        ans = IsBstBetter(root);
        return ans.isBst;
    }

    public static pairIsBst<Integer, Boolean> IsBstBetter(BST<Integer> root) {
        if (root == null) {
            pairIsBst<Integer, Boolean> ans = new pairIsBst<>();
            ans.minimum = Integer.MAX_VALUE;
            ans.maximum = Integer.MIN_VALUE;
            ans.isBst = true;
            return ans;
        }
        pairIsBst<Integer, Boolean> leftOutput = IsBstBetter(root.left);
        pairIsBst<Integer, Boolean> rightOutput = IsBstBetter(root.right);

        int minimum = Math.min(root.data, Math.min(leftOutput.minimum, rightOutput.minimum));//this for left
        int maximum = Math.max(root.data, Math.max(leftOutput.maximum, rightOutput.maximum));// this for right

        boolean isBst = (leftOutput.maximum >= root.data) && (rightOutput.minimum <= root.data);
        boolean isBal = isBst && leftOutput.isBst && rightOutput.isBst;
        pairIsBst<Integer, Boolean> ans = new pairIsBst<>(maximum, minimum, isBal);
        /* pairIsBst<Integer, Boolean> ans = new pairIsBst<>(minimum ,Maximum, isBal);
         THis is not because in the paramer (public pairIsBst(T minimum, T maximum, V isBst) )
         SO T minimum means maximum  vice versa */
        return ans;

    }

    /********************************************************************************************************************/
    //This code O(n)
    public static boolean isBSTShortBetter(BST<Integer> root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BST<Integer> root, int min, int max) {
        if (root == null) {
            return true;

        }
/*if (min > root.data) {
    return false;
}
if (max < root.data) {
    return false;
}*/
        //Compact
        if (root.data < min || root.data > max) {
            return false;
        }
        return helper(root.left, min, root.data - 1) && helper(root.right, root.data + 1, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST<Integer> root = takeInput();
        pairIsBst<Integer, Boolean> ans = IsBstBetter(root);
        System.out.println(ans.isBst);
    }
}

class pairIsBst<T, V> {
    T minimum;
    T maximum;
    V isBst;

    public pairIsBst(T minimum, T maximum, V isBst) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.isBst = isBst;
    }

    public pairIsBst() {

    }

}


