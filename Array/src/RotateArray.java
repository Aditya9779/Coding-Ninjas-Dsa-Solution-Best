//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class RotateArray {
    public RotateArray() {
    }

    private static void rev(int[] arr, int st, int en) {
        if (st <= en) {
            while(st <= en) {
                int temp = arr[en];
                arr[en] = arr[st];
                arr[st] = temp;
                ++st;
                --en;
            }

        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        int[] var2 = arr;
        int var3 = arr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int x = var2[var4];
            System.out.print("" + x + " ");
        }

    }
}
