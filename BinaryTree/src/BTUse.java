import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BTUse {
    public static BinaryTree<Integer> takeInput(Scanner s) {
        int rootData;
        System.out.println("Enter the root data");
        rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static void print(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        String isBePrint = root.data + " -> ";
        if (root.left != null) {
            isBePrint += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            isBePrint += "R:" + root.right.data;
        }
        System.out.println(isBePrint);
        print(root.left);
        print(root.right);

    }

    /*
    public static void printLevelWise(BinaryTree<Integer> root){
        if (root == null) {
         return;
        }
           Queue<BinaryTree<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);
        String is=root.data +" ";
        while (!pendingNodes.isEmpty()){
            BinaryTree<Integer> frontNodes=pendingNodes.poll();
            if (frontNodes.left != null) {
                is+="L:" + frontNodes.left.data;
                pendingNodes.add(frontNodes.left);
            }
            if (frontNodes.right != null) {
                is+="R:" + frontNodes.right.data;
                pendingNodes.add(frontNodes.right);
            }
        }
            System.out.println(is);
    }
    */
    public static void printTree(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTree<Integer> currentNode = pendingNodes.poll();
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


    public static BinaryTree<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTree<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter the Root data");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootData);
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTree<Integer> frontNode = pendingNodes.poll();
            System.out.println("Enter the left child data of " + frontNode.data);
            int leftChildData = s.nextInt();
            if (leftChildData != -1) {
                BinaryTree<Integer> leftChild = new BinaryTree<>(leftChildData);
                frontNode.left = leftChild;
                pendingNodes.add(leftChild);
            }
            System.out.println("Enter the right child data of " + frontNode.data);
            int rightChildData = s.nextInt();
            if (rightChildData != -1) {
                BinaryTree<Integer> rightChild = new BinaryTree<>(rightChildData);
                frontNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }


    public static void main(String[] args) {
       /* BinaryTree<Integer> root=new BinaryTree<>(1);
        BinaryTree<Integer> node1=new BinaryTree<>(2);
        BinaryTree<Integer> node2=new BinaryTree<>(3);
        root.left=node1;
        root.right=node2;
        System.out.println();*/
        //  Scanner s = new Scanner(System.in);
        // BinaryTree<Integer> root = takeInput(s);
        BinaryTree<Integer> root = takeInputLevelWise();
        print(root);

    }
}

