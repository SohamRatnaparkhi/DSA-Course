import java.util.ArrayList;
import java.util.HashSet;

public class NonRepeatingSubstrings {
    public static void main(String[] args) {
        String s = "bcda";
        int ans = noOfSubstrings(s);
        System.out.println(ans);
    }

    private static int noOfSubstrings(String s) {
        int ans = 0;
        ArrayList<String> container = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> inner = new HashSet<>();
            String temp = "";
            temp += s.charAt(i);
            container.add(temp);
            inner.add(s.charAt((i)));
            for (int j = i + 1; j < s.length(); j++) {
                if (!inner.contains(s.charAt(j))) {
                    inner.add(s.charAt(j));
                    temp += s.charAt(j);
                    container.add(temp);
                } else {
                    continue;
                }
            }
        }
        // System.out.println(container);
        ans = container.size();
        return ans;
    }
}
