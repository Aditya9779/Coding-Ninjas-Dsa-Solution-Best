public class RatinMaze {
//This was correct but not getting the backtrack the solution we have to find that solution
   /* public static boolean ratInAMaze(int maze[][]) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        return helperratInAMaze(maze, 0, 0);
    }

    private static boolean helperratInAMaze(int[][] maze, int i, int j) {
        int rows = maze.length;
        int cols = maze[0].length;
        if (i == rows - 1 && j == cols - 1 && maze[rows - 1][cols - 1] == 1) {
            return true;
        }
        if (i >= rows || j >= cols) {
            return false;
        }

        boolean rightAns = helperratInAMaze(maze, i + 1, j);
        boolean leftAns = helperratInAMaze(maze, i, j + 1);

        return (rightAns || leftAns) && maze[i][j] == 1;
    }*/

    public static boolean ratInAMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        //We have to take the path for the tracking that we have vistied the path in the
        // some other steps
        return solveMaze(maze, 0, 0, path);
    }

    private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
        // Check if the current cell is out of bounds, a wall, or already part of the path
        if (i < 0 || i >= maze.length || j < 0 || j >= maze.length || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        // Mark the current cell as part of the path
        path[i][j] = 1;

        // Check if the current cell is the destination
        if (i == maze.length - 1 && j == maze.length - 1) {
            return true;
        }

        // Try moving in all four possible directions
        if (solveMaze(maze, i - 1, j, path)) { // Move up
            return true;
        }

        if (solveMaze(maze, i, j + 1, path)) { // Move right
            return true;
        }

        if (solveMaze(maze, i + 1, j, path)) { // Move down
            return true;
        }

        if (solveMaze(maze, i, j - 1, path)) { // Move left
            return true;
        }

        // Unmark the current cell for backtracking
        path[i][j] = 0;  //To much important
        return false;
    }


}
