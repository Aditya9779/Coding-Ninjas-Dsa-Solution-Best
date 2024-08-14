public class TestCodingNinjas {

    public static void deleteAlternateNodes(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            LinkedListNode<Integer> temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
       head= reverse(head);
        int num;
        int carrier = 1;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> previous = null;
        while (current != null) {
            num = ((current.data) + carrier) % 10;
            carrier = ((current.data) + carrier) / 10;
            current.data=num;
            previous = current;
            current = current.next;
        }
        if (carrier == 1) {
            LinkedListNode<Integer> tail=new LinkedListNode<>(carrier); //this is why we change reverse the linked list
            previous.next=tail;
        }
return reverse(head);
    }


    public static void main(String[] args) {
int ans=41/10;
int ans1=41%10;
        System.out.println(ans);
        System.out.println(ans1);

    }

}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}