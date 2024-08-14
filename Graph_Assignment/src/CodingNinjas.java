public class CodingNinjas {
    /*******************************************************************************************/

    public static int numConnected(int[][] edges, int n) {
        if (edges.length == 0) {
            return 0;
        }
        int veTx = edges.length;
        boolean[] visited = new boolean[veTx];
        int count = 0;
        for (int i = 0; i < veTx; i++) {
            if (!visited[i]) {
                dfsIsland(edges, i, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfsIsland(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i] && edges[sv][i] == 1) {
                dfsIsland(edges, i, visited);
            }
        }
    }

    /*********************************************************************************************/
    /* Time Complexity is O(N*M + 8^(word.length) */  //8 is for eight all columns left right and top bottom diagonal
    static int solve(String[] Graph, int N, int M) {
        if (N == 0 || M == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[N][M];
        String str = "CODINGNINJA";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { //checking for all 8 sides in the array index
                if (Graph[i].charAt(j) == str.charAt(0)) {
                    boolean ans = dfsSolve(Graph, visited, str.substring(1), i, j);
                    if (ans) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean dfsSolve(String[] graph, boolean[][] visited, String str, int curX, int curY) {
        if (str.length() == 0) {  //In coding ninja we are at the last word so we found is the base call
            return true;
        }
        visited[curX][curY] = true;
        // To traverse in 8 different directions
        int[] X_Dir = {-1, 1, 0, 0, 1, -1, 1, -1}; //For the all eight path
        int[] Y_Dir = {0, 0, -1, 1, 1, -1, -1, 1};
        for (int i = 0; i < X_Dir.length; i++) {
            int newX = curX + X_Dir[i]; // for finding the new direction
            int newY = curY + Y_Dir[i];
            //Very Imp newY<graph[0].length() && newX < graph.length
            if (newY >= 0 && newX >= 0 && newY < graph[0].length() && newX < graph.length && !visited[newX][newY] &&
                    graph[newX].charAt(newY) == str.charAt(0)) {
                boolean ans = dfsSolve(graph, visited, str.substring(1), newX, newY);
                if (ans) {
                    return true;
                }
            }

        }
        visited[curX][curY] = false;  //Very Imp for visiting next time
        return false;
    }

    /*****************************************************************************************************************/
    int solveColour(String[] board, int n, int m) {
        if (board.length == 0 || n == 0 || m == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[n][m];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (!visited[i][j]) {
                    boolean ans = dfSolveColour(board, i, j, startX, startY, visited);
                    if (ans) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean dfSolveColour(String[] board, int curX, int curY, int preX, int preY, boolean[][] visited) {
        visited[curX][curY] = true;
        int[] X_dir = {1, 0, 0, -1};
        int[] Y_dir = {0, 1, -1, 0};
        for (int i = 0; i < X_dir.length; i++) {
            int newX = curX + X_dir[i];
            int newY = curY + Y_dir[i];
            // Skip the previous cell (to avoid trivial cycle)
            if (newX == preX && newY == preY) {
                continue;
            }
            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length() && board[newX].charAt(newY) == board[curX].charAt(curY)) {
                // If the new cell is already visited, a cycle is detected
                if (visited[newX][newY]) {
                    return true;
                }
                // Recursively check for a cycle starting from the new cell
                if (dfSolveColour(board, newX, newY, curX, curY, visited)) {
                    return true;
                }
            }

        }
        // Unmark the cell (backtracking)
        visited[curX][curY] = false;
        return false;
    }

    /*****************************************************************************************************/
    public static int dfsCake(String[] edge, int n) {
        if (edge.length == 0 || n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[n][n];
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (edge[i].charAt(j) == '1')) {
                    count = dfsCakeHelper(edge, visited, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private static int dfsCakeHelper(String[] edge, boolean[][] visited, int curX, int curY) {
        visited[curX][curY] = true;
        int count = 0;
        int[] X_dir = {1, 0, 0, -1};
        int[] Y_dir = {0, 1, -1, 0};
        for (int k = 0; k < X_dir.length; k++) {
            int newX = curX + X_dir[k];
            int newY = curY + Y_dir[k];
            if (newY >= 0 && newX >= 0 && newX < edge.length && newY < edge[0].length() && edge[newX].charAt(newY) == '1'
                    && !visited[newX][newY]) {
                count += dfsCakeHelper(edge, visited, newX, newY);
            }
        }
        return count + 1; //Adding the last 1 for the 1st element
    }

    /****************************************************************************************************************/
    public static int Cycle_3(boolean[][] graph, int n) {
        if (graph.length == 0 || n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (graph[i][j] == true && graph[j][k] == true && graph[k][i] == true) {
                        count++;
                    }
                }
            }
        }

        return count;
    }


}
