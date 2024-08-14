import java.util.LinkedList;

public class BST_bestQues {
    public static LinkedListNode<Integer> constructLinkedList(BST<Integer> root) {
        if (root == null) {
            return null;
        }
        LinkedListNode<Integer> temp = new LinkedListNode<>(); // Dummy head node
        constructLinkedListHelper(root, temp);
        return temp.next; //temp is null but we are adding the next temp
    }

    private static LinkedListNode<Integer> constructLinkedListHelper(BST<Integer> root, LinkedListNode<Integer> currNode) {
        if (root == null) {
            return currNode;
        }

        currNode = constructLinkedListHelper(root.left, currNode); // Traverse left subtree

        currNode.next = new LinkedListNode<>(root.data); // Add current node to the linked list
        currNode = currNode.next;

        return constructLinkedListHelper(root.right, currNode); // Traverse right subtree
    }

}

 class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode() {
    }
}

