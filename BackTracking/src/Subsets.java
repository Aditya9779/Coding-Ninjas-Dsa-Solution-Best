public class Subsets {
    static void subsets(String str, int index, String current) {
        if (index == str.length()) {
            print(current);
            return;
        }

        subsets(str, index + 1, current + str.charAt(index));
        subsets(str, index + 1, current);


    }

    private static void print(String current) {
        if (current.length() == 0) {
            System.out.println("Null");
        } else {
            System.out.print(current + " ");
        }
    }

    public static void main(String[] args) {
        subsets("abc", 0, "");
    }

}
