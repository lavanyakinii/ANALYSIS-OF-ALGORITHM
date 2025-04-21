public class NQueen {

    static int N = 4; 

    static void printBoard(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    static boolean solveNQueens(char[][] board, int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';

                if (solveNQueens(board, col + 1))
                    return true;

                board[i][col] = '.'; // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = '.';

        if (solveNQueens(board, 0))
            printBoard(board);
        else
            System.out.println("No solution found.");
    }
}
