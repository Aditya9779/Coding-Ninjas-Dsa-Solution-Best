
import java.util.LinkedList;
import java.util.Scanner;

public class linkedlistusebyjavaclass {

    public static LinkedList<Integer> takeinput(){
        Scanner sc= new Scanner(System.in);
        int data=sc.nextInt();
        LinkedList<Integer> list=new LinkedList<>();

        while (data!=-1){
            list.add(data);
            data=sc.nextInt();
          }
        return  list;
    }
    static void printLl(LinkedList<Integer> head){
        LinkedList<Integer> temp=head;
        int i=0;
        while (i<temp.size()){
            System.out.print(temp.get(i) + " ");
            i++;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> ans=takeinput();
        printLl(ans);
    }



}

/*
import java.util.LinkedList;
import java.util.Scanner;

public class linkedlistusebyjavaclass {


public static LinkedList<Integer> takeinput(){
    Scanner sc = new Scanner(System.in);
    int data;
    LinkedList<Integer> list = new LinkedList<>();

    System.out.println("Enter integers (terminate with -1):");
    data = sc.nextInt();
    while (data != -1) {
        list.add(data);
        data = sc.nextInt(); // read the next integer
    }
    return list;
}

    static void printLl(LinkedList<Integer> head){
        for (Integer num : head) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> ans = takeinput();
        printLl(ans);
    }
}
*/
