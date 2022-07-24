package Recursion;

class skipStr{
    public static void main(String[] args) {
        System.out.println(skip("abcdxyzfdkfjakxyz", "xyz"));
    }

    private static String skip(String s, String x) {
        if(s.length() == 0){
            return s;
        }
        if(s.length() >= x.length()){
            String currentPossible = s.substring(0, x.length());
            if(currentPossible.equals(x)){
                return skip(s.substring(x.length()), x);
            }
            else{
                return currentPossible.charAt(0) + skip(s.substring(1), x);
            }
        }
        else{
            return s;
        }
        // return null;
    }
}