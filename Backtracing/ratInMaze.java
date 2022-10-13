package Backtracing;

import java.util.ArrayList;


public class ratInMaze {
    public static void main(String[] args) {
        int r = 3;
        int c = 3;
        int totalPaths = availblePaths(r, c);
        System.out.println(totalPaths);
        printAvailblePaths(r, c, "");
    }
    static ArrayList<ArrayList<Character>> perm = new ArrayList<>();

    private static int availblePaths(int r, int c) {
        if (r == 1) {
            return 1;
        }
        if (c == 1) {
            return 1;
        }

        int right = availblePaths(r - 1, c);
        int left = availblePaths(r, c - 1);

        return left + right;
    }

    private static void printAvailblePaths(int r, int c, String path) {
        if (r == 1) {
            for (int i = c; i > 1; i--) {
                path += "D ";
            }
            
            System.out.println(path);
            return;
        }
        if (c == 1) {
            for (int i = r; i > 1; i--) {
                path += "R ";
            }

            System.out.println(path);
            return;
        }
        printAvailblePaths(r - 1, c, path + "R ");
        printAvailblePaths(r, c - 1, path + "D ");
    }
}

