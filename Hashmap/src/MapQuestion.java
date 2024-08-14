import java.lang.reflect.Array;
import java.util.*;


public class MapQuestion {
    /* Time Complexity O(N^2)*/
    /* Always remeber not use the count only booleran things */
    public static ArrayList<Integer> removeDuplicates_Brute(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean duplicate = false;
        for (int i = 0; i < arr.length; i++) {
            duplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                list.add(arr[i]);
            }
        }
        return list;
        // We can Do like in this way also in hashset do not take the duplicate value
       /* HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }
        list.addAll(set);
        return list;*/
    }

    /* O(nLogn)*/
    /* imp how to skip the conditions we don't write the if statement only we have to add in the wihle loop*/
    public static ArrayList<Integer> removeDuplicates_Optimal(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++; // Skip duplicates (as long as current element is equal to next)
            }
        }
        return list;
    }

    /* O(N)  Time complexity */
    public static ArrayList<Integer> removeDuplicate_Hash(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            } else {
                ans.add(arr[i]);
                map.put(arr[i], true);
            }
        }
        return ans;
        //HashSet Approach
        /* HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
       */
        /* for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                ans.add(arr[i]);
            }
        }*/
        /*
        //OR better
        ans.addAll(set);   //Guranted Unique element is present in set .
        return ans;*/
    }

    /****************************************************************************************/
    /*time complexity O(N^2)*/     //In this question we have to return the number not count
    public static int maxFrequencyNumber_Brute(int[] arr) {
        int count = 1;
        int maxCount = 0;
        int ouput = arr[0];
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count >= maxCount) {
                ouput = arr[i];
                maxCount = count;
            }
        }
        return ouput;
    }

    /* time complexity O(Nlogn) */

    public static int maxFrequencyNumber_Optimal(int[] arr) {
        if (arr.length == 0) { // Handle empty array case
            return Integer.MIN_VALUE;
        }

        Arrays.sort(arr);
        int maxCount = 0;
        int element = arr[0]; // Initialize with the first element
        int count = 1;
        /*for (int i = 1; i < arr.length; i++) {
            int count = 1; // Count the current element itself
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            if (count >= maxCount) {  // Update element on tie for max frequency
                maxCount = count;
                element = arr[i];
            }
        }*/ //sort way
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
            if (count >= maxCount) {
                maxCount = count;
                element = arr[i];
                count = 0;
            }
        }

        return element;
    }

    /* Time Complexity O(N) */
    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
          /*      if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }*/
            //Or
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int maxFrequency = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > maxFrequency) {
                maxFrequency = map.get(arr[i]);
                ans = arr[i];
            }
        }
        return ans;
    }

    /***************************************************************************************************/
    /* TIme complexity O(N^2)*/
    public static int pairsum_Brute(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /* Time compleity is O(nlogn) */
    public static int pairSum_optimal(int[] arr) {
        Arrays.sort(arr); // Sort the array in O(n log n) time

        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                count++;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    /* Time complexity is O(n)*/
    public static int pairSum_better(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Count frequencies of each element
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check pairs
        for (int num : arr) {
            int complement = -num;
        /*
        Let's walk through the code with an example array `arr = {-4, -3, -2, -1, 0, 1, 2, 3, 4}`:

1. We start with an empty hashmap `freqMap` and a count of 0.
2. First iteration through the array to count frequencies:
   - For the element -4, it's not in the hashmap, so we add it with a frequency of 1.
   - For -3, it's not in the hashmap, so we add it with a frequency of 1.
   - For -2, it's not in the hashmap, so we add it with a frequency of 1.
   - For -1, it's not in the hashmap, so we add it with a frequency of 1.
   - For 0, it's not in the hashmap, so we add it with a frequency of 1.
   - For 1, it's not in the hashmap, so we add it with a frequency of 1.
   - For 2, it's not in the hashmap, so we add it with a frequency of 1.
   - For 3, it's not in the hashmap, so we add it with a frequency of 1.
   - For 4, it's not in the hashmap, so we add it with a frequency of 1.

   After this iteration, our hashmap `freqMap` looks like `{ -4 -> 1, -3 -> 1, -2 -> 1, -1 -> 1, 0 -> 1, 1 -> 1, 2 -> 1, 3 -> 1, 4 -> 1 }`.

3. Second iteration through the array to find pairs:
   - For -4, its complement is 4. We check if 4 exists in the hashmap. It does, so we increment the count by the frequency of 4 (1).
   - For -3, its complement is 3. We check if 3 exists in the hashmap. It does, so we increment the count by the frequency of 3 (1).
   - For -2, its complement is 2. We check if 2 exists in the hashmap. It does, so we increment the count by the frequency of 2 (1).
   - For -1, its complement is 1. We check if 1 exists in the hashmap. It does, so we increment the count by the frequency of 1 (1).
   - For 0, its complement is 0. We check if 0 exists in the hashmap. It does, so we increment the count by the frequency of 0 (1).
   - For 1, its complement is -1. We check if -1 exists in the hashmap. It does, so we increment the count by the frequency of -1 (1).
   - For 2, its complement is -2. We check if -2 exists in the hashmap. It does, so we increment the count by the frequency of -2 (1).
   - For 3, its complement is -3. We check if -3 exists in the hashmap. It does, so we increment the count by the frequency of -3 (1).
   - For 4, its complement is -4. We check if -4 exists in the hashmap. It does, so we increment the count by the frequency of -4 (1).

   After this iteration, the count is incremented by 9, because there are 9 pairs whose sum is zero.

4. Finally, we return half of the total count, which is 9 / 2 = 4.

So, the output is 4, indicating there are 4 pairs in the array that sum up to zero.*/
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }
            if (num == complement) { // for 0 case
                count--; // Exclude the case where num == -num
            }
        }
        // Each pair is counted twice, divide by 2
        return count / 2;
    }

    /***************************************************************************************************/
    /* TIme Complexity O(n^2)*/
    public static void printIntersection_Brute(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    System.out.print(arr2[i] + " ");
                    arr1[j] = Integer.MIN_VALUE;
                }
            }
        }
    }

    /*Time Complexity O(nlogn) */
    public static void printIntersection_Optimal(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

    /* Time Complexity O(N)*/
    public static void printIntersection(int[] arr1, int[] arr2) {
        // HashMap to store elements of arr1
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store elements of arr1 in the HashMap
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through arr2 to find the intersection
        for (int num : arr2) {
            // If element is present in the HashMap and its count is greater than 0
            if (map.containsKey(num) && map.get(num) > 0) {
                System.out.print(num + " ");
                // Decrement the count of the element in the HashMap
                map.put(num, map.get(num) - 1);
            }
        }
    }

    /********************************************************************************************************/
    /* Time Complexity O(n^2)*/
    /* This Do well but not the output in order*/
    public static String uniqueChar_Brute(String str) {
        StringBuilder sb = new StringBuilder();
        boolean duplicate = false;
        for (int i = 0; i < str.length(); i++) {
            duplicate = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                System.out.println(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /* The Order is correct */
    public static String uniqueChar_BruteOrder(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) == currentChar) {
                    sb.deleteCharAt(j); // Remove duplicate character
                    j--; // Adjust the loop counter after deletion
                }
            }
        }

        return sb.toString();
    }

    /* Time Complexity O(nlogn)*/
    public static String uniqueChar_Optimal(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /* Time Complexity O(n)*/
    public static String uniqueChar(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Boolean> h = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (h.containsKey(str.charAt(i))) {
                continue;
            }
            sb.append(str.charAt(i));
            h.put(str.charAt(i), true);
        }
        return sb.toString();
    }
    /************************************************************************************************************/

    /* Time Take O(n^2)*/


    /****************************************************************************************************/
    // Leet Code Same Question

    /*Time Complexity O(n^2)*/
    public int longestConsecutive_brute(int[] nums) {
        if (nums.length == 0) {
            return 0; // Handle edge case where array is empty
        }

        int maxCount = 0; // Initialize max count

        // Outer loop to pick starting point
        for (int i = 0; i < nums.length; i++) {
            int count = 1; // Start new sequence count
            int x = nums[i];

            // Inner loop to count consecutive elements
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == x + 1) { // If the next number is consecutive
                    count++;
                    x = nums[j]; // Move to the next number in the sequence
                    j = -1; // Restart inner loop from the beginning
                }
                // Reset is imp
            }

            // Update maxCount if the current sequence is longer
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }


    /* Time Complexity O(nlogn)*/
    public int longestConsecutive_optimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxCount = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
          if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    /* TIme Complexity is O(n) */
    public int longestConsecutive_best(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxCount = 0;
        for (int x : nums) {
            if (!set.contains(x - 1)) { //checks from the last . like after 2 we have 1 or not
                int count = 1;
                int cur = x+1;
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    /*****************************************************************************************************/
    /* Time Complexity O(n^2)*/
    public static int getPairsWithDifferenceK(int arr[], int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /* Time Complexity O(nlogn)*/
    public static int getPairsWithDifferenceK_optimal(int arr[], int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (Math.abs(arr[start] - arr[end]) == k) {
                count++;
                start++;
                end--;
            } else if (arr[end] - arr[start] > k) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }

    /* Time complexity O(n)*/
    public static int getPairsWithDifferenceK_best(int arr[], int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // arr=4,4,4,4 k=0---so the frequrncy is 4->4
            //This is the formula of nC2 for finding the pairs
            /*Let's analyze the function with the input array `arr = {4, 4, 4, 4}` and the target difference `k = 0`.

1. **Populate the HashMap with frequencies**:
   - We iterate through the array and count the frequency of each element.
   - After this step, our HashMap looks like: `{4->4}`.

2. **Check for pairs with a difference of 0** (special case when `k = 0`):
   - Since `k = 0`, we're looking for pairs of the same element.
   - In the HashMap, the element `4` has a frequency greater than 1.
   - We calculate the number of pairs that can be formed with the frequency of `4` using the combination formula `nC2`.
   - For `n = 4`, the number of pairs is `(4 * (4 - 1)) / 2 = 6`.

3. **Return the count**:
   - The count represents the number of pairs found with the given difference `k`.
   - In our example, the count is `6`, indicating there are `6` pairs of the same element `4` in the array `{4, 4, 4, 4}`.

So, the function correctly identifies and counts pairs of the same element when the target difference `k` is `0`.*/
        }
        if (k == 0) {
            for (int key : map.keySet()) {
                int frequency = map.get(key);
                if (frequency > 1) {
                    count += (frequency * (frequency - 1)) / 2;
                }
            }
        } else {
            for (int num : arr) {             // where k=3
                int complement = num + k;  // its is like that we have 5-2=k  so we have written like this 5=k+2 we have to find in the array
                if (map.containsKey(complement) && complement != num) {  //complement!=num for not cheking one number pairs like (1,1)
                    count++;
                /*In the line `if (map.containsKey(complement) && complement != num)`, the condition `complement != num` ensures that the same element is not considered as its own complement. Let's understand this with an example:

Suppose we have an array `arr = {1, 3, 5, 7, 9}` and we want to find pairs with a difference of `k = 2`.

- When we're at element `1`, the potential complement is `1 + 2 = 3`. If we didn't have the condition `complement != num`, we would count `(1, 1)` as a pair, which is not valid because it's the same element.
- Similarly, for other elements, we need to ensure that we're not counting the same element as its own complement. For example, when we're at `3`, its potential complement is `3 + 2 = 5`, but `3` itself is already in the array. So, the condition `complement != num` prevents counting `(3, 3)` as a pair.

By ensuring `complement != num`, we avoid counting the same element as a pair with itself, which is not what we want when finding pairs with a difference of `k`.*/
                }
            }
        }
        return count;
    }

    /*Same Code Simple Way*/
    public static int getPairsWithDifferenceK_singleHashSet(int arr[], int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashSet<Integer> seenElements = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            // Special case for k=0 (check for existing element and avoid duplicates)
            if (k == 0) {
                if (seenElements.contains(num)) {
                    seenElements.remove(num); // Remove to avoid counting same element twice
                    count++;
                }
            } else {
                // Check for complement and add current element
                int complement = num + k;
                if (seenElements.contains(complement)) {
                    count++;
                } else {
                    seenElements.add(num);
                }
            }
        }

        return count;
    }


    /*****************************************************************************************************/
    /*Time Complexity O(n^2)*/
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxCount = Math.max(maxCount, j - i + 1);
                }
            }
        }
        return maxCount;
    }

    /* Time Complexity O(n)*/
    public static int lengthOfLongestSubsetWithZeroSum_optimal(int arr[])  {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        /*In the code `map.put(0, -1);`, the key `0` and value `-1` are inserted into the `HashMap` at the beginning for a specific reason related to finding the longest subarray with zero sum. Here's why:

**The Logic Behind `map.put(0, -1)`**

1. **Zero Sum Subarray Starting from Index -1:** The value `-1` signifies that a zero sum subarray was encountered **before the current element** (`arr[i]`) in the array. Since indices in arrays typically start from 0, having `-1` for a zero sum indicates that an empty subarray (no elements) ending at the current index (`i`) contributes to the zero sum.

2. **Early Detection of Longest Subarray:** The purpose of the `HashMap` is to store the seen sums (`sum`) along with the index (`i`) where they were first encountered. By putting `0` (zero sum) with `-1`, you're essentially saying that you've encountered a zero sum even before processing any elements in the array.

**How it Works During Iteration**

As the code iterates through the array `arr`:

- If the current `sum` (considering elements till the current index `i`) is already present in the `HashMap`, it means a subarray ending at some previous index (`map.get(sum)`) has the same sum. This could potentially be a longer subarray than any seen before.
- The difference (`i - map.get(sum)`) calculates the length of this subarray since `i` is the current index and `map.get(sum)` represents the index where the same `sum` was encountered earlier.
- The `maxCount` is updated if this subarray length is greater than the current `maxCount`.

**Example**

Consider the array `arr = [15, -2, 2, -8, 1, 7, 10, 23]`.

1. Initially, `map = {0: -1}`.
2. After processing `15`, `sum` becomes `15` and it's not in the `HashMap` yet, so `map` becomes `{0: -1, 15: 0}`.
3. When processing `-2`, `sum` becomes `13`. Again, it's not in the `map`, so `map` becomes `{0: -1, 15: 0, 13: 1}`.
4. At `2` (index 2), `sum` becomes `15`. This `sum` was previously seen at index 0. So, `i - map.get(sum)` (2 - 0) is 2, which might be a contender for the longest subarray. We update `maxCount` if necessary.
5. The process continues, and the `map` helps identify subarrays with previously seen sums.

By including `map.put(0, -1)`, the code efficiently tracks zero-sum subarrays right from the beginning, improving the overall logic for finding the longest one.*/ //Explanation of this code 
        int maxCount = 0; //we have to store the key sa the sum and value as the index
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                maxCount = Math.max(maxCount, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

       /* int n = 11;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==n-1 || j==(n-1)/2 || i+j==(n-1)/2 &&j>=(n-1)/4) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
*/
    }
}
