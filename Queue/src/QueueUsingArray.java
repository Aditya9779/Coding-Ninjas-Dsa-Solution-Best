public class QueueUsingArray {
    private int[] data;
    private int front; //index at which front element is stored
    private int rear; // rear is which at the element position is their
    private int size; // for the capacity

    public QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    private void resize() {
        int[] temp = data;
        data = new int[temp.length + 1];
       // System.arraycopy(temp, 0, data, 0, temp.length);
   int index=0;
        for (int i = front; i < temp.length ; i++) {
            data[index++]=temp[i];
        }
        for (int i = 0; i <front-1 ; i++) {
            data[index++]=temp[i];
        }
   front=0;
        rear=size-1;
    }

    public void enqueue(int element) throws QueueFullException {
        if (size == data.length) {
//   throw new QueueFullException();
////            // OR
             resize(); //to make the size extra large
        }

        if (size == 0) {
            front=0;
        }
        size++;
        rear++;
        if (rear == data.length) {   //This the problem
            //comes in when we add some element and dequeue
            // some element like we add 3 element and dequeue 2 element,
            // but the element is at the rear position, so we have to set the rear 0;
            rear=0;
        }
        data[rear] = element;


    }
public int dequeue() throws QueueEmptyException {
    if (size == 0) {
        throw new QueueEmptyException();
    }

        int temp=data[front];
    front++;
    size--;
    if (size == 0) {
        front=-1;
        rear=-1;
    }
    if (front == data.length) {
        front=0;
    }
    return temp;
}

}

class QueueEmptyException extends Exception {

}

class QueueFullException extends Exception {

}