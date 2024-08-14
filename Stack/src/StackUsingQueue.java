//import java.util.LinkedList;
//import java.util.Queue;
//
//public class StackUsingQueue<T>
//{
//  private int valueSet;
//  private Queue<T> queue1=new LinkedList<T>();
//  private Queue<T> queue2=new LinkedList<T>();
//
//    public StackUsingQueue() {
//        valueSet=0;
//    }
//    public StackUsingQueue(T capacity) {
//        valueSet=0;
//    }
//
//    public int size(){
//        return queue1.size()+queue2.size();
//    }
///*
//public boolean isEmpty(){
//    if (!queue1.isEmpty() && !queue2.isEmpty()) {
//        return true;
//    }
//    if (!queue1.isEmpty()) {
//        return true;
//    }
//    if (!queue2.isEmpty()) {
//        return true;
//    }
//    return false;
//}
//
//*/
//public boolean isEmpty() {
//    return queue1.isEmpty() && queue2.isEmpty();
//}
//
//public T top(){
//        return  queue1.peek();
//}
//
//public void push(T elemrnt){
//    if (valueSet %2==0) {
//        queue1.add(elemrnt);
//    }
//else {
//    queue2.add(elemrnt);
//    }
//valueSet++;
//
//}
///*public int pop(){
//    valueSet=0;
//    int ans = 0;
//
//    while (!queue2.isEmpty()){
//        ans= (int) queue2.poll();
//        return ans;
//    }
//    while (!queue1.isEmpty() && valueSet%2==0) {
//            ans = (int) queue1.poll();
//    return ans;
//    }
//    return ans;
//}*/
///*public T pop() {
//    if (isEmpty()) {
//        throw new IllegalStateException("Stack is empty");
//    }
//
//    T poppedElement = null;
//    if (valueSet % 2 == 1) { // Check the value of valueSet for correct queue to pop from
//        while (!queue2.isEmpty() && queue2.size() > 1) {
//            queue1.add(queue2.poll());
//        }
//        poppedElement = queue2.poll();
//    } else {
//        while (!queue1.isEmpty() && queue1.size() > 1) {
//            queue2.add(queue1.poll());
//        }
//        poppedElement = queue1.poll();
//    }
//    valueSet--; // Update valueSet after popping an element
//    return poppedElement;
//}*/
//
//    /*public T pop() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Stack is empty");
//        }
//
//        if (!queue1.isEmpty()) {
//            while (queue1.size() > 1) {
//                queue2.add(queue1.poll());
//            }
//            return queue1.poll();
//        } else {
//            while (queue2.size() > 1) {
//                queue1.add(queue2.poll());
//            }
//            return queue2.poll();
//        }*/
//  /*  public T pop() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Stack is empty");
//        }
//
//        if (!queue1.isEmpty()) {
//            while (queue1.size() > 1) {
//                queue2.add(queue1.poll());
//            }
//            return queue1.poll();
//        } else {
//            while (queue2.size() > 1) {
//                queue1.add(queue2.poll());
//            }
//            return queue2.poll();
//        }
//    }*/
//  /*  public T pop() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Stack is empty");
//        }
//
//        T poppedElement = null;
//        if (!queue1.isEmpty()) {
//            while (queue1.size() > 1) {
//                queue2.add(queue1.poll());
//            }
//            poppedElement = queue1.poll();
//        } else {
//            while (queue2.size() > 1) {
//                queue1.add(queue2.poll());
//            }
//            poppedElement = queue2.poll();
//        }
//
//        return poppedElement;
//    }
//*/
//
//    public T pop() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Stack is empty");
//        }
//
//        T poppedElement = null;
//        if (valueSet % 2 == 1) { // Check the value of valueSet for correct queue to pop from
//            while (queue2.size() > 1) {
//                queue1.add(queue2.poll());
//            }
//            poppedElement = queue2.poll();
//        } else {
//            while (queue1.size() > 1) {
//                queue2.add(queue1.poll());
//            }
//            poppedElement = queue1.poll();
//        }
//        valueSet--; // Update valueSet after popping an element
//        return poppedElement;
//    }
//
//}
//
//
//
/*import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
public int size(){
        return queue1.size();
}
    public void push(int x) {
        // Add the new element to queue1
        queue1.add(x);
    }

    public int pop() {
        // Move all elements from queue1 to queue2, except the last one
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        // Get the last element from queue1 (which is the top of the stack)
        int poppedElement = queue1.poll();

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    public int top() {
        // Similar to pop, but don't remove the element from queue1
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.add(queue1.poll());

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


}
*/

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    //Constructor
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int size() {
        return queue1.size();
    }

    public void push(int element) {
        queue1.add(element);
    }

    public int pop() throws queueEmptyException {
        if (queue1.isEmpty()) {
            throw new queueEmptyException();
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int popElement = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;


        return popElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.add(queue1.poll()); // taking the last element also in q2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }


}
class queueEmptyException extends Exception{

}