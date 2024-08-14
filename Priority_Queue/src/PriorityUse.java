public class PriorityUse {
    public static void main(String[] args) {
        //Min Queue Operation
        /*
        PriorityQueueMin pq = new PriorityQueueMin();
        int[] arr = {2, 3, 1, 5, 4, 13, 10};
        for (int x : arr) {
            pq.insert(x);
        }
while (!pq.isEmpty()) {
    try {
        System.out.print(pq.remove()+ " ");
    } catch (EmptyException e) {
        throw new RuntimeException(e);
    }
}*/

        // Max Queue Operation
        PriorityQueueMax pq = new PriorityQueueMax();
        int[] arr = {2, 3, 1, 5, 4, 13, 10};
        for (int x : arr) {
            pq.insert(x);
        }
        while (!pq.isEmpty()) {
            try {
                System.out.print(pq.remove() + " ");
            } catch (EmptyException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
