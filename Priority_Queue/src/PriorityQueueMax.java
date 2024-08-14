import java.util.ArrayList;

public class PriorityQueueMax {
    private ArrayList<Integer> heap;

    public PriorityQueueMax() {
        heap = new ArrayList<>();
    }

    public int size() throws EmptyException {
        if (heap.isEmpty()) {
            throw new EmptyException();
        }
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int getMax() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return heap.get(0);
    }

    //Comparator Work
    public void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(parentIndex) < heap.get(childIndex)) { //There is The Comparator Work
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public int remove() throws EmptyException {
        if (heap.isEmpty()) {
            throw new EmptyException();
        }
        int value = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex == index) {
                break;
            } else {
                int temp = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp);
                index = maxIndex;
                leftChildIndex = index * 2 + 1;
                rightChildIndex = index * 2 + 2;
            }
        }
        return value;
    }

}
