package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != 0 && (monoHorizontal(board, i) || monoVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int[] ints : board) {
            if (ints[column] == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
