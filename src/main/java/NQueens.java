package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        helpSolveNQueens(0, board, result);
        return result;
    }

    private void helpSolveNQueens(int row, int[][] board, List<List<String>> result) {
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 1;
            if (this.isPositionValid(row, j, board)) {
                if (row == board.length - 1) {
                    this.addSolution(board, result);
                } else {
                    this.helpSolveNQueens(row + 1, board, result);
                }
            }
            board[row][j] = 0;
        }
    }

    private void addSolution(int[][] board, List<List<String>> result) {
        List<String> newSolution = new ArrayList<>();
        for (int[] array : board) {
            StringBuilder row = new StringBuilder();
            for (int i : array) {
                row.append(i == 0 ? '.' : 'Q');
            }
            newSolution.add(row.toString());
        }
        result.add(newSolution);
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
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}
