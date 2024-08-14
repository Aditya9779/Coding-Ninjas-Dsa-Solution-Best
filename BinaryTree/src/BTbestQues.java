public class BTbestQues extends BTUse {
    public static BinaryTree<Integer> removeLeaves(BinaryTree<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

  /*  public static int height(root) {
        if(root==null) {
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return 1+ Math.max(leftHeight, rightHeight);
    }

    //bad time complexity Worst case:- O(n2), avg case:- O(nlogn)
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if(root==null) {
            return true;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(leftHeight - rightHeight) >1){
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isLeftBalanced && isRightBalanced ;
    }

    //Better time complexity O(n).
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            int height= 0;
            boolean isBal= true;
            BalancedTreeReturn ans= new BalancedTreeReturn();
            ans.height= height;
            ans.isBalanced= isBal;
            return ans;
        }
        BalancedTreeReturn leftOutput= isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput= isBalancedBetter(root.right);
        boolean isBal= true;
        int height= 1+Math.max(leftOutput.height, rightOutput.height)

        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            isBal= false;
        }
        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal=false;
        }
        BalancedTreeReturn ans= new BalancedTreeReturn()
        ans.height= height;
        ans.isBalanced= isBal;
        return ans;
    }
*/

    //bad time complexity Worst case:- O(n2), avg case:- O(nlogn)

    public static boolean isBalanced(BinaryTree<Integer> root) {
        if (root == null) {
            return false;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
//        boolean isLeftBalanced = isBalanced(root.left);
//        boolean isRightBalanced = isBalanced(root.right);
//        return isLeftBalanced && isRightBalanced;
        //OR

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);


    }

    //Better time complexity O(n).

    public static BalancedTreeReturn isBalacedBetter(BinaryTree<Integer> root) {
        if (root == null) {
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = 0;
            ans.isbalanced = false;
            return ans;
        }
        BalancedTreeReturn leftoutput = new BalancedTreeReturn(root.left);
        BalancedTreeReturn rightoutput = new BalancedTreeReturn(root.right);
        boolean isbal = true;
        int height = 1 + Math.max(leftoutput.height, rightoutput.height); //This for only the fucntions not use in this ques
        if (Math.abs(leftoutput.height - rightoutput.height) > 1) {
            isbal = false;
        }
        if (!leftoutput.isbalanced || !rightoutput.isbalanced) {
            isbal = false;
        }
        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isbalanced = isbal;
        return ans;
    }

    public static boolean isBalancedBetterCalling(BinaryTree<Integer> root) {
        BalancedTreeReturn ans = isBalacedBetter(root);
        return ans.isbalanced;
    }


    public static BinaryTree<Integer> buildTreeInoPre(int[] inorder, int[] preorder) {
        return helperBuildTreeInoPre(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private static BinaryTree<Integer> helperBuildTreeInoPre(int[] inorder, int[] preorder, int inS, int inE, int prS, int prE) {
        if (prS > prE || inS > inE) {
            return null;
        }
        int rootdata = preorder[prS];
        BinaryTree<Integer> root = new BinaryTree<>(rootdata);

        int index = inS;
        for (int i = inS; i <= inE; i++) {
            if (preorder[prS] == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftInStart = inS;
        int leftInEnd = index - 1;
        int leftPreStart = prS + 1;
        int leftPreEnd = leftInEnd - leftInStart + leftPreStart;

        int rightInStart = index + 1;
        int rightInEnd = inE;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = prE;

        root.left = helperBuildTreeInoPre(inorder, preorder, leftInStart, leftInEnd, leftPreStart, leftPreEnd);
        root.right = helperBuildTreeInoPre(inorder, preorder, rightInStart, rightInEnd, rightPreStart, rightPreEnd);


        return root;
    }

    public static BinaryTree<Integer> buildTreeUsingInoPostOrder(int[] inorder, int[] postorder) {
        return buildTreeUsingInoPostOrderhelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static BinaryTree<Integer> buildTreeUsingInoPostOrderhelper(int[] inorder, int[] postorder, int inS, int inE, int poS, int poE) {
        if (poS > poE || inS > inE) {
            return null;
        }
        int rootdata = postorder[poE];
        BinaryTree<Integer> root = new BinaryTree<>(rootdata);
        int index = inS;
        for (int i = inS; i <= inE; i++) {
            if (rootdata == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftInStart = inS;
        int leftInEnd = index - 1;
        int leftPosStart = poS;
        int leftPosEnd = leftInEnd - inS + poS;

        int rightInStart = index + 1;
        int rightInEnd = inE;
        int rightPosStart = leftPosEnd + 1;
        int rightPosEnd = poE - 1;
        root.left = buildTreeUsingInoPostOrderhelper(inorder, postorder, leftInStart, leftInEnd, leftPosStart, leftPosEnd);
        root.right = buildTreeUsingInoPostOrderhelper(inorder, postorder, rightInStart, rightInEnd, rightPosStart, rightPosEnd);

        return root;
    }

    public static Pair<Integer, Integer> getMinAndMax(BinaryTree<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> ans = new Pair<>();
            ans.maximum = Integer.MIN_VALUE;
            ans.minimum = Integer.MIN_VALUE;
            return ans;
        }
        Pair<Integer, Integer> left = getMinAndMax(root.left);
        Pair<Integer, Integer> right = getMinAndMax(root.right);
        int maxNode = Math.max(root.data, Math.max(left.maximum, right.maximum)); // Consider current node's value
        int minNode = Math.min(root.data, Math.min(left.minimum, right.minimum)); // Consider current node's value
        Pair<Integer, Integer> ans = new Pair<>();
        ans.maximum = maxNode;
        ans.minimum = minNode;
        return ans;
    }

    public static void rootToLeafPathsSumToK(BinaryTree<Integer> root, int k) {
        String arr = "";
        rootToLeafPathsSumToKHelper(root, k, arr);
    }

    private static void rootToLeafPathsSumToKHelper(BinaryTree<Integer> root, int k, String arr) {
        if (root == null) {
            return;
        }
            arr += root.data + " ";
        if (k==root.data && root.left==null && root.right==null) {
            System.out.println(arr);
            return;
        }
        rootToLeafPathsSumToKHelper(root.left,k-root.data, arr);
        rootToLeafPathsSumToKHelper(root.right,k-root.data, arr);

    }

  /*  public static void rootToLeafPathsSumToK(BinaryTree<Integer> root, int k, String arr) {
        if (root == null) {
            return;
        }

        int rootData = root.data;

        arr = arr + rootData + " ";
        if (k == rootData && root.left == null && root.right == null) {
            System.out.println(arr);
            return;
        }
        rootToLeafPathsSumToK(root.left, k - rootData, arr);
        rootToLeafPathsSumToK(root.right, k - rootData, arr);
    }*/
    public static void main(String[] args) {
        /*int in[] = {4, 2, 5, 1, 3, 7};
        int po[] = {1, 2, 4, 5, 3, 7};
        BinaryTree<Integer> root = buildTreeInoPre(in, po);
        print(root);*/
        BinaryTree<Integer> root = takeInputLevelWise();
        System.out.println(isBalanced(root));
        System.out.println("Another");
        boolean ans = isBalancedBetterCalling(root);
        System.out.println(ans);

    }

    static class BalancedTreeReturn {
        boolean isbalanced;
        int height;

        public BalancedTreeReturn(BinaryTree<Integer> root) {
        }

        public BalancedTreeReturn() {

        }
    }
}

class Pair<T, V> {
    public T maximum;
    public V minimum;
}