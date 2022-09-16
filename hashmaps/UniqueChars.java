package hashmaps;

import java.util.HashSet;

public class UniqueChars {
    public static void main(String[] args) {
        String s = "ababacd";
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            } else {
                System.out.print(c);
                set.add(c);
            }
        }
    }
}
