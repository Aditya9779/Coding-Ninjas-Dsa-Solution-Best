import java.util.ArrayList;
import java.util.List;

public class leetcode {

    public int search(int[] nums, int target) {
        if (nums.length <= 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }

        }

        int index = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
                break;
            }
        }
        int ans = binary(nums, target, index, nums.length - 1);
        int ans2 = binary(nums, target, 0, index - 1);

        if (ans != -1) {
            return ans;
        }

        if (ans2 != -1) {
            return ans2;
        }

        return -1;


    }

    //    public String longestPalindrome(String s) {
//        if (s.length() == 0) {
//            return "";
//        }
//        String ans="";
//        ans= String.valueOf(s.charAt(0)) ;
//        String output=ch(s,ans);
//
//
//
//
//
//
//
//    }
    private static String ch(String str, String ans) {
        if (ans.charAt(0) == ans.charAt(ans.length() - 1)) {
            return ans;
        } else {
            return "";
        }

    }


    public void moveZeroes(int[] nums) {
        // Count the number of zeroes in the array
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }

        // Copy non-zero elements to the beginning of the array
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        // Fill the remaining positions with zeroes
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*  public static List< Integer > sortedArray(int []a, int []b) {
        if (a.length == 0) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < b.length; i++) {
                ans.add(b[i]);
            }
            return ans;
        }
        if (b.length == 0) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                ans.add(a[i]);
            }
            return ans;
        }

        List<Integer> ans = new ArrayList<>();

        return ans;
    }*/
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s.toLowerCase();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' || s.charAt(i) != ',' || s.charAt(i) != ':') {
                ans.append(s.charAt(i));
            }
        }
        if (ans.charAt(0) != ans.charAt(ans.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1));

    }

    private static int binary(int[] arr, int targer, int st, int en) {
        while (st <= en) {
            int mid = (st + en) / 2;
            if (arr[mid] == targer) {
                return mid;
            }
            if (arr[mid] > targer) {
                en = mid - 1;
            } else {
                st = mid + 1;
            }

        }

        return -1;


    }

/*    public int threeSumClosest(int[] nums, int target) {
if(nums.length==0){
    return -1;
}
int close=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if (Math.abs(nums[i] +nums[j]+ nums[k])<target) {
                        close=Math.max(close,Math.abs(nums[i] +nums[j]+ nums[k]));
                    }
                }
            }
        }




return close;


    }*/
/*
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int closestSum = 0;
        boolean firstIteration = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - target);
                    if (firstIteration || diff < Math.abs(closestSum - target)) {
                        closestSum = sum;
                        firstIteration = false;
                    }
                }
            }
        }
        return closestSum;
    }
}
*/

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;

    }




    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int []ans=new int[nums.length];
        int product;
        for (int i = 0; i < nums.length; i++) {
            product=1;
            for (int j = 0; j <nums.length ; j++) {
                if (i!=j ){
                    if (nums[j]==0) {
                        product=0;
                        break;
                    }
                    product*=nums[j];
                }
            }
            ans[i]=product;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4, 5, 2, 3, -1, -1};
        int tar = 1;
        int ans = threeSumClosest(arr, tar);
        System.out.println(ans);
    }
}
