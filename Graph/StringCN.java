import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class StringCN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        String[] Graph = new String[input[0]];

        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] Graph = takeInput();
        System.out.println(solve(Graph, Graph.length, Graph[0].length()));

    }

    public static int solve(String[] Graph, int N, int M) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i].charAt(j) == 'C') {
                    boolean[][] visited = new boolean[N][M];
                    visited[i][j] = true;
                    boolean ans = dfs(0, Graph, N, M, i, j, visited);
                    if (ans)
                        return 1;
                }
            }
        }
        return 0;
    }

    private static boolean dfs(int targetPtr, String[] graph, int n, int m, int row, int col,
            boolean[][] visited) {
            
        if (targetPtr >= "CODINGNINJA".length() - 1)
            return true;
        
        if ("CODINGNINJA".charAt(targetPtr) != graph[row].charAt(col))
            return false;
        
        visited[row][col] = true;
        boolean result = false;
        for (int i = -1; i < 2; i++) {
            int nrow = row + i;
            if (nrow < 0 || nrow >= n)
                continue;
            for (int j = -1; j < 2; j++) {
                int ncol = col + j;
                if (ncol < 0 || ncol >= m)
                    continue;
                if (!visited[nrow][ncol])
                    result = result || dfs(targetPtr + 1, graph, n, m, nrow, ncol, visited);
            }
        }
        visited[row][col] = false;
        return result;
    }

    private static int findStr(String target, int targetPtr, String[] graph, int n, int m, int i, int j,
            boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int x = temp.first;
            int y = temp.second;

            int c = 0;
            int t = targetPtr;

            for (int di = -1; di <= 1; di++) {
                int a = x + di;
                if (a < 0 || a >= n)
                    continue;
                for (int dj = -1; dj <= 1; dj++) {
                    int b = y + dj;
                    if (b < 0 || b >= m)
                        continue;
                    if (!visited[a][b] && graph[a].charAt(b) == target.charAt(targetPtr)) {
                        q.add(new Pair(a, b));
                        visited[a][b] = true;
                        c++;
                        targetPtr++;
                        break;
                    }
                }

            }
            if (targetPtr == t)
                return targetPtr;
        }
        return targetPtr;
    }

}