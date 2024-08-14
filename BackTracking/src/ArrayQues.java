public class ArrayQues {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArrayBackTracking(int[] arr, int index, int val) {
        if (index >= arr.length) {
            printArray(arr);
            return;
        }
        arr[index] = val;
        changeArrayBackTracking(arr, index + 1, val + 1); //First its execute the next line come
        arr[index] = arr[index] - 2;  //BackTrack Change the value after recursive call
       /* Never backtrack comes first than the recursive .
        It means every time we change after the recursive call then this step is known as backtrack*/
    }

    public static void main(String[] args) {
        int [] arr = new int [10];
        changeArrayBackTracking(arr, 0, 1);
        printArray(arr);

    }
}
