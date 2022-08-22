//Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.
public class HorseBypass {

    public boolean correctnessMove(int N, int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    public boolean knightsMove(int N, int x, int y, int move_i, int[][] move_x_y, int[][] board) {
        int k, next_move_x, next_move_y;
        if (move_i == N * N) {
            return true;
        }

        for (k = 0; k < 8; k++) {
            next_move_x = x + move_x_y[k][0];
            next_move_y = y + move_x_y[k][1];
            if (correctnessMove(N, next_move_x, next_move_y, board)) {
                board[next_move_x][next_move_y] = move_i;
                if (knightsMove(N, next_move_x, next_move_y, move_i + 1, move_x_y, board)) {
                    return true;
                } else {
                    board[next_move_x][next_move_y] = -1;
                }
            }
        }
        return false;
    }

    public void printBoard(int N, int[][] board) {
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

    public boolean startMove(int N, int start_x, int start_y) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        int x_y_Move[][] = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

        board[start_x][start_y] = 0;

        if (!knightsMove(N, start_x, start_y, 1, x_y_Move, board)) {
            System.out.println("Ходов нет");
        } else {
            printBoard(N, board);
        }
        return true;
    }

    public static void main(String[] args) {
        HorseBypass board = new HorseBypass();
        board.startMove(8, 0, 0);
    }
}
