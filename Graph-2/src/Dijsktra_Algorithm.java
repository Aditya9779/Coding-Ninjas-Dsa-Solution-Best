import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijsktra_Algorithm {
    static int[][] takeInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the vertex");
        int vertices = in.nextInt();
        System.out.println("Enter the edges");
        int edges = in.nextInt();
        int[][] matrix = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter start vertex , end vertex and weight");
            int start = in.nextInt();
            int end = in.nextInt();
            int weight = in.nextInt();
            matrix[start][end] = weight;
            matrix[end][start] = weight;
        }
        return matrix;
    }

    static List<Edge> takeInputEdge() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the vertex");
        int vertex = in.nextInt();
        System.out.println("Enter the edge");
        int edges = in.nextInt();
        List<Edge> edgesList = new ArrayList<Edge>();
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the Starting and Ending vertex: and Weight ");
            int sv = in.nextInt();
            int ev = in.nextInt();
            int weight = in.nextInt();
            edgesList.add(new Edge(sv, ev, weight));
        }
        return edgesList;
    }

    public static void dijsktra(List<Edge> graph /*int [][]graph*/) {
//        int vertices = graph.length;
        int vertices = graph.size();
        boolean[] visited = new boolean[vertices];
        int distance[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
       /* for (int i = 0; i < vertices-1; i++) { //Because we do not find the full vertex we have to
            // go just in the target node
            int minVertex = findMinvertex(visited, distance); //same for removing we use the priority queue
            visited[minVertex] = true;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && (graph[minVertex][j] + distance[minVertex] < distance[j]) &&
                graph[minVertex][j] != 0 && graph[minVertex][j] != Integer.MAX_VALUE) {
                    distance[j] = graph[minVertex][j] + distance[minVertex];
                }
            }
        }*/
        //Implementaion with the matrix
       /* PriorityQueue<pairDij> pq = new PriorityQueue<pairDij>();
        pq.add(new pairDij(0, 0));
        while (!pq.isEmpty()) {
            pairDij currentEle = pq.poll();
            int minVertex = currentEle.distance;
            if (!visited[minVertex]) {
                visited[minVertex] = true;
                for (int i = 0; i < vertices; i++) {
                    if (!visited[i] && graph[minVertex][i] != 0 && (graph[minVertex][i] + distance[minVertex] < distance[i])) {
                        distance[i] = graph[minVertex][i] + distance[minVertex];
                        pq.add(new pairDij(i, distance[i]));
                    }
                }
            }
        }*/

        PriorityQueue<pairDij> pq = new PriorityQueue<>();
        pq.add(new pairDij(0, 0));
        while (!pq.isEmpty()) {
            pairDij cur = pq.poll();
            int minVer = cur.vertex;
            if (visited[minVer]) continue; // Add this line to skip already visited vertices
            visited[minVer] = true;
            for (int i = 0; i < graph.size(); i++) { // Change this line to iterate over the graph list using an index
                Edge edgeCur = graph.get(i); // Access the current edge
                int edSource = edgeCur.source;
                int edDestination = edgeCur.destination;
                int edWeight = edgeCur.weight;
                if (!visited[edDestination] && distance[edSource] + edWeight < distance[edDestination] && distance[edSource] != Integer.MAX_VALUE) { // Update the condition
                    distance[edDestination] = distance[edSource] + edWeight;
                    pq.add(new pairDij(edDestination, distance[edDestination])); // Use edDestination instead of i
                }
            }
        }


        for (int i = 0; i < vertices; i++) {
            if (distance[i] != Integer.MAX_VALUE) {  //This if else if very imp
                System.out.println(i + " " + distance[i]);
            }
        }
    }


    private static int findMinvertex(boolean[] visited, int[] distance) {
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minIndex == -1 || distance[i] < distance[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
//        int[][] matrix = takeInput();
//        List<Edge> matrix = takeInputEdge();
//        dijsktra(matrix);

    }

}

class pairDij implements Comparable<pairDij> {
    int vertex;
    int distance;

    public pairDij(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int compareTo(pairDij o) {
        return this.distance - o.distance;
    }
}
