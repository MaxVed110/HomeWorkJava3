//Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.
public class HorseBypass {
    final int N = 8;

    public boolean correctnessMove(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    public boolean knightsMove(int x, int y, int movei, int[] movex, int[] movey, int[][] board) {
        int k, next_movex, next_movey;
        if (movei == N * N) {
            return true;
        }

        for (k = 0; k < N; k++) {
            next_movex = x + movex[k];
            next_movey = y + movey[k];
            if (correctnessMove(next_movex, next_movey, board)) {
                board[next_movex][next_movey] = movei;
                if (knightsMove(next_movex, next_movey, movei + 1, movex, movey, board)) {
                    return true;
                } else {
                    board[next_movex][next_movey] = -1;
                }
            }
        }
        return false;
    }

    public void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] / 10 == 0) {
                    System.out.print(" " + board[i][j] + "  ");
                } else {
                    System.out.print(" " + board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean startMove() {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        board[0][0] = 0;

        if (!knightsMove(0, 0, 1, xMove, yMove, board)) {
            System.out.println("Ходов нет");
        } else {
            printBoard(board);
        }
        return true;
    }

    public static void main(String[] args) {
        HorseBypass board = new HorseBypass();
        board.startMove();
    }
}
