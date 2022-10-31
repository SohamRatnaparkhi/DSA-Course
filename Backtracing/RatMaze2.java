package Backtracing;

import java.util.Scanner;

// now top right left and bottom allowed
public class RatMaze2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        int n = maze.length;
        int path[][] = new int[n][n];
        System.out.println(ratInAMaze(maze, 0, 0, n - 1, path));
        ratPath(maze, 0, 0, n - 1, new int[n][n]);
    }

    public static boolean ratInAMaze(int maze[][], int r, int c, int n, int[][] path) {
        if (r == n && c == n) {
            return true;
        }
        if (r > n || c > n || r < 0 || c < 0) {
            return false;
        }
        if (maze[r][c] == 0) {
            return false;
        }
        if (path[r][c] == 1) {
            return false;
        }
        boolean right = false, left = false;
        boolean down = false, top = false;
        if (maze[r][c] == 1) {
            path[r][c] = 1;
        }

        top = ratInAMaze(maze, r, c - 1, n, path);
        right = ratInAMaze(maze, r + 1, c, n, path);
        down = ratInAMaze(maze, r, c + 1, n, path);
        left = ratInAMaze(maze, r - 1, c, n, path);

        return top || right || down || left;
    }

    public static void ratPath(int maze[][], int r, int c, int n, int[][] path) {

        if (r == n && c == n) {
            path[r][c] = 1;
            for (int[] row : path) {
                for (int i : row) {
                    System.out.print(i + " ");
                }
            }
            path[r][c] = 0;
            System.out.println();
            return;
        }
        if (r > n || c > n || r < 0 || c < 0) {
            return;
        }
        if (maze[r][c] == 0) {
            return;
        }
        if (path[r][c] == 1) {
            return;
        }

        if (maze[r][c] == 1) {
            path[r][c] = 1;
        }

        ratPath(maze, r, c - 1, n, path);
        ratPath(maze, r, c + 1, n, path);
        ratPath(maze, r - 1, c, n, path);
        ratPath(maze, r + 1, c, n, path);
        path[r][c] = 0;
    }
}
