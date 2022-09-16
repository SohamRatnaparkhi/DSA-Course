package hashmaps;

import java.util.HashMap;

public class KDifference {
    public static void main(String[] args) {
        int arr[] = {4,4,4,4};
        int k = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int c = 0;
        for (int i : arr) {
            if (freq.containsKey(i - k)) {
                // System.out.println(i + " " + (i - k));
                c += freq.get(i - k);
            }
            else if (freq.containsKey(i + k)) {
                c += freq.get(i + k);
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
