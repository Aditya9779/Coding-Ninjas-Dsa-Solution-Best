public class QueueUseLL {
    public static void main(String[] args) {
       QueueUsingLL<Integer> queue=new QueueUsingLL<>();
        for (int i = 1; i <=5 ; i++) {
           queue.enqueue(i);
        }

        System.out.println(queue.front.data);
        System.out.println(queue.size);
        System.out.println(queue.isEmpty());
        System.out.println();
        while (!queue.isEmpty()){
            try {
                System.out.print(queue.dequeue()+" ");
            } catch (EmptyQueue e) {
                throw new RuntimeException(e);
            }

        }
    }
}
