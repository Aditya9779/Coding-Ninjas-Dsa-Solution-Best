import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RevKr {
    public static Edge[] take() {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        Edge[] ed = new Edge[vertices];
        for (int i = 0; i < edges; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int we = sc.nextInt();
            ed[i] = new Edge(sv, ev, we);
        }
        sc.close();
        sortArray(ed);
        return ed;
    }

    public static void sortArray(Edge[] ed) {
        compareWeight com = new compareWeight();
        Collections.sort(Arrays.asList(ed), com);  //Imp to because it takes only the List
    }

    public static void kru(Edge[] ed, int vertex) {
        int parent[] = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            parent[i] = i;
        }
        Edge[] output = new Edge[vertex - 1];
        int count = 0;
        int i = 0;
        while (count != vertex - 1) {
            Edge curreent = ed[i];
            int sourceParent = findParent(curreent.source, parent);
            int destiParent = findParent(curreent.destination, parent);
            if (sourceParent != destiParent) {
                output[count] = curreent;
                count++;
                parent[sourceParent] = destiParent;
            }
            i += 1;
        }
        for (int j = 0; j < output.length; j++) {
            Edge curreent = output[j];
            System.out.println("Start:" + curreent.source + " " + "End:" + curreent.destination + "" + "Weight" + curreent.weight);
            ;
        }
    }

    private static int findParent(int vertex, int parent[]) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findParent(parent[vertex], parent);
        }
        return parent[vertex];
    }

    public static void main(String[] args) {
        Edge[] edges = take();
        kru(edges, edges.length);
    }
}


class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge() {

    }
  /*  public int compareTo(Edge o) {
        return this.w - o.w;
    }*/  //If we do not want to make the SortArray function
}

class compareWeight implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        if (o1.weight == o2.weight) {
            return 0;
        } else if (o1.weight > o2.weight) {
            return 1;
        }
        return -1;
    }
}
