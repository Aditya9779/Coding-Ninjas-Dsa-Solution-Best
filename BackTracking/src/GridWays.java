public class GridWays {
    public static int waysCount(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        return waysCountHelper(board, 0, 0);
    }

    private static int waysCountHelper(int[][] board, int i, int j) {
        int cols = board[0].length;
        int rows = board.length;
        if (i == rows - 1 && j == cols - 1) {
            return 1;
        }
        if (i >= rows || j >= cols) {
            return 0;
        }
        int right = waysCountHelper(board, i , j+1);
        int bottom = waysCountHelper(board, i+1, j );
        return right + bottom;
    }

    public static void main(String[] args) {
        int arr[][] = new int[4][4];
       int ans= waysCount(arr);
        System.out.println("The total ways to reach the end is : " +ans);

    }
}
