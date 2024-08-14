public class RotateArray {

    private static void rev(int[] arr, int st, int en) {
        if (st > en) {
            return;
        }
        while (st <= en) {
            int temp = arr[en];
            arr[en] = arr[st];
            arr[st] = temp;
            st++;
            en--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

}
