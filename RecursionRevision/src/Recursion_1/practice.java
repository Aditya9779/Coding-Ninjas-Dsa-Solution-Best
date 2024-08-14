package Recursion_1;

import java.util.Scanner;

public class practice {


    public static int factorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }

        int smallAns = factorial(number - 1);
        return number * smallAns;


    }


    public static int sumOfNatural(int num) {
        if (num == 1) {
            return num;
        }
        int sum;
        sum = sumOfNatural(num - 1);
        return num + sum;


    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);


    }

    public static boolean isPalnidrome(String str) {

        int start = 0;
        int end = str.length() - 1;
        boolean isTrue = true;
//        while (start <= end) {
//            if (str.charAt(start) != str.charAt(end)) {
//                isTrue = false;
//                return isTrue;
//            }
//            start++;
//            end--;
//        }
        for (int i = start; i <= end; i++) {
            if (str.charAt(start) != str.charAt(end)) {
                isTrue = false;
                return isTrue;
            }
        }

        return isTrue;


    }

    public static String removeX(String s) {
        if (s.isEmpty()) {
            return "";

        }
        if (s.charAt(0) == 'x') {
            return removeX(s.substring(1));
        }


        return "";
    }

    public practice() {
        super();
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            mergeSort(arr, l, mid, r);


        }

    }

    private static void mergeSort(int[] arr, int start, int mid, int end) {
        int[] ans = new int[start + end];
        int i = start;
        int j = mid;
        int index = 0;
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                ans[index] = arr[i];
                index++;
                i++;
            } else {
                ans[index] = arr[j];
                index++;
                j++;
            }


        }

        while(i<mid){
            ans[index]=arr[i];
            index++;
            i+=1;
        }


        while(j<end){
            ans[index]=arr[j];
            index++;
            j+=1;
        }

        for (int k = 0; k < ans.length; k++) {
            arr[start+k]=ans[k]; //For changing the value in same array arr (Given)
        }





    }





    public static void main(String[] args) {
//        int a = 3;
////       int ans = factorial(a);
////        System.out.println(ans);
////
//        System.out.println(fibonacci(a));
//StringBuilder sb= new StringBuilder("abba");
        Scanner s = new Scanner(System.in);

        // String sb = s.nextLine();
        String sb = "acwhats";
//        boolean bol = isPalnidrome(sb);
//        System.out.println(bol);
        System.out.println(sb.substring(2));
    }
}

