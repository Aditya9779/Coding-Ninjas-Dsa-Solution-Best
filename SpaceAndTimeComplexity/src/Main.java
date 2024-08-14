import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static int findUnique(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                ans = arr[i];
            }

        }
        return ans;
    }

    public static int findUniqueBetter(int[] arr) {
        int XOR = 0;
        for (int x :
                arr) {
            XOR ^= x;
        }
        return XOR;
    }

    public static int pairSum(int[] arr, int num) {
        int i = 0;
        int counter = 0;

        int start = 0;
        int len = arr.length;
        while (i < len && start < len) {
            start = i + 1;
            if (arr[i] + arr[start] == num) {
                counter++;
                start++;
            } else if (arr[i] + arr[start] != num) {
                start++;
            }
            i++;

        }
        return counter
                ;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() == 0) {
            return false;
        }
        boolean check = false;
        int start = 0;
        int end = s.length();
        char temp;
        while (start < end) {
            s = s.substring(start + 1) + s.charAt(start);
            if (s.equals(goal)) {
                check = true;
            }
            start++;
            end--;
        }
        return check;


    }

    public static int arrayRotateCheck(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                index = i;
            }
        }
        return index;
    }

    public static void Rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int output[] = new int[k];
        for (int i = 0; i < k - 1; i++) {
            output[i] = nums[i];
        }
        int index = 0;
        for (int i = 0; i < nums.length - 1 - k; i++) {
            nums[index++] = nums[i + k];
        }
        for (int i = 0; i < k; i++) {
            nums[index++] = output[i];
        }


    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        rotate(nums, 0, nums.length - 1);
        rotate(nums, k, nums.length - 1);
        rotate(nums, 0, k - 1);
    }

    private static void rotate(int[] arr, int st, int en) {
        int temp;
        while (st < en) {
            temp = arr[st];
            arr[st++] = arr[en];
            arr[en--] = temp;
        }
    }

    public static boolean checkSequence(String a, String b) {
        if (a.length() == 0) {
            return false;
        }
        if (a.length() == 0 && b.length()==0) {
            return true;
        }
        if (a.charAt(0) == b.charAt(0)) {
            return checkSequence(a.substring(1),b.substring(1));
        }
        return checkSequence(a.substring(1),b);
}
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3, 4};
        int ans = arrayRotateCheck(arr);
        System.out.println(ans);

    }
}