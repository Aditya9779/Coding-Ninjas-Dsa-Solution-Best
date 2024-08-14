

public class HeapSort {

    private static void heapAddVirtual(int[] arr, int index) {
        int childIndex = index;
        int parentIndex = (index - 1) / 2;
        while (childIndex > 0) {
            if (arr[childIndex] > arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }
//For sorting we use the max heap because we store in array itself only
    private static int heapRemoveVirtual(int[] arr, int heapSize) {
        int value = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heapSize) {
            if (arr[leftChildIndex] > arr[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex != index) {
                int temp = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp;
                index = maxIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            } else {
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            heapAddVirtual(arr, i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = heapRemoveVirtual(arr, arr.length - i);
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

