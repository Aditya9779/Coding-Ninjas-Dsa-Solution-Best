public class QueueUse {

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(3);
        for (int i = 1; i <= 5; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                throw new RuntimeException(e);
            }
        }
        while (!queue.isEmpty()) {
            try {
                System.out.print(queue.dequeue() + " ");
            } catch (QueueEmptyException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
