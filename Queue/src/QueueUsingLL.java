
public class QueueUsingLL<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public T front() throws EmptyQueue {
        if (size == 0) {
            throw new EmptyQueue();
        }
        return front.data;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }
    public T dequeue() throws EmptyQueue {
        if (isEmpty()) {
            throw new EmptyQueue();
        }
        T temp=front.data;
        if (front==rear){
         front=null;
         rear=null;
         size--;
         return temp;
        }
        front=front.next;
size--;
return temp;

    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data=data;
    }
}
class EmptyQueue extends Exception{

}