import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void PrintString(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }

    }

    public static int countWords(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        return count + 1;
    }

    public static String compressTheString(String s) {
        // Declare an integer array freq to store the frequency of each character
        int[] freq = new int[256]; // Assuming ASCII characters

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c]++;
        }

        String compressed = "";

        // Create the compressed string
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                compressed += (char) i + Integer.toString(freq[i]);
            } else if (freq[i] == 1) {
                compressed += (char) i;
            }
        }

        return compressed;

    }

    static void Prefix(String s) {
        for (int i = 0; i < s.length(); i++) {

            System.out.println(s.substring(0, i + 1));

        }


    }

    public static void StingReverse(String str) {
        if (str.length() == 0) {
            return;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push((str.substring(i, i + 1)));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

  /*  public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == 0) {
return str1;
        }
        if (str2.length() == 0) {
            return str2;
        }


        for (int i = 0; i <str2.length() ; i++) {
            if (str1.isstr2==0) {

            }
        }
    }*/

    public int lengthOfLongestSubstring(String s) {
       /* HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
            *//*In the line `max = Math.max(max, i-start+1);`, we are updating the `max` variable to store the length of the longest substring without repeating characters encountered so far. Let's break down the expression `i - start + 1` to understand why we add 1:

- `i`: This variable represents the current index in the string `s`.
- `start`: This variable represents the starting index of the current substring without repeating characters.
- `i - start`: This calculates the length of the current substring without repeating characters. If `i` is the current index and `start` is the starting index of the current substring, `i - start` gives the number of characters from `start` to `i` inclusive.
- `i - start + 1`: We add 1 to include the character at index `i` in the count. This is because `i - start` calculates the number of characters from `start` to `i-1`, so adding 1 ensures that we count the character at index `i` as well, making it inclusive.

Therefore, `i - start + 1` gives us the length of the current substring without repeating characters, including the character at index `i`, which is essential for accurately determining the length of the substring.*//*
        }
        return max;*/
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left =0;
        int right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int gap = countWords(s);
//        System.out.println(gap);
//        PrintString(s);
        // Prefix(s);
        String s = "abcd";
        //  String ans= compressTheString(s);
        //  System.out.print(ans);
        StingReverse(s);


    }
}





