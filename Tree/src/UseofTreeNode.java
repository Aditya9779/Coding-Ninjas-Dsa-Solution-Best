import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UseofTreeNode {

    public static TreeNode<Integer> takeInput() {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the data");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter the data for the child");
        int childCount = s.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput();
            root.children.add(child);
        }
        return root;
    }

    /*  public static TreeNode<Integer> takeInputLevelWise() {
          Scanner s = new Scanner(System.in);
          System.out.println("Enter The data of the root");
          int rootdata = s.nextInt();
          TreeNode<Integer> root = new TreeNode<>(rootdata);
          Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
          pendingNodes.add(root);
          while (!pendingNodes.isEmpty()) {
              TreeNode<Integer> frontNode = pendingNodes.poll();
              System.out.println("Enter the data of the pending the nodes" + frontNode.data);
              int numChild = s.nextInt();
              for (int i = 0; i < numChild; i++) {
                  System.out.println("Enter" + (i + 1) + "th child" + frontNode.data);
                  int child = s.nextInt();
                  TreeNode<Integer> childNode = new TreeNode<>(child);
                  frontNode.children.add(childNode);
                  pendingNodes.add(childNode);
              }
          }

          return root;

      }*/
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Root data");
        int rootdata = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootdata);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> frontNodes = pendingNodes.poll();
            System.out.println("Enter Number Of the children " + frontNodes.data);
            int numchild = s.nextInt();
            for (int i = 0; i < numchild; i++) {
                System.out.println("Enter " + (i + 1) + " th child " + frontNodes.data);
                int childNodedata = s.nextInt();
                TreeNode<Integer> chilNode = new TreeNode<>(childNodedata);
                frontNodes.children.add(chilNode);
                pendingNodes.add(chilNode);
            }


        }

        return root;


    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ": ";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }

    }

    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {

            StringBuilder levelNodes = new StringBuilder();

            for (int i = 0; i < pendingNodes.size(); i++) {
                TreeNode<Integer> frontNodes = pendingNodes.poll();
                levelNodes.append(frontNodes.data).append(" : ");

                for (int j = 0; j < frontNodes.children.size(); j++) {
                    TreeNode<Integer> child = frontNodes.children.get(j);
                    levelNodes.append(child.data).append(" ,");

                    pendingNodes.add(child);
                }

            }
            System.out.println(levelNodes);

        }
    }
/*
public static void printLevelWise(TreeNode<Integer> root){
    if (root == null) {
        return;
    }
    Queue<TreeNode<Integer>> pendingNodes=new LinkedList<>();
    pendingNodes.add(root);
    while (!pendingNodes.isEmpty()){
        StringBuilder str=new StringBuilder();
        TreeNode<Integer> frontNodes=pendingNodes.poll();
        for (int i = 0; i <pendingNodes.size() ; i++) {
            str.append(frontNodes.data).append(" : ");
            for (int j = 0; j <frontNodes.children.size() ; j++) {
                str.append(frontNodes.children.get(i).data).append(" , ");
                pendingNodes.add(frontNodes.children.get(j));
            }
        }
        System.out.println(str);

    }
*/



    public static void main(String[] args) {
       /* TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node3.children.add(node4);
        System.out.println(root);*/
        // TreeNode<Integer> tree = takeInput();
        TreeNode<Integer> tree = takeInputLevelWise();
      //  printLevelWise(tree);

    }
}
