import java.util.ArrayList;

public class Main {
    public static void ArrayListUse(ArrayList<Integer> arr) {

        arr.add(12);
        arr.add(1);
        arr.add(14);
        arr.add(15);
        System.out.println(arr.size());
        for (int elem : arr
        ) {
            System.out.print(elem + " ");
        }
        System.out.println();
        arr.add(2, 3);
        arr.set(2, 67);
        System.out.println(arr.get(2));
        System.out.println(arr.remove(4));

    }

    public static void main(String[] args) {

    }
}