class TimeLog {
    public static void main(String[] args) {
        int n = 10;
        int[][] arr = { { 0, 3 }, { 2, 5 }, { 0, 9 }, { 1, 15 } };
        System.out.println(hardestWorker(n, arr));
    }

    public static int hardestWorker(int n, int[][] logs) {
        int ans = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int s = 0;
        for (int[] row : logs) {
            int id = row[0], e = row[1];
            int t = e - s;
            s = e;
            if (t >= max) {

                // System.out.println(max + " " + ans + " -- ");
                if (t == max)
                    ans = Math.min(id, ans);
                else
                    ans = id;
                // System.out.println(ans + " " + max);
                max = t;
            }
        }
        return ans;
    }
}