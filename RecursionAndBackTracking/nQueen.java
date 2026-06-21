package RecursionAndBackTracking;

public class nQueen {
    public static void main(String[] args) {
        int n = 4; // Size of the chessboard
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        if (placeQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean placeQueens(char[][] board, int row) {
        if (row == board.length) {
            return true;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (placeQueens(board, row + 1)) {
                    return true;
                }
                board[row][col] = '.'; // Backtrack
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check this column on upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }
}
