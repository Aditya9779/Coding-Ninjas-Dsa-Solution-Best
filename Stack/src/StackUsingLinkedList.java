public class StackUsingLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;
    int pos = -1;

    //    public StackUsingLinkedList(int capacity) {
//    }
//No need to write capacity its is Linked List Not and Array
    public StackUsingLinkedList() {
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null && tail == null) {
            pos++;
            head = newNode;
            tail = newNode;
        }
//       else {
//           pos++;
//            tail.next=newNode;  // This Method take the Right way of attaching the node But in pop if we do like that then it take
        //O(N) Time complexity .  1  ->  2 ->  3->  null
//            tail=newNode;
//        }
        else {
            newNode.next = head;        //  This is a reverse addition of Linked List like null->3-> 2-> 1
            head = newNode;               // For getting the pop in O(1)
            pos++;
        }

    }

    //    public int  pop(){
//        if (head==null ){
//           // error
//        }
//        int temp =tail.data;
//        tail.next=null;
//        pos--;
//        return temp;
//
//    }
//public int pop() {
//    if (isEmpty()) {
//        throw new IllegalStateException("Stack is empty");
//    }
//    int temp = tail.data;
//    if (head == tail) { // Only one element in the stack
//        head = null;
//        tail = null;
//    } else {
//        Node<Integer> current = head;
//        while (current.next != tail) {
//            current = current.next;
//        }
//        current.next = null;
//        tail = current;
//    }
//    pos--;
//    return temp;
//}
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T ans = head.data;
        if (head == tail) { // Only one element in the stack
            head = null;
        }
        if (head != null) {
            head = head.next;
            pos--;
        }
        return ans;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {

        return pos + 1;
    }

    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return head.data;
    }


}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

