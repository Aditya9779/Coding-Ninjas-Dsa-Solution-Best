import java.util.List;

public class Hello {
    public static void revArray(int arr[]) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6};
        revArray(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
