import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BtQues extends BTUse {
    public static int countNodes(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }

    public static int getSum(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        sum += getSum(root.left);
        sum += getSum(root.right);
        return sum;

    }

    public static boolean isNodePresent(BinaryTree<Integer> root, int x) {
        /*if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        boolean isPresent=isNodePresent(root.left,x);
        if (isPresent) {
            return true;
        }
      boolean  isPresent1=isNodePresent(root.right,x);
        if (isPresent1) {
            return true;
        }
return false;*/
        // Or

        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
    }


    public static void printLevelWise(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
     /*        Queue<BinaryTree<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < pendingNodes.size(); i++) {
                BinaryTree<Integer> frontNodes = pendingNodes.poll();
                str.append(frontNodes.data).append(":");
                if (frontNodes.left != null) {
                    str.append("L:").append(frontNodes.left.data).append(",");
                    pendingNodes.add(frontNodes.left);
                }
                if (frontNodes.right != null) {
                    str.append("R:").append(frontNodes.right.data);
                    pendingNodes.add(frontNodes.right);
                }
            }

            System.out.println(str);*/
        Queue<BinaryTree<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTree<Integer> currentNode = pendingNodes.poll();
            System.out.print(currentNode.data + ": ");
            if (currentNode.left != null) {
                System.out.print(currentNode.left.data + "L" + ",");
                pendingNodes.add(currentNode.left);
            }
            if (currentNode.right != null) {
                System.out.print(currentNode.right.data + "R" + ",");
                pendingNodes.add(currentNode.right);
            }
            System.out.println();
        }


    }

    public static int LargestNode(BinaryTree<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int max = root.data;
        max = Math.max(max, LargestNode(root.left));
        max = Math.max(max, LargestNode(root.right));
        return max;
    }

    public static int countNodesGreaterThanX(BinaryTree<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int cont = 0;
        if (root.data > x) {
            cont++;
        }
        cont += countNodesGreaterThanX(root.left, x);
        cont += countNodesGreaterThanX(root.right, x);
        return cont;
    }

    public static int height(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int heightleft = 0;
        int heightright = 0;
        heightleft += height(root.left);
        heightright += height(root.right);
        int ans = Math.max(heightleft, heightright);
        return ans + 1; // 1 for the root node

    }

    public static int leafCount(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.right == null && root.left == null) {
            ans++;
        }
        ans += leafCount(root.left);
        ans += leafCount(root.right);
        return ans;
    }

    public static void printAtDepthK(BinaryTree<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        printAtDepthK(root.left, k - 1);
        printAtDepthK(root.right, k - 1);
    }

    public static void changeToDepthTree(BinaryTree<Integer> root) {
        helper(root, 0);
    }

    private static void helper(BinaryTree<Integer> root, int depth) {
        if (root == null) {
            return;
        }
        root.data = depth;
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    public static void printNodesWithoutSibling(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        } else if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    //time complexity is O(N^2)
    public static int diameter(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int option1 = height(root.left) + height(root.right);   // For the when the simple tree
        int option2 = diameter(root.left); // If the funtion is childleft long (Example in copy)
        int option3 = diameter(root.right); // If the funtion is childright long (Example in copy)
        return Math.max(option1, Math.max(option2, option3));
    }

    public static int diameterBetterCallingfForIntReturn(BinaryTree<Integer> root) {
        pairclass<Integer, Integer> ans = new pairclass<>();
        ans = diameterBetter(root);
        return ans.diameter;
    }

    //time complexity is O(N)
    public static pairclass<Integer, Integer> diameterBetter(BinaryTree<Integer> root) {
        if (root == null) {
            pairclass<Integer, Integer> ans = new pairclass<>();
            ans.height = 0;
            ans.diameter = 0;
            return ans;
        }
        pairclass<Integer, Integer> leftOutput = diameterBetter(root.left);
        pairclass<Integer, Integer> rightOutput = diameterBetter(root.right);
        int finalHeight = 1 + Math.max(leftOutput.height, rightOutput.height); //this is seprate function for finding the height
        int option1 = leftOutput.height + rightOutput.height;
        int option2 = leftOutput.diameter;/*   these all option are for find the diameter */
        int option3 = rightOutput.diameter;
        int diameter = Math.max(option1, Math.max(option2, option3));
        pairclass<Integer, Integer> ans = new pairclass<>();
        ans.height = finalHeight;
        ans.diameter = diameter;
        return ans;
    }

    public static void mirrorBinaryTree(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        BinaryTree<Integer> tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
    }

    public static void inorder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
    }


    public static void insertDuplicateNode(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTree<Integer> temp = root.left;
        BinaryTree<Integer> leftcopy = new BinaryTree<>(root.data);
        root.left = leftcopy;
        leftcopy.left = temp;

    }

    /* I have to write the in my copy*/

    public static ArrayList<Integer> getNodePathsAtK(BinaryTree<Integer> root, int k) {
        if (root == null) {
            return null;
        }
        if (root.data == k) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        ArrayList<Integer> leftOutput = getNodePathsAtK(root.left, k);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = getNodePathsAtK(root.right, k);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        } else {
            return null;
        }
    }

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTree<Integer> root) {
        if (root == null) {
            ArrayList<Integer> arr = new ArrayList<>();
            return arr;
        }
        if (root.left == null && root.right == null) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        ArrayList<Integer> leftOutput = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightOutput = longestRootToLeafPath(root.right);

        leftOutput.add(root.data);
        rightOutput.add(root.data);

        return leftOutput.size() > rightOutput.size() ? leftOutput : rightOutput;
    }

    public static boolean isCousin(BinaryTree<Integer> root, int p, int q) {
        if (root == null) {
            return false;
        }

        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); //we dont write in for loop queue.size()
            boolean foundP = false;
            boolean foundQ = false;

            for (int i = 0; i < size; i++) {
                BinaryTree<Integer> currentNode = queue.poll();

                // Check if current node is p or q
                if (currentNode.data == p) {
                    foundP = true;
                }
                if (currentNode.data == q) {
                    foundQ = true;
                }

                // Check if the current node has left and right children
                if (currentNode.left != null && currentNode.right != null) {
                    // Check if the left and right children are p and q, or q and p respectively
                    if ((currentNode.left.data == p && currentNode.right.data == q) ||
                            (currentNode.left.data == q && currentNode.right.data == p)) {
                        return false; // If so, they are siblings, not cousins
                    }
                }

                // Enqueue the children of the current node if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Check if both p and q are found at this level
            if (foundP && foundQ) {
                return true; // If both are found at this level, they could be cousins
            } else if (foundP || foundQ) {
                return false; // If only one of p or q is found at this level, they can't be cousins
            }
        }

        return false; // If p and q are not found in the tree, return false
    }

    public static int getLCA(BinaryTree<Integer> root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.data == a || root.data == b) {
            return root.data;
        }

        int left = getLCA(root.left, a, b);
        int right = getLCA(root.right, a, b);
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1 && right != -1) {
            return right;
        } else if (left != -1 && right == -1) {
            return left;
        } else if (left != -1 && right != -1) {
            return root.data;
        }
        return -1;
    }

    public static void pairSum(BinaryTree<Integer> root, int sum) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> ans = helperPairSumToConvertTreeToArray(root);
        helperPairSum(ans, sum);
    }

    private static void helperPairSum(ArrayList<Integer> ans, int sum) {
        int start = 0;
        int end = ans.size() - 1;
        while (start <= end) {
            int val1 = ans.get(start);
            int val2 = ans.get(end);
            if (val1 + val2 > sum) {  //understand like val+val2 = 4,  sum=3 so we have to take val (value) to sum (so --)
                end--;
            } else if (val1 + val2 < sum) {
                start++;
            } else {
                System.out.print(val1 + " " + val2);
                start++;
                end--;
            }

        }
    }

    private static ArrayList<Integer> helperPairSumToConvertTreeToArray(BinaryTree<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> currentNode = new ArrayList<>();
        ArrayList<Integer> leftOutput = helperPairSumToConvertTreeToArray(root.left);
        if (!leftOutput.isEmpty()) {
            currentNode.addAll(leftOutput);
        }
        currentNode.add(root.data);
        ArrayList<Integer> rightOutput = helperPairSumToConvertTreeToArray(root.right);
        if (!rightOutput.isEmpty()) {
            currentNode.addAll(rightOutput);
        }
        return currentNode;
    }

    public static void nodesAtDistanceK(BinaryTree<Integer> root, int node, int k) {

    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = takeInputLevelWise();
        print(root);
        System.out.println("The diameter :" + diameterBetter(root).diameter);
        System.out.println("The Height :" + diameterBetter(root).height);
    }
}

class pairclass<T, V> {
    public T height;
    public V diameter;
}
