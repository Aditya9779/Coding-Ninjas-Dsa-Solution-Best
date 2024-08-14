import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_take_print {
    public static BST<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the root data");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BST<Integer> root = new BST<>(rootData);
        Queue<BST<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BST<Integer> frontNodes = pendingNodes.poll();
            System.out.println("Enter the left child data of " + frontNodes.data);
            int leftChildData = s.nextInt();
            if (leftChildData != -1) {
                BST<Integer> leftChild = new BST<>(leftChildData);
                frontNodes.left = leftChild;
                pendingNodes.add(leftChild);
            }
            System.out.println("Enter the right child data of " + frontNodes.data);
            int rightChildData = s.nextInt();
            if (rightChildData != -1) {
                BST<Integer> rightChild = new BST<>(rightChildData);
                frontNodes.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }

    public static void printTree(BST<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BST<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BST<Integer> currentNode = pendingNodes.poll();
            System.out.print(currentNode.data + ": ");
            if (currentNode.left != null) {
                System.out.print( currentNode.left.data+"L"  + ",");
                pendingNodes.add(currentNode.left);
            }
            if (currentNode.right != null) {
                System.out.print( currentNode.right.data+"R"  + ",");
                pendingNodes.add(currentNode.right);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

    }


}
