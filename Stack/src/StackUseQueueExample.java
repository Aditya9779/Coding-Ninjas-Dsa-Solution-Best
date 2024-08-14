public class StackUseQueueExample {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        for (int i = 0; i <= 15; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        while (!stack.isEmpty()){
            try {
                System.out.print(stack.pop()+" ");
            } catch (queueEmptyException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
