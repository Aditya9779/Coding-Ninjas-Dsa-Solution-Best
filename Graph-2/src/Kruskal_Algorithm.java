import java.util.*;

public class Kruskal_Algorithm {
    public static List<EdgesClass> takeInput() {
        Scanner sc = new Scanner(System.in);
        List<EdgesClass> edgesList = new ArrayList<>();
        System.out.println("Enter the number of vertices");
        int vertex = sc.nextInt();
        System.out.println("Enter the number of edges");
        int edges = sc.nextInt();

        /* Connecting the edges according to the start and end index */
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the Start and End vertex");
            int sv = sc.nextInt(); // Starting index
            int ev = sc.nextInt(); // Ending index
            System.out.println("Enter the Weight of the edge");
            int weight = sc.nextInt();
            edgesList.add(new EdgesClass(sv, ev, weight));
        }
        sortArray(edgesList);
        return edgesList;
    }

    public static void sortArray(List<EdgesClass> edgesList) {
        EdgesComparatorWeight comparator = new EdgesComparatorWeight();
        Collections.sort(edgesList, comparator);
    }


    private static void kruskal(List<EdgesClass> input, int vertex) {
        List<EdgesClass> output = new ArrayList<>();
        int parent[] = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            parent[i] = i;
        }
        int rank[] = new int[vertex];
        int count = 0;
        int i = 0;
        while (count != vertex - 1) {
            EdgesClass currentEdges = input.get(i);
            int startingParent = findparent(parent, currentEdges.sv);
            int endingParent = findparent(parent, currentEdges.ev);
            if (startingParent != endingParent) {
                output.add(currentEdges);
                /*parent[startingParent] = endingParent;*/ //Better way using the rank
                unionRank(parent, rank, startingParent, endingParent);
                count++;
            }
            i++;
        }
        System.out.println("Minimum Spanning Tree edges:");
        /*for (EdgesClass edge : output) {
            System.out.println("Start: " + edge.sv + ", End: " + edge.ev + ", Weight: " + edge.weight);
        }*/
        for (int j = 0; j < output.size(); j++) {
            EdgesClass ans = output.get(j);
            System.out.println("Start: " + ans.sv + ", End: " + ans.ev + ", Weight: " + ans.weight);
        }
    }

    private static int findparent(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findparent(parent, parent[vertex]); // Path compression
            //Very imp in this we are makeing the path to direct attach to the node of the
            // parent
        }
        return parent[vertex];
    }

    /*Union By Rank Method*/
    public static void unionRank(int parent[], int rank[], int sv, int ev) {
        int rootx = findparent(parent, sv);
        int rooty = findparent(parent, ev);
        if (rootx != rooty) {
            if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else {
                parent[rooty] = rootx;
                rank[rootx] = rank[rootx] + 1;
            }
        }
    }

    public static void main(String[] args) {
        List<EdgesClass> input = takeInput();
        kruskal(input, input.size()); //Here the input.size() is the total number of vertex
        //just imagine like that the every component its has its own vertex
    }
}

class EdgesComparatorWeight implements Comparator<EdgesClass> {  //See Comparator<> in this we
    // Every time we right but we are comparing the Edgesclass so we write this but in this Edgesclass
    // We are comparing the weight
    @Override
    public int compare(EdgesClass edge1, EdgesClass edge2) {
        if (edge1.weight < edge2.weight) {
            return -1;
        } else if (edge1.weight > edge2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}

class EdgesClass {
    int sv;   // Start Vertex
    int ev;   // End Vertex
    int weight;

    public EdgesClass(int sv, int ev, int weight) {
        this.sv = sv;
        this.ev = ev;
        this.weight = weight;
    }

    public EdgesClass() {

    }
}




