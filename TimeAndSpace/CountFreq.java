/*package whatever //do not write package name here */
package TimeAndSpace;

import java.io.*;
import java.util.ArrayList;

class CountFreq {
    public static void main(String[] args)
    {
        String s1 = "GFG";
      	System.out.println("For " + s1);
        frequency(s1);
      
      	String s2 = "aaabccccffgfghc";
      	System.out.println("For " + s1);
      	frequency(s2);
      	
    }
    private static void frequency(String s)
    {
        ArrayList<CharOccur> occurences
            = new ArrayList<CharOccur>();
        // Creating ArrayList of objects of Charoccur class

        for (int i = 0; i < s.length(); i++) {
            /* Logic
             * If a pair of character and its occurence is
             * already present as object - increment the
             * occurence else create a new object of
             * character with its occurence set to 1
             */
            char c = s.charAt(i);
            int flag = 0;
            for (CharOccur o : occurences) {
                if (o.character == c) {
                    o.occurrenece += 1;
                    flag = 1;
                }
            }
            if (flag == 0) {
                CharOccur grp = new CharOccur(c, 1);
                occurences.add(grp);
            }
        }

        // Printing the character - occurences pair
        for (CharOccur o : occurences) {
            System.out.println(o.character + " "
                               + o.occurrenece);
        }
    }
}

// Creating a class CharOccur whose objects have 2
// properties - a character and its occurence
class CharOccur {
    char character;
    int occurrenece = 0;
    CharOccur(char character, int occurrenece)
    {
        this.character = character;
        this.occurrenece = occurrenece;
    }
}
// Contributed by Soham Ratnaparkhi