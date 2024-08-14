public class N_QueensProblem {
    public static void placeQueens(char board[][], int row) {
        if (row == board.length) {
            printQueen(board);
            count++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1);
                board[row][col] = 'x';
            }
        }
    }

    public static boolean placeQueensIsSolutionTheir(char board[][], int row) {
        if (row == board.length) {
            return true;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (placeQueensIsSolutionTheir(board, row + 1)) {
                    return true;
                }
                board[row][col] = 'x';
            }
        }
        return false;
    }

    static int count = 0;

    private static boolean isSafe(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        //We are checking up only because we did not place the bottom in the chess borad

        //Check Vertical up
        /*In this the col is same but the row is decreasing*/
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //Check the Vertical up diagonal left
        int vrl = row - 1; //vrr vertical row left
        int vcl = col - 1; //vcr vetical column left
        while (vrl >= 0 && vcl >= 0) {
            if (board[vrl][vcl] == 'Q') {
                return false;
            }
            vrl--;
            vcl--;
        }


        //Check the Vertical up diagonal right
        int vcr = col + 1; //vcr vetical column right
        int vrr = row - 1; //vrr vertical row right
        while (vcr < board[0].length && vrr >= 0) {
            if (board[vrr][vcr] == 'Q') {
                return false;
            }
            vcr++;
            vrr--;
        }
        return true;

    }

    private static void printQueen(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("---------chess board---------");
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = 'x';
            }
        }
        placeQueens(board, 0);
        System.out.println("The total number of queens ways to palce " + count);
        /*Why static because if we pass in the recursion the its increase every time because
         * recursion is pass by value so we have to need the static count */
        boolean ans = placeQueensIsSolutionTheir(board, 0);
        if (ans){
        System.out.println("Their is Possible solution? Yes");
        }
        else{
            System.out.println("Their is Possible solution? No");
        }
    }
}
