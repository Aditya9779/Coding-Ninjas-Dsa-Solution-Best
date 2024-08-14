import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueClass {

    public static void reverseQueue(Queue<Integer> input) {
        if (input.size() <= 1) {
            return;
        }
        int front = input.poll();
        reverseQueue(input);
        input.add(front);

    }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        if (input.isEmpty() || k>input.size()) {
            return input;
        }
        if (k<=0) {
            return input;
        }
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <k ; i++) {
            stack.push(input.poll());
        }
        while (!stack.isEmpty()){
//            stack.pop(input.add())
            input.add(stack.pop());
        }
        for (int i = 0; i <input.size()-k ; i++) {
            input.add(input.poll());
        }

return input;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();   //Queue is Interface class
        // So We can't like new  Queue<Integer>(); we have to take ArrayList or LinkedList
        //   System.out.println(queue.peek());
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }

        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
        while (!queue.isEmpty()) {

            System.out.print(queue.poll() + " ");


        }


    }
}
