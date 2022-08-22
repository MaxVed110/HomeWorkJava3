//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class EightQueens {
    final int queens = 8;

    public void printBoard(int[][] board) {
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkQueens(int[][] board, int line, int columns) {
        int i = 0;
        int j = 0;
        for (i = 0; i < columns; i++) {
            if (board[line][i] == 1) {
                return false;
            }
        }
        for (i = line, j = columns; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = line, j = columns; i < queens && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean solveQueens(int[][] board, int columns) {
        if (columns >= queens) {
            return true;
        }
        for (int i = 0; i < queens; i++) {
            if (checkQueens(board, i, columns)) {
                board[i][columns] = 1;
                if (solveQueens(board, columns + 1) == true) {
                    return true;
                }
                board[i][columns] = 0;
            }
        }
        return false;
    }

    public boolean startCheckQueens() {
        int[][] board = new int[8][8];
        if (solveQueens(board, 0) == false) {
            System.out.println("В данной расстановке комбинаций нет");
            return false;
        }
        printBoard(board);
        return true;
    }

    public static void main(String[] args) {
        EightQueens board = new EightQueens();
        board.startCheckQueens();
    }
}
