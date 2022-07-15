package RandomDSAQ;

// package kkdsa.recursion;

public class Solution 
{
    public static char kThCharaterOfDecryptedString(String s, int k) 
    {
        // Write your code here
        k -= 1;
        String rep = "";
        String repnum = "0";
        String sb = "";
        int strLen = 0;
        int l = 0;
        int i = 0, j = 0;
        while(j < s.length()){
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            
            while((int)jChar >= 97 && (int)jChar <= 122 && j < s.length()){
                rep += jChar;
                j++;
                if(j >= s.length()){
                    break;
                }
                jChar = s.charAt(j);
            }
            i = j;
            
            while((int)jChar > 48 && (int)jChar < 58 && j < s.length()){
                repnum += jChar;
                j++;
                if(j >= s.length()){
                    break;
                }
                jChar = s.charAt(j);
            }
            i = j;
            
            int repNum = Integer.parseInt(repnum);
            if(repNum == 0) repNum += 1;
            
            // System.out.println(rep + " " + repNum);
            strLen += repNum * rep.length();
            int x = k - strLen;
            
            for(int f = 0; f < repNum; f++){
                sb += rep;
            }
            rep = "";
            repnum = "0";
            if(k < sb.length()) break;
        }
       return sb.charAt(k); 
    }
    public static void main(String[] args) {
       System.out.println(kThCharaterOfDecryptedString("a2b3cd3", 8)); 
    }
}
