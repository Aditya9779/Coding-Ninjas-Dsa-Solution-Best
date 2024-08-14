import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
    public static boolean hasPath(int graph[][], int sv, int ev) {
        boolean visited[] = new boolean[graph.length];
        return HasPathHelper(graph, sv, ev, visited);
    }

    private static boolean HasPathHelper(int[][] graph, int sv, int ev, boolean[] visited) {
        int n = graph.length;
        if (sv >= n || ev >= n || sv < 0 || ev < 0) {
            return false;
        }
        if (graph[sv][ev] == 1) {
            return true;
        }
        /*      int edges[][] =new int[n][n]; //Imp to store the value in the edges
        /*If we do this the function will use the algorithm very fast in O(1)*/  //For the better code efficiency
       /* for (int i = 0; i < n; i++) {
            int a=graph[i][0];
            int b=graph[i][1];
            edges[a][b]=1;
            edges[b][a]=1;
        }*/
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == ev) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertex;
        int edges;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertex = in.nextInt();
        System.out.println("Enter the number of edges: ");
        edges = in.nextInt();
        int graph[][] = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the vertex: 1st and 2nd vertex: ");
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
       /* int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };*/
        boolean result = hasPath(graph, 1, 3);
        System.out.println(result);
    }
}
