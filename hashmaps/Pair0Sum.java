package hashmaps;

import java.util.HashMap;

public class Pair0Sum {
    public static void main(String[] args) {
        int arr[] = {};
        HashMap<Integer, Integer> freq = new HashMap<>();
        int c = 0;
        for (int i : arr) {
            if (freq.containsKey(-i)) {
                c += freq.get(-i);
            }
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        System.out.println(c);
    }
}
