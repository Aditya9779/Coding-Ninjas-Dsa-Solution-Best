public class N_Queens_Permutations {

    public static void placeQueens(char board[][], int row) {
        if (row == board.length) {
            printQueens(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row][i] = 'Q';
            placeQueens(board, row + 1); //Recursive call
            board[row][i] = 'X';  //BackTrack
        }
    }

    private static void printQueens(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*-------*");
    }

    public static void main(String[] args) {
        char[][] arr = new char[2][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'X';
            }
        }
        placeQueens(arr, 0);
    }
}
