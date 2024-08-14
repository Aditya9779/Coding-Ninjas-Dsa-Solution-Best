import java.util.*;

public class PriorityQuestion {
    public static void kSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            pq.add(arr[i]);
            i++;
        }
        while (i < arr.length) {
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
            i++;
        }
        for (int j = arr.length - k; j < arr.length; j++) {
            arr[j] = pq.remove();
        }
    }

    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k == 0) {
            return list;
        }
        int i = 0;
        while (i < k) {
            pq.add(input[i]);
            i++;
        }
        while (i < input.length) {
            if (pq.peek() < input[i]) {
                pq.remove();
                pq.add(input[i]);
            }
            i++;
        }
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }

    public static ArrayList<Integer> kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //This technique is
        // use for taking the max oreder in the queue
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == 0 || k == 0) {
            return list;
        }
        int i = 0;
        while (i < k) {
            pq.add(arr[i]);
            i++;
        }
        while (i < arr.length) {
            if (pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
            i++;
        }

        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        reverseHelper(list, 0, list.size() - 1);
        return list;
    }

    private static void reverseHelper(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return;
        }
        while (start <= end) {
            int temp = list.get(end);
            list.set(end, list.get(start));
            list.set(start, temp);
            start++;
            end--;
        }

    }

    public static void PrintStringDescending(String[] arr) {
        StringComparatorMax scmax = new StringComparatorMax();
        StringComparatorMin scmin = new StringComparatorMin();
        PriorityQueue<String> pqmin = new PriorityQueue<>(scmin);
        PriorityQueue<String> pqmax = new PriorityQueue<>(scmax);
        for (int i = 0; i < arr.length; i++) {
            pqmin.add(arr[i]);
            pqmax.add(arr[i]);
        }
        while (!pqmin.isEmpty()) {
            System.out.print(pqmin.remove() + " ");
        }
        System.out.println();
        while (!pqmax.isEmpty()) {
            System.out.print(pqmax.remove() + " ");
        }

    }

    public static boolean checkMaxHeap(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int childIndex = i;
            int parentIndex = (childIndex - 1) / 2;
            if (arr[childIndex] > arr[parentIndex]) {
                return false;
            }
        }
        return true;
    }

    public static int kthLargest(int n, int[] input, int k) {
/*Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.



Note: Try to do this in O(n*log k) time.


Example:
Input:
5
3 2 5 1 4
2
Output:
4
Explanation:
Array in non increasing form is [5,4,3,2,1]. So the 2nd largest is 4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Explanation of sample input 1:
arr = [9,4,8,7,11,3]
Array 'arr' in non increasing form is [11,9,8,7,4,3]. So the 2nd largest is 9.
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();//we are taking max but understand the quest se we
        //taken the minminum priority queue
        int i = 0;
        while (i < k) {
            pq.add(input[i]);
            i++;
        }
        while (i < input.length) {
            if (pq.peek() < input[i]) {
                pq.remove();
                pq.add(input[i]);
            }
            i++;
        }
        return pq.peek(); //understand the question then write the code .
        // in this question its given like we have to find the largest but we are using the
        // smallest pq queue because its come in the front for in smallest priority queue
        // and every time when the pq stores the element its is in sort array oreder
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> temp = input.get(i);
            for (int j = 0; j < temp.size(); j++) {
                pq.add(temp.get(j));
            }
        }
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }

    public static int buyTickets(int[] input, int k) {
        /*Sure! Let's go through the code step-by-step and explain each part in detail. The goal is to determine how many turns it takes for the person at index `k` to buy their ticket in a queue where higher priority tickets (represented by higher numbers) are served first.

### Detailed Code Explanation

1. **Imports and Class Declaration**

    ```java
    import java.util.*;

    public class TicketQueue {
    ```

    - We import necessary classes from the `java.util` package.
    - We define a class named `TicketQueue`.

2. **Method Declaration**

    ```java
    public static int buyTickets(int[] input, int k) {
    ```

    - We define a method `buyTickets` that takes an array `input` (representing ticket priorities) and an integer `k` (the index of the person we're interested in).
    - This method will return the number of turns it takes for the person at index `k` to buy their ticket.

3. **Priority Queue and Regular Queue Initialization**

    ```java
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> q = new LinkedList<>();
    ```

    - `pq` is a priority queue that will keep elements in descending order (highest priority first) due to `Collections.reverseOrder()`.
    - `q` is a regular queue that will maintain the order of people in the queue.

4. **Populating the Queues**

    ```java
    for (int x : input) {
        q.add(x);
        pq.add(x);
    }
    ```

    - We iterate through the `input` array.
    - For each element `x` in `input`, we add it to both `q` (the regular queue) and `pq` (the priority queue).

5. **Turn Counter Initialization**

    ```java
    int count = 0;
    ```

    - We initialize a counter `count` to keep track of the number of turns.

6. **Processing the Queue**

    ```java
    while (!q.isEmpty()) {
    ```

    - We start a loop that will run until the queue `q` is empty.

7. **Check if the Person at the Front Can Buy a Ticket**

    ```java
    if (q.peek().equals(pq.peek())) {
    ```

    - We check if the person at the front of the queue (`q.peek()`) has the highest priority (matches `pq.peek()`).

8. **Handling the Person at the Front**

    ```java
    if (k == 0) {
        return count + 1;
    } else {
        count++;
        q.poll();
        pq.poll();
        k--;
    }
    ```

    - If `k == 0`, the person at the front of the queue is the one we're interested in, so we return the number of turns taken so far plus one.
    - If not, we:
        - Increment the turn counter `count`.
        - Remove the person from the front of both queues (`q.poll()` and `pq.poll()`).
        - Decrement `k` (since the queue is now one person shorter, the index `k` of our person decreases by 1).

9. **Rotating the Queue if the Front Person Cannot Buy a Ticket**

    ```java
    } else {
        q.add(q.poll());
        if (k == 0) {
            k = q.size() - 1;
        } else {
            k--;
        }
    }
    ```

    - If the person at the front of the queue does not have the highest priority:
        - We move the person from the front to the back of the queue (`q.add(q.poll())`).
        - Adjust `k`:
            - If `k == 0`, our person is now at the end of the queue, so we set `k` to `q.size() - 1`.
            - Otherwise, we simply decrement `k`.

10. **Method Return Statement**

    ```java
    return count;
    }
    ```

    - Once the queue is empty, we return the total number of turns. This line is just a formality and typically won't be reached due to our earlier return conditions.

11. **Main Method for Testing**

    ```java
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Number of elements in the array
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();  // The index k
        System.out.println(buyTickets(input, k));
        scanner.close();
    }
    ```

    - This `main` method is for testing the `buyTickets` method.
    - It reads the input from the user:
        - Number of elements in the array (`n`).
        - The elements of the array.
        - The index `k`.
    - It then calls `buyTickets` with these inputs and prints the result.

### Step-by-Step Example

Given input:
- Array: `[3, 9, 4]`
- Index `k`: `2`

Initial states:
- Queue `q`: `[3, 9, 4]`
- Max-Heap `pq`: `[9, 4, 3]`
- Target index `k`: `2`

**Step-by-step Simulation**:

1. **Turn 1**:
    - `q.peek() = 3`, `pq.peek() = 9`
    - Move `3` to the end: `q = [9, 4, 3]`
    - Decrement `k`: `k = 1`

2. **Turn 2**:
    - `q.peek() = 9`, `pq.peek() = 9`
    - Remove `9` from both `q` and `pq`
    - Queue: `q = [4, 3]`, Max-Heap: `pq = [4, 3]`
    - Decrement `k`: `k = 0`
    - Increment count: `count = 1`

3. **Turn 3**:
    - `q.peek() = 4`, `pq.peek() = 4`
    - Since `k == 0`, the person at the front is our target.
    - Return count + 1: `count + 1 = 2`

Thus, the output is `2`.

This detailed explanation should help you understand each part of the code and how it works step-by-step.*/
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        for (int x : input) {
            q.add(x);
            pq.add(x);
        }
        int count = 0;
        while (!q.isEmpty()) {
            if (q.peek().equals(pq.peek())) {
                if (k == 0) {
                    return count + 1;
                } else {
                    count++;
                    q.poll();
                    pq.poll();
                    k--;
                }
            } else {
                q.add(q.peek());
                q.poll();
                if (k == 0) {
                    k = q.size() - 1;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    public static void findMedian(int arr[]) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size()) {
                System.out.print(maxHeap.peek() + " ");
            } else if (minHeap.size() > maxHeap.size()) {
                System.out.print(minHeap.peek() + " ");
            } else {
                int median = (maxHeap.peek() + minHeap.peek()) / 2;
                System.out.print(median + " ");
            }
        }

    }

    public static void main(String[] args) {
        /* int[] arr1 = {2, 4, 1, 9, 6, 8};
        kSortedArray(arr1, 3);*/
        /*int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        ArrayList<Integer> list = kSmallest(arr, 4);
        for (int x : list) {
            System.out.print(x + " ");
        }*/
        /*  String[] arr = {"A", "ABC", "ABCD", "ABCDE", "ABCDEF", "ABCDEFG"};
        PrintStringDescending(arr);*/
        int[] arr = {3, 2, 5, 1, 4};
        int ans = kthLargest(5, arr, 2);
        System.out.println(ans);

    }
}

//This is Best For Comparisions
class StringComparatorMax implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return 1;
        }
        if (s1.length() > s2.length()) {
            return -1;
        }
        return 0;
    }
}

class StringComparatorMin implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}