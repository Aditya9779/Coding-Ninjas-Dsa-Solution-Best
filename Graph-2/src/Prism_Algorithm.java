import java.util.*;

public class Prism_Algorithm {

    public static int[][] takeInputMatrix() {
        int vertex;
        int edges;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        vertex = in.nextInt();
        System.out.println("Enter the number of edges: ");
        edges = in.nextInt();
        int[][] graph = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the Starting and Ending vertex: and Weight ");
            int sv = in.nextInt();
            int ev = in.nextInt();
            int weight = in.nextInt();
            graph[sv][ev] = weight;
            graph[ev][sv] = weight;
        }
        return graph;
    }

    public static List<Edge> takeInputEdge() {
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

    public static void prism(/*int[][] graph*/ List<Edge> edges) {
//        int vertex = graph.length;
        int vertex = edges.size();
        boolean visited[] = new boolean[vertex];
        int parent[] = new int[vertex];
        int weight[] = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        weight[0] = 0;
        parent[0] = -1;
        /* *//*The Time complexity of the code is O(v^20*//*
        for (int count = 0; count != vertex - 1; count++) {   //O(V)
            int minVertex = findMinVertexInWeight(weight, visited);  //O(V) //We can do better using Priority Queue
            visited[minVertex] = true;
            for (int i = 0; i < vertex; i++) {         //O(V) //For Better store like Edge class in Kruskal
                if (!visited[i] && graph[minVertex][i] != 0 && (graph[minVertex][i] < weight[i])) {
                    weight[i] = graph[minVertex][i]; //checking for the weight update
                    parent[i] = minVertex;//changing the parent index
                }
            }
        }*/
        /*************************************************************************************************************/
        //This implementation with the matrix
       /* PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair currentElem = pq.poll();
            int curVertex = currentElem.vertex;
            if (!visited[curVertex]) {
                visited[curVertex] = true;
                for (int i = 0; i < vertex; i++) {
                    if (graph[curVertex][i] != 0 && !visited[i] && graph[curVertex][i] < weight[i]) {
                        weight[i] = graph[curVertex][i];
                        parent[i] = curVertex;
                        pq.add(new Pair(i, weight[i]));
                    }
                }
            }
        }
        for (int i = 1; i < vertex; i++) { //i==1 because i=0 we have weiht=0 and parent=-1
            if (parent[i] > i) {
                System.out.println("Sv: " + i + " Ev: " + parent[i] + " & Weight " + weight[i] + " ");
            } else {
                System.out.println("Sv: " + parent[i] + " Ev: " + i + " & Weight" + weight[i] + " ");
            }
        }

    */
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair currentElement = pq.poll();
            int currVertex = currentElement.vertex;
            if (!visited[currVertex]) {
                visited[currVertex] = true;
                for (int i = 0; i < vertex; i++) {
                    Edge currentEdge = edges.get(i);
                    int edgeWei = currentEdge.weight;
                    int edgeSou = currentEdge.source;
                    int edgeDes = currentEdge.destination;
                    if (!visited[edgeDes] && edgeWei < weight[edgeDes]) {
                        weight[edgeDes] = edgeWei;
                        parent[edgeDes] = edgeSou;
                        pq.add(new Pair(edgeDes, edgeWei));
                    }
                }
            }
        }
        for (int i = 1; i < vertex; i++) { //i==1 because i=0 we have weiht=0 and parent=-1
            if (parent[i] > i) {
                System.out.println("Sv: " + i + " Ev: " + parent[i] + " & Weight " + weight[i] + " ");
            } else {
                System.out.println("Sv: " + parent[i] + " Ev: " + i + " & Weight" + weight[i] + " ");
            }
        }

    }

    private static int findMinVertexInWeight(int[] weight, boolean[] visited) {
        int minVertex = -1; //We have no value in the index
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
                //if we are findind in array -1 it shows the index out of bound
                // so for the first check we have to take the first value in the weight array
                // and their is (OR) operator so in first condition its checks only the  minvertex==-1
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
       // int[][] graph = takeInputMatrix();
        //prism(graph);
        List<Edge> edges = takeInputEdge();
        prism(edges);
    }
}

class Pair implements Comparable<Pair> {
    int vertex;
    int weight;

    public Pair(int v, int w) {
        vertex = v;
        weight = w;
    }

    public Pair() {

    }

    public int compareTo(Pair o) {    //Taking the comparasiton between the weight in pair class
        return this.weight - o.weight;
    }
}

