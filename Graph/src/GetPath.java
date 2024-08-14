import java.util.*;

public class GetPath {
    public static ArrayList<Integer> getPathDfs(int graph[][], int sv, int ev) {
        boolean[] visited = new boolean[graph.length];
        return getPathHelperDfs(graph, sv, ev, visited);
    }

    private static ArrayList<Integer> getPathHelperDfs(int[][] graph, int sv, int ev, boolean[] visited) {
        int n = graph.length;
        if (sv < 0 || sv >= n || ev < 0 || ev >= n) {
            return null;
        }
        if (sv == ev && graph[sv][ev] == 1) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(sv);
            return path;
        }
        visited[sv] = true;
        ArrayList<Integer> path = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[sv][i] == 1) {
                visited[i] = true;
                path = getPathHelperDfs(graph, i, ev, visited);
                if (path != null) {
                    path.add(sv);
                    return path;
                }
            }
        }
        visited[sv] = false;
        return path;
    }

    public static ArrayList<Integer> getPathBfs(int graph[][], int sv, int ev) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        return getPathHelperBfs(graph, sv, ev, visited, map);
    }

    private static ArrayList<Integer> getPathHelperBfs(int[][] graph, int sv, int ev, boolean[] visited, HashMap<Integer, Integer> map) {
        int n = graph.length;
        if (sv < 0 || sv >= n || ev < 0 || ev >= n) {
            return null;
        }
        if (sv == ev && graph[sv][ev] == 1) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(sv);
            return path;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            int firstVertex = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[firstVertex][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                    map.put(i, firstVertex);
                    if (i == ev) {
                        ArrayList<Integer> path = new ArrayList();
                        path.add(ev);
                        int value = map.get(ev);
                        while (value != sv) {
                            path.add(value);
                            value = map.get(value);
                        }
                        path.add(sv);
                        return path;
                    }
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int vertex;
        int edges;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertex = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        edges = sc.nextInt();
        int graph[][] = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the vertex: ");
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            graph[sv][ev] = 1;
            graph[ev][sv] = 1;
        }
    }
}
