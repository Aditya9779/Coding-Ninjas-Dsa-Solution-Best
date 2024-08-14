import java.util.ArrayList;

public class PriorityQueueMin {
    private ArrayList<Integer> heap;

    public PriorityQueueMin() {
        heap = new ArrayList<>();
    }

    public int size() throws EmptyException {
        if (heap.size() == 0) {
            throw new EmptyException();
        }
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public void insert(int value) {
        heap.add(value);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
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

    public int getMin() throws EmptyException {
        if (heap.size() == 0) {
            throw new EmptyException();
        }
        return heap.get(0);
    }

    public int remove() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        int value = heap.get(0); // Taking the first value because it's the smallest value
        heap.set(0, heap.get(heap.size() - 1)); // Setting the last element at the first position
        heap.remove(heap.size() - 1);

        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heap.size()) {
            // Update minIndex to the smaller child if necessary
            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }
            //This rightindex conditiono is most imp because for left we are checking in the
            // while loop but their is not check for the right condition
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            // If minIndex hasn't changed, the heap property is satisfied
            if (minIndex == index) {
                break;
            }

            // Swap the current index with the smallest child
            int temp = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp);

            // Update indices to continue down the heap
            index = minIndex;
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
        }

        return value;
    }

}

class EmptyException extends Exception {

}