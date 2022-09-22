public class BS2d {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 3, 38 },
                { 44, 52, 44 },
                { 57, 600, 69 }
        };
        int key = 44;
        Pair result = binarySearch(matrix, key);
        if (result != null) {
            result.print();
        }
    }

    private static Pair binarySearch(int[][] matrix, int key) {
        Pair ans = new Pair(-1, -1);
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int element = matrix[i][j];
            if (element > key) {
                j--;
            } else if (element < key) {
                i++;
            } else {
                ans = new Pair(i, j);
                // check back
                j--;
            }
        }
        return ans;
    }
}

class Pair {
    int n, m;

    Pair(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void print() {
        System.out.println(this.n + " " + this.m);
    }
}