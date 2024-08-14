import java.util.Comparator;
import java.util.PriorityQueue;

public class ImpComparator {
    public static void main(String[] args) {
        MinComparator min = new MinComparator();//This compertor Class We use to set the comparator
        MaxComparator max = new MaxComparator();//This compertor Class We use to set the comparator
        //in --Open File PriorityQueueMax Or PriorityQueueMin
        PriorityQueue<Integer> pqmin = new PriorityQueue<Integer>(min);
        PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(max);
        int[] arr = {1, 22, 3, 4, 5, 6, 7, 8, 9};
        for (int x : arr) {
            pqmin.add(x);
        }
        for (int x : arr) {
            pqmax.add(x);
        }
        while (!pqmin.isEmpty()) {
            System.out.print(pqmin.poll() + " ");
        }
        System.out.println();
        while (!pqmax.isEmpty()) {
            System.out.print(pqmax.poll() + " ");
        }

    }
}
class MinComparator implements Comparator<Integer> {


    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        }
        return 0;
    }
}

class MaxComparator implements Comparator<Integer> {


    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        }
        return 0;
    }
}