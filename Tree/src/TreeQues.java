public class TreeQues extends UseofTreeNode {


    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = root.data > x ? 1 : 0;

        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x); // Recursively count nodes in children
        }
        return count;
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count = Math.max(count, getHeight(root.children.get(i)));
        }

        return count + 1;


    }

    public static void kdepth(TreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
        }
        if (k < 0) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            kdepth(root.children.get(i), k - 1);
        }


    }

    public static int countNodes(TreeNode<Integer> root) {
        /*This not not a base case this is a edge case*/
        if (root == null) {
            return 0;
        }

        int count = 1;
        /*We don't have to write the basae case because by mistakely it taken in the for loop*/
        for (int i = 0; i < root.children.size(); i++) {
            count += countNodes(root.children.get(i));
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        count += root.data;
        for (int i = 0; i < root.children.size(); i++) {
            count += sumOfAllNode(root.children.get(i));
        }


        return count;
    }

    public static int largestNode(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int maxNode = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            maxNode = Math.max(maxNode, largestNode(root.children.get(i)));
        }
        return maxNode;
    }

    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    public static void preOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrderTraversal(root.children.get(i));
        }

    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (x == root.data) {
            return true;
        }
        boolean isPresent = false;

        for (int i = 0; i < root.children.size(); i++) {
            isPresent = checkIfContainsX(root.children.get(i), x);
            if (isPresent) {
                return true;
            }
        }
        return isPresent;
    }

    public static void postOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrderTraversal(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }


    /*   public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
           if (root == null) {
               return root;
           }
           if (root.children.isEmpty()) {
               return root;
           }
           TreeNode<Integer> ans = null;
           for (int i = 0; i < root.children.size(); i++) {
               ans = maxSumNode(root.children.get(i));
           }

           return ans;
   Pending hai

       }*/
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.data.equals(root2.data)) {
            return false;
        }

        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }

        return true;
    }


    public static int countLeafNodes1(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() < 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;

    }


    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> nexNode = null;
        int minDifference = Integer.MAX_VALUE;
        if (root.data > n) {
            minDifference = root.data - n;
            nexNode = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> temp = findNextLargerNode(root.children.get(i), n);
            if (temp != null) {
                int differ = temp.data - n;
                if (differ < minDifference && differ >= 0) {
                    minDifference = differ;
                    nexNode = temp;
                }
            }
        }
        return nexNode;
    }

    private static TreeNode<Integer> largest = new TreeNode<>(Integer.MIN_VALUE);
    private static TreeNode<Integer> secondLargest = new TreeNode<>(Integer.MIN_VALUE);

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        if (root == null) {
            return root;
        }
        if (root.data > largest.data) {
            if (largest.data != Integer.MIN_VALUE) {
                secondLargest = largest;
            }
            largest = root;
        } else if (secondLargest.data < root.data && root.data < largest.data) {
            secondLargest = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            findSecondLargest(root.children.get(i));
        }
        return secondLargest;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        helperFunction(root, 0);
    }

    private static void helperFunction(TreeNode<Integer> root, int depth) {
        root.data = depth;
        for (int i = 0; i < root.children.size(); i++) {
            helperFunction(root.children.get(i), depth + 1);
        }

    }

/* Form this i have to write in the copy */

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.children.isEmpty()) {
            return null;
        }
        for (int i = root.children.size() - 1; i > 0; i--) {
            TreeNode<Integer> child = root.children.get(i);
            if (removeLeafNodes(child) == null) {
                root.children.remove(child);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        print(root);
        int count = largestNode(root);
        System.out.println(count);
    }
}

