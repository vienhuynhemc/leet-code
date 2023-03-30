import java.util.concurrent.atomic.AtomicInteger;

public class NQueensII {

    public int totalNQueens(int n) {
        AtomicInteger result = new AtomicInteger(0);
        this.helpSolveNQueens(0, new int[n][n], result);
        return result.get();
    }

    private void helpSolveNQueens(int row, int[][] board, AtomicInteger result) {
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 1;
            if (this.isPositionValid(row, j, board)) {
                if (row == board.length - 1) {
                    result.set(result.get() + 1);
                } else {
                    this.helpSolveNQueens(row + 1, board, result);
                }
            }
            board[row][j] = 0;
        }
    }

    private boolean isPositionValid(int i, int j, int[][] board) {
        return this.isPositionValidInRow(i, board)
                && this.isPositionValidInCol(j, board)
                && this.isPositionValidInMainCrossWay(i, j, board)
                && this.isPositionValidInSupportCrossWay(i, j, board);
    }

    private boolean isPositionValidInRow(int row, int[][] board) {
        int count = 0;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    private boolean isPositionValidInCol(int col, int[][] board) {
        int count = 0;
        for (int[] ints : board) {
            if (ints[col] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    private boolean isPositionValidInMainCrossWay(int i, int j, int[][] board) {
        int count = 0;
        if (board[i][j] == 1) {
            count++;
        }
        int a = i - 1;
        int b = j - 1;
        while (a > -1 && b > -1) {
            if (board[a][b] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            a--;
            b--;
        }
        a = i + 1;
        b = j + 1;
        while (a < board.length && b < board[a].length) {
            if (board[a][b] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            a++;
            b++;
        }
        return true;
    }

    private boolean isPositionValidInSupportCrossWay(int i, int j, int[][] board) {
        int count = 0;
        if (board[i][j] == 1) {
            count++;
        }
        int a = i - 1;
        int b = j + 1;
        while (a > -1 && b < board[a].length) {
            if (board[a][b] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            a--;
            b++;
        }
        a = i + 1;
        b = j - 1;
        while (a < board.length && b > -1) {
            if (board[a][b] == 1) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));
    }

}
