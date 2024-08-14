import java.util.List;
import java.util.Scanner;

public class LinkedListUse {

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    public static Node<Integer> takeRevision() {
        int data;
        Node<Integer> head = null, previous = null;
        Scanner s = new Scanner(System.in);
        data = s.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                previous = newNode;

            } else {

                previous.next = newNode;
                previous = newNode;
            }
            data = s.nextInt();
        }

        return head;


    }

    public static Node<Integer> insert(Node<Integer> head, int data, int position) {
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
            if (count == position) {
                Node<Integer> newNode = new Node<>(data);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;


    }
    /*public static Node<Integer> insert(Node<Integer> head, int data, int position) {
        if (position == 0) { // Insert at the beginning
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            return newNode;
        }

        Node<Integer> current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count == position) {
                Node<Integer> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                break; // Inserted the node, so exit the loop
            }
            current = current.next;
        }
        return head; // Return the head of the list
    }
*/


    public static Node<Integer> delete(Node<Integer> head, int pos) {
        if (pos == 0) {
            head = head.next;
            return head;
        }

        if (head == null) {
            return head;
        }

        int count = 0;
        Node<Integer> temp = head;
        while (count < pos - 1 && temp != null) {
            count++;
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static int countLengthOfLL(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static Node<Integer> incrementinLL(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        int increment = 1;
        Node<Integer> temp = head;
        while (temp != null) {
            temp.data = temp.data + increment;
            temp = temp.next;
        }
        return head;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        Node<Integer> temp = head;
        while (temp.next != null) {
            if (temp.data != temp.next.data) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    public static void printReverse(Node<Integer> head) {
        if (head == null) {
            return;
        }
        Node<Integer> temp = head;
        printReverse(temp.next);
        System.out.print(temp.data + " ");
    }

    public static Node<Integer> reverseLinked(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> nextNode = null;

        while (current != null) {
            nextNode = current.next; // Store the next node
            current.next = previous; // Reverse the next pointer
            previous = current; // Move previous to current
            current = nextNode; // Move current to the next node
        }

        head = previous; // Update the head to the last node

        return head;
    }

       /* public boolean isPalindrome(ListNode head) {
            // If the list is empty or has only one element, it's a palindrome
            if (head == null || head.next == null) {
                return true;
            }

            // Find the middle of the linked list
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse the second half of the linked list
            ListNode secondHalf = reverseList(slow.next);

            // Compare the first half with the reversed second half
            ListNode firstHalf = head;
//        while (secondHalf != null) {
//            if (firstHalf.val != secondHalf.val) {
//                return false;
//            }
//            firstHalf = firstHalf.next;
//            secondHalf = secondHalf.next;
//        }
//
//        return true;
//    }
            while (firstHalf != null) {
                if (firstHalf.next != secondHalf.val) {
                    return false;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            private Node<Integer> reverseList (ListNode head){
                ListNode prev = null;
                ListNode current = head;
                while (current != null) {
                    ListNode nextNode = current.next;
                    current.next = prev;
                    prev = current;
                    current = nextNode;
                }
                return prev;
            }

        }*/


    public static boolean isPalindrome(Node<Integer> head) {
        // If the list is empty or has only one element, it's a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        Node<Integer> secondHalf = reverseList(slow.next);

        // Compare the first half with the reversed second half
        Node<Integer> firstHalf = head;
        while (secondHalf != null) {
            if (!firstHalf.data.equals(secondHalf.data)) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static Node<Integer> evenOdd(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        Node<Integer> oddHead = null;
        Node<Integer> oddTail = null;
        Node<Integer> evenHead = null;
        Node<Integer> evenTail = null;
        Node<Integer> temp = head;

        while (temp != null) {
            if (temp.data % 2 == 1) {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            } else {
                if (evenHead == null) {
                    evenTail = temp;
                    evenHead = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }

            temp = temp.next;
        }
        if (oddHead == null) {
            return evenHead;
        } else {
            oddTail.next = evenHead;
            evenTail.next = null;
        }

        if (evenHead != null) {
            evenTail.next = null;
            return oddHead;
        }
        return oddHead;

    }



 /*   public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (head == null) {
            return head;
        }
        Node<Integer> temp=head;
        Node<Integer> temp1=null;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
            if (count == M) {
                int count2=0;
                temp1=temp;
                while (temp1!=null && count2<N){
                    temp1=temp1.next;
                }
            }
            temp.next=temp1.next;
        }


       return head;

    }
*/
 /*public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (head == null || M==0) {
            return null;
        }
     if (N == 0) {
         return head;
     }
        Node<Integer> temp = head;
        Node<Integer> temp1;

        while (temp != null) {
            int count = 1;
            while (count < M && temp != null) {
                temp = temp.next;
                count++;
            }

            if (temp == null) {
                return head;
            }

            temp1 = temp.next;
            int count2 = 0;
            while (temp1 != null && count2 < N) {
                temp1 = temp1.next;
                count2++;
            }

            if (temp1 == null) {
                temp.next = null;
            } else {
                temp.next = temp1.next;
            }

            temp = temp.next;
        }

        return head;
    }*/

    public static Node<Integer> skipMdeleteN1(Node<Integer> head, int M, int N) {
        if (head == null || M == 0) {
            return null;
        }
        if (N == 0) {
            return head;
        }
        Node<Integer> current = head;
        Node<Integer> temp = null;
        while (current != null) {
            int take = 0;
            int skip = 0;
            while (current != null && take < M) {
                if (temp == null) {
                    temp = current;
                } else {
                    temp.next = current;
                    temp = current;
                }
                current = current.next;
                take++;
            }

            while (current != null && skip < N) {
                current = current.next;
                skip++;
            }


        }
        if (temp != null) {
            temp.next = null;
        }
        return head;
    }


    private static Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer> prev = null;
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;
        Node<Integer> tail = null;    // Always give the tail null
        Node<Integer> mergeHead = null; // merge head is also null from the start
        if (temp1.data < temp2.data) {
            mergeHead = temp1;
            tail = temp1;
            temp1 = temp1.next;
        } else {
            mergeHead = temp2;
            tail = temp2;
            temp2 = temp2.next;
        }
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) {
            tail.next = temp1;
        }
        if (temp2 != null) {
            tail.next = temp2;
        }

        return mergeHead;

    }


     public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (head == null || M <= 0) {
            return null; // Return null if the list is empty or M is invalid
        }
        if (N == 0) {
            return head; // No deletion needed if N is 0
        }

        Node<Integer> current = head;  // Pointer to traverse the list
        Node<Integer> prevTail = null; // Points to the end of the previous segment

        // Traverse the list
        while (current != null) {
            // Skip M nodes
            int countM = 1;
            while (countM < M && current != null) {
                prevTail = current;
                current = current.next;
                countM++;
            }

            // Delete N nodes
            int countN = 0;
            while (countN < N && current != null) {
                current = current.next;
                countN++;
            }

            // Connect the end of the previous segment to the current node
            if (prevTail != null) {
                prevTail.next = current;
            } else {
                head = current; // If prevTail is null, update the head
            }
        }

        // Return the modified head
        return head;
    }


    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if (i == j || head == null) {
            return head;
        }
        Node<Integer> prev = null, firstHead = null, firstTail = null, secondHead = null, secondTail = null;
        Node<Integer> current = head;
        int pos = 0;
        while (current != null) {
            if (pos == i) {
                firstHead = current;
                firstTail = prev;
            } else if (pos == j) {
                secondHead = current;
                secondTail = prev;
            }

            current = prev;
            current = current.next;
            pos++;
        }
        if (firstTail != null) {
            firstTail.next = secondHead;
        } else {
            head = secondHead;
        }
        if (secondTail != null) {
            secondTail.next = firstHead;
        } else {
            head = firstHead;
        }

        Node<Integer> currentNode = secondHead.next;
        secondHead.next = firstHead.next;
        firstHead.next = currentNode;


        return head;
    }


    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }
        int pos = 0;
        Node<Integer> temp = null, previous = null, current = head;

        while (pos < k && current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            pos++;
        }
        if (temp != null) {
            head.next = kReverse(temp, k);
        }
        head = previous;
        return head;

    }

    private static int countLengthOfNode(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {

        int n = countLengthOfNode(head);


        for (int i = 0; i < n - 1; i++) {
            Node<Integer> prev = null;
            Node<Integer> current = head;
            for (int j = 0; j < n - 1 - i; j++) {
                if (current.data <= current.next.data) {
                    prev = current;
                    current = current.next;
                } else {
                    if (prev == null) {
                        Node<Integer> temp = current.next;
                        head = head.next;
                        current.next = temp.next;
                        temp.next = current;
                        prev = temp;

                    } else {
                        Node<Integer> temp = current.next;
                        prev.next = temp;
                        current.next = temp.next;
                        temp.next = current;
                        prev = temp;
                    }
                }


            }
        }


        return head;

    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp = head;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<Integer> head1 = temp;
        Node<Integer> head2 = slow.next;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        Node<Integer> ans = mergeTwoSorteds(head1, head2);
        return ans;


    }


    public static void main(String[] args) {


//        Node<Integer> list1 = new Node<>(10);
//        Node<Integer> list2 = new Node<>(20);
//        Node<Integer> list3 = new Node<>(30);
//        list1.next = list2;
//        list2.next = list3;
//        print(list1);
        Node<Integer> arr = takeRevision();
        // print(arr);
        //Node<Integer> arr1=insert(arr,80,3);
//        Node<Integer> arr1 = delete(arr, 3);
//        print(arr1);
        //Node<Integer> increment = incrementinLL(arr);
        //  print(arr1);
//printReverse(arr);
//Node<Integer> dupli=removeDuplicates(arr);
//        System.out.println();
//print(dupli);
// mergeSort(arr);
        //  print(mergeSort(arr));
        int k = 3;
        print(kReverse(arr, k));


    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }
        ListNode temp = null;
        ListNode prev = null;
        ListNode cur = head;
        int co = 0;
        while (co < k && cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            co++;
        }
        if (temp != null) {
            head.next = reverseKGroup(temp, k);
        }
        head = prev;
        return head;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null)
            return head;

        ListNode f1 = null, f2 = null, s1 = null, s2 = null;
        ListNode current = head, previous = head;
        int pos = 1;

        while (current != null) {
            if (pos == left) {
                f1 = previous;
                f2 = current;
            } else if (pos == right) {
                s1 = current;
                s2 = current.next; // Store the node after right
                break;
            }
            previous = current;
            current = current.next;
            pos++;
        }
        f1.next = null;
        s1.next = null;
        ListNode stop = s2;
        ListNode cur = s1;
        ListNode temp = null;
        ListNode prev = null;


        while (cur != stop) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        f1.next = prev;
        f2.next = s2;
        return head;


    }
}



