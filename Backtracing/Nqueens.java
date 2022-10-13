package Backtracing;

public class Nqueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        findQueenPos(board, n, 0, 0, n);

    }

    private static void findQueenPos(int[][] board, int n, int r, int c, int count) {
        if (r == c && c == n) {
            if (count == 0) {
                print(board);
            }
            return;
        }
        if (c == n) {
            if (n - count != r - 1) {
                return;
            }
        }
        if (r == n) {
            if (count == 0)
                print(board);
            System.out.println("-------------");
            return;
        }
        if (!doesAttack(board, r, c)) {
            board[r][c] = 1;
            findQueenPos(board, n, r + 1, 0, count - 1);
            board[r][c] = 0;
            findQueenPos(board, n, r, c + 1, count);
        } else {
            findQueenPos(board, n, r, c + 1, count);
        }

    }

    private static void print(int[][] board) {
        for (int[] is : board) {
            for (int t : is) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    private static boolean doesAttack(int[][] finalPos, int i, int j) {
        for (int a = 0; a < finalPos.length; a++) {
            for (int b = 0; b < finalPos[0].length; b++) {
                if (finalPos[a][b] == 1) {
                    if (i == a || j == b) {
                        return true;
                    } else if ((a - b) ==(i - j) || (a + b == i + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
