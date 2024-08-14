import java.util.ArrayList;
import java.util.Stack;

public class StackPreImplementClass {


        public static boolean checkRedundantBrackets(String expression) {
            if (expression.length() == 0) {
                return false;
            }

            int countOperatorsBetweenBrackets = 0;
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch != ')') {
                    st.push(ch);
                } else {
                    while (st.peek() != '(') {
                        if (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/') {
                            countOperatorsBetweenBrackets++;
                        }
                        st.pop();
                    }
                    st.pop(); // Pop '('
                    if (countOperatorsBetweenBrackets == 0) {
                        return true; // Redundant bracket found
                    }
                    countOperatorsBetweenBrackets = 0;
                }
            }

            return false; // No redundant bracket found

    }

    public static int[] stockSpan(int[] price) {
        if (price.length == 0) {
            return price;
        }

        int ans[] = new int[price.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        ans[0] = 1;
        for (int i = 1; i < price.length; i++) {
            while (!stack.empty() && price[stack.peek()] < price[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

  /*  public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int pos = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            pos++;
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
                break;
            }
        }
        int nexpos=0;
        for (int i = 0; i < s.length(); i++) {

            st.push(s.charAt(i));
pos++;
        }
        int to=0;
        while (!st.empty()){
            to++;
            if (st.peek() ==')') {
                break;
            }
        }

int ans=to-pos-nexpos;
return  ans;

}*/

    public static int countBracketReversals(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                st.push(input.charAt(i));

            } else {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(input.charAt(i));
                }


            }


        }

        int count = 0;
while (!st.isEmpty()){
    char c1=st.pop();
    char c2=st.pop();
    if (c1!=c2){
        count+=2;
    }
    else{
        count++;
    }
}
return count;
    }


    public static boolean isBalanced(String expression) {
        if (expression.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '}' || stack.peek() == ')' || stack.peek() == ']') {
                stack.pop();
            }
            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;

    }


    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false; // No corresponding opening bracket
                }
                char c = st.pop();
                if ((ch == ')' && c != '(') ||
                        (ch == '}' && c != '{') ||
                        (ch == ']' && c != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        return st.isEmpty(); // Check if all brackets are closed
    }


    public static void main(String[] args) {
        Stack<Integer> sta = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            sta.push(i);
        }

        System.out.println(sta.peek());

        while (!sta.isEmpty()) {
            System.out.print(sta.pop() + " ");
        }
    }
//        String s = "(){}}{";
//        boolean ans = isValid(s);
//        System.out.println(ans);

}
