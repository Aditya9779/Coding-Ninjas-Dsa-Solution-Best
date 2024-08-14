import java.util.HashMap;

public class Striver {

    public static int[] frequencyCount(int arr[], int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // Count frequencies
        }
        int[] result = new int[N]; // Create an array to store frequencies
        for (int i = 0; i < N; i++) {
            result[i] = map.getOrDefault(i, 0); // Get frequency for each element (0 if not present)
        }

        return result;
    }
}
