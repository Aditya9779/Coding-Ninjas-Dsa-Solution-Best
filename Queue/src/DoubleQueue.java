/*
import java.util.ArrayList;

public class DoubleQueue {
    private ArrayList<Integer> data;
    private int front;
    private int rear;

    public DoubleQueue() {
        data = new ArrayList<>();
        front = -1;
        rear = -1;
    }

    public void insertFront(int element) {
        front = 0;
        rear++;
        data.add(front, element);
    }

    public void insertrear(int element) {
        rear++;
        data.add(rear, element);
    }

    public int deleteFront() {
        if (front == -1) {
            throw new RuntimeException();
        }
        int num = data.get(front);
        if (front == 0) {
            front = -1;
        }
        front++;
        return num;
    }


}
*/
import java.util.ArrayList;

public class DoubleQueue {
    private ArrayList<Integer> data;
    private int front;
    private int rear;

    public DoubleQueue() {
        data = new ArrayList<>();
        front = -1;
        rear = -1;
    }

    public void insertFront(int element){
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + data.size()) % data.size();
        }
        data.add(front, element);
    }

    public void insertRear(int element){
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % data.size();
        }
        data.add(rear, element);
    }

    public int deleteFront(){
        if (front == -1) {
            throw new RuntimeException("Deque is empty");
        }
        int num = data.remove(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + data.size()) % data.size();
        }
        return num;
    }

    // You can add similar method for deleteRear if needed
}

