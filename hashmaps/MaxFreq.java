package hashmaps;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaxFreq {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int[] arr = {3,2,3,2};

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int mx = -1, ans = -1;
        for (int key : map.keySet()) {
            int t = map.get(key);
            if (t > mx) {
                mx = t;
                ans = key;
            }
        }
        System.out.println(ans);
    }
}
