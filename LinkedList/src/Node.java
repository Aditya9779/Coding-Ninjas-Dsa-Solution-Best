public class Node<T>{
      T data;
    Node<T> next; //For taking the reference, we have to take the class name

    public Node(T data) {
        this.data = data;
        next=null;
    }
    public void printNode(Node<T> node)
    {
        Node<T> head=node;
        while (head!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }

    }


}
