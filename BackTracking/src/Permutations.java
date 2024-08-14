import static java.util.Collections.swap;

public class Permutations {
    static void permutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
//           abcde ==for not including the c we have the substring i , i+1 str.length
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            permutations(newStr, ans + curChar);
        }

    }

    /*https://youtu.be/vKQ6oUH02gw*/
    static void permutationsSwaping(char[] str, int index) {
        if (index == str.length) {
            System.out.println(str);
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str, i, index);
            permutationsSwaping(str, index + 1);
            swap(str, i, index);

        }

    }
    private static void permutationsQue(String str){
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        permutationsSwaping(chars, 0);
    }


    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String[] args) {
       // permutations("abc", "");
       // permutationsSwaping(new char[]{'a', 'b', 'c'},0);
        permutationsQue("abc");
    }
}
