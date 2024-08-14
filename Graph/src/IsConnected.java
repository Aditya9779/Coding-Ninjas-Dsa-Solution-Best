import java.util.Scanner;

public class IsConnected {
    public static boolean isConnected(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int vetexfinder = helperIsConnected(graph, visited, 0);
        if (graph.length == vetexfinder) {
            return true;
        }
        return false;
    }

    private static int helperIsConnected(int[][] graph, boolean[] vistited, int sv) {
        int count = 1;
        vistited[sv] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[sv][i] == 1 && !vistited[i]) {
                count += helperIsConnected(graph, vistited, i);
            }
        }
        return count;
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
        System.out.println(isConnected(graph));
    }
}

