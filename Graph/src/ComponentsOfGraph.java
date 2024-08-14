import java.util.ArrayList;
import java.util.Scanner;

public class ComponentsOfGraph {
    public static ArrayList<ArrayList<Integer>> componentsOfGraph(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> arr = new ArrayList<>();
                helper(graph, i, visited, arr);
                ans.add(arr);
            }
        }
        return ans;
    }

    private static void helper(int[][] graph, int sv, boolean[] visited, ArrayList<Integer> arr) {
        arr.add(sv);
        visited[sv] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[sv][i] == 1) {
                helper(graph, i, visited, arr);
            }
        }
    }

    public static void main(String[] args) {
        int vertex;
        int edges;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertex = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        edges = sc.nextInt();
        int[][] graph = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        sc.close();
    }
}
