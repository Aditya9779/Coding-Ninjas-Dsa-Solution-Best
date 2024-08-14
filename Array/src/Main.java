import java.util.Scanner;

public class Main {
    public static int[] TakeArray() {
        System.out.println("Enter the Size of array");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        return arr;
    }

    public static void PrintArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    static int MaximumNumber(int[] arr) {
        int min = Integer.MIN_VALUE;
        for (int j : arr) {
            min = Math.max(min, j);
        }
        return min;
    }

    public static int SumofArray(int[] arr) {
        int sum = 0;
        for (int s : arr
        ) {
            sum += s;
        }
        return sum;
    }

    public static void sortZeroesAndOnes(int[] arr) {
        int countZeros = 0;

        // Count the number of zeros in the array
        for (int i : arr) {
            if (i == 0) {
                countZeros++;
            }
        }

        // Set the initial elements to 0
        for (int i = 0; i < countZeros; i++) {
            arr[i] = 0;
        }

        // Set the remaining elements to 1
        for (int i = countZeros; i < arr.length; i++) {
            arr[i] = 1;
        }

        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void ArrangeNumber(int[] arr, int n) {
        int start = 0;
        int end = n - 1;
        int value = 1;
        while (start <= end) {
            if (value % 2 == 1) {
                arr[start++] = value++;
            } else {
                arr[end--] = value++;
            }
        }
        for (int x : arr
        ) {
            System.out.print(x + " ");
        }
    }

    public static int[][] twod_arrayTakeInput() {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int columns = s.nextInt();
        int[][] arr2d = new int[row][columns];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter the row " + i + " " + "Enter Column " + j);
                arr2d[i][j] = s.nextInt();
            }
        }
        return arr2d;
    }
public static void Print2d_array(int [][]arr){
    for (int[] ints : arr) {
        for (int j = 0; j < arr[0].length; j++) {
            System.out.print(ints[j] + " ");
        }
        System.out.println();
    }



}
    public static void SwapAlternative(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        for (int x : arr
        ) {
            System.out.print(x + " ");
        }
    }

    public static void PrintPair(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.println("[" + arr[i] + "]" + " [" + arr[j] + "]");
            }
            System.out.println();
        }


    }
public static int Maximum_in_column_2d(int [][]arr){
        int min=Integer.MIN_VALUE;

    for (int i = 0; i < arr[0].length; i++) {
       int sum=0;
        for (int j = 0; j < arr.length; j++) {
            sum+=arr[j][i];
            min=Math.max(min,sum);
        }
    }

        return min;

}

    public static void main(String[] args) {
//        int[] arr = TakeArray();
//        PrintArray(arr);
//        System.out.println();
//        int MaxiNum = MaximumNumber(arr);
//        System.out.println("The Maximum of the array is " + MaxiNum);
//        System.out.println();
//        int SumArray = SumoArray(arr);
//        System.out.println("The sum of array is " + SumArray);
//        ArrangeNumber(arr, arr.length);
//        System.out.println();
//        System.out.println(arr);
//        System.out.println();
//SwapAlternative(arr);
//        System.out.println();
//PrintPair(arr);
//        System.out.println();
//        sortZeroesAndOnes(arr);
//int [][]arr= twod_arrayTakeInput();
//Print2d_array(arr);
//int min=Maximum_in_column_2d(arr);
//        System.out.println(min);
//int a=1%2;
//        System.out.println(a);
    }
}