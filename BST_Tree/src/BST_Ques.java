import java.util.ArrayList;
import java.util.Scanner;

public class BST_Ques extends BST_take_print {

    public static boolean searchInBST(BST<Integer> root, int k) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        } else if (root.data > k) {
            return searchInBST(root.left, k);
        } else {
            return searchInBST(root.right, k);
        }
    }

    public static void elementsInRangeK1K2(BST<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data > k1) {
            elementsInRangeK1K2(root.left, k1, k2);
        }
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
        if (root.data < k2) {
            elementsInRangeK1K2(root.right, k1, k2);
        }
    }

    public static BST<Integer> SortedArrayToBST(int[] arr, int n) {
        return helper(arr, 0, arr.length - 1);
    }

    private static BST<Integer> helper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;   //ALlways remember start +++ song like (end-start)/2
        int rootData = arr[mid];
        BST<Integer> root = new BST<>(rootData);
        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);
        return root;
    }

    public static ArrayList<Integer> getNodePathAtk(BST<Integer> root, int k) {
        if (root == null) {
            return null;
        }
        if (root.data == k) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        if (root.data > k) {
            ArrayList<Integer> leftOutput = getNodePathAtk(root.left, k);
            if (leftOutput != null) {
                leftOutput.add(root.data);
                return leftOutput;
            }
        } else if (root.data < k) {
            ArrayList<Integer> rightOutput = getNodePathAtk(root.right, k);
            if (rightOutput != null) {
                rightOutput.add(root.data);
                return rightOutput;
            }
        }
        return null;
    }

    /* I have to write in copy*/

    public static void insertDuplicateNode(BST<Integer> root) {
        if (root == null) {
            return;
        }
        // Process the current node
        BST<Integer> newNode = new BST<>(root.data);
        BST<Integer> temp = root.left;
        root.left = newNode;
        newNode.left = temp;

        // Recursively insert duplicate nodes for left and right subtrees
        insertDuplicateNode(newNode.left); //imp think that
        insertDuplicateNode(root.right);
    }

    public static void replaceWithLargerNodesSum(BST<Integer> root) {
        if (root == null) {
            return;
        }
        helperReplaceWithLargerNodeSum(root, 0);
    }

    private static int helperReplaceWithLargerNodeSum(BST<Integer> root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = helperReplaceWithLargerNodeSum(root.right, sum);
        sum += root.data;
        root.data = sum;
        sum = helperReplaceWithLargerNodeSum(root.left, sum);
        return sum;

    }

    /* O(N^2)*/
    public static int largestBSTSubtree(BST<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (isBSTCheckOrNot(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return height(root);
        } else {
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }

    private static int height(BST<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean isBSTCheckOrNot(BST<Integer> root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data >= maxValue || root.data <= minValue) {
            return false;
        }

        return isBSTCheckOrNot(root.left, minValue, root.data - 1) && isBSTCheckOrNot(root.right, root.data + 1, maxValue);
    }

    /* this time complexity takes O(N) but its run only 50percent test case*/
    private static LargestClass largestHelper(BST<Integer> root) {
        if (root == null) {
            return new LargestClass(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }

        LargestClass left = largestHelper(root.left);
        LargestClass right = largestHelper(root.right);
        if (left.isBalanced && right.isBalanced && root.data > left.maximum && root.data < right.minimum) {
            int finalMaximum = Math.max(root.data, right.maximum);
            int finalMinimum = Math.min(root.data, left.minimum);
            int finalHeight = Math.max(left.heightOfSubBstTree, right.heightOfSubBstTree) + 1;
            return new LargestClass(finalMaximum, finalMinimum, finalHeight, true);
        } else {
            // If the current subtree is not a valid BST, return the larger valid subtree
            return left.heightOfSubBstTree > right.heightOfSubBstTree ? left : right;
        }
    }

    /* For calling the functions*/
    private static int largestBSTSubtreeBetter(BST<Integer> root) {
        if (root == null) {
            return 0;
        }
        LargestClass ans = largestHelper(root);
        return ans.heightOfSubBstTree;
    }

    public static int getLCA(BST<Integer> root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.data == a || root.data == b) {
            return root.data;
        }
        if ((root.data > a && root.data < b) || (root.data < a && root.data > b)) {
            // If one value is greater than root and one is smaller, then root is the LCA
            return root.data;
        }
        if (root.data > a && root.data > b) {
            return getLCA(root.left, a, b);
        } else if (root.data < a && root.data < b) {
            return getLCA(root.right, a, b);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST<Integer> root = takeInput();
        printTree(root);

    }
}

class LargestClass {
    int maximum;
    int minimum;
    int heightOfSubBstTree;
    boolean isBalanced;

    public LargestClass() {
    }

    public LargestClass(int maximum, int minimum, int heightOfSubBstTree, boolean isBalanced) {
        this.maximum = maximum;
        this.minimum = minimum;
        this.heightOfSubBstTree = heightOfSubBstTree;
        this.isBalanced = isBalanced;
    }
}
