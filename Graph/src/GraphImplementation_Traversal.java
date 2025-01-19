import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphImplementation_Traversal {
    //Sv - Starting Vertex
    public static void DfsTraHel(int[][] graph, int sv, boolean[] visted) {
        System.out.print(sv + " "); //Starting Vertex is the first node present in it
        visted[sv] = true;
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            if (!visted[i] && graph[sv][i] == 1) {
                DfsTraHel(graph, i, visted);
            }
        }
    }

    public static void DfsTraversal(int[][] graph) {
        boolean[] visted = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visted[i]) {
                DfsTraHel(graph, i, visted);
            }
        }
    }

    public static void BfsTraversal(int[][] graph) {
        boolean[] visted = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visted[i]) {
                BfsTraHel(graph, i, visted);
            }
        }
    }

    private static void BfsTraHel(int[][] graph, int sv, boolean[] visted) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sv);
        visted[sv] = true;
        while (!queue.isEmpty()) {
            int frontVertex = queue.poll();
            System.out.print(frontVertex + " ");
            for (int i = 0; i < graph.length; i++) {
                //(1) is used for the connection between the graph
                if (!visted[i] && graph[frontVertex][i] == 1) {
                    queue.add(i);
                    visted[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int vertex; //Vertex the node value
        int edges; // Edges is the connection value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        vertex = sc.nextInt();
        System.out.println("Enter the number of edges");
        edges = sc.nextInt();
        int[][] graph = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter first Vertex and Second Vertex");
            int fv = sc.nextInt(); //First Vetex
            int sv = sc.nextInt(); //Second Vertex
            graph[sv][fv] = 1;
            graph[fv][sv] = 1;
        }
        DfsTraversal(graph);
        System.out.println();
        BfsTraversal(graph);
        sc.close();

    }
}

//LeetCode Graph Questiongigit push -u origin main
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1')
                    count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }

    private void dfs(char[][] graph, int i, int j) {
        int rowLength = graph.length;
        int colLength = graph[0].length;
        if (i < 0 || i >= rowLength || j < 0 || j >= colLength || graph[i][j] == '0') return;
        dfs(graph, i - 1, j);//up
        dfs(graph, i + 1, j);//down
        dfs(graph, i, j + 1);//right
        dfs(graph, i, j - 1);//left
    }
}
