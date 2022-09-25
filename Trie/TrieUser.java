public class TrieUser {
    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.add("do");
        dict.add("dot");
        dict.add("are");
        dict.add("as");
        boolean isPresent = dict.search("as");
        System.out.println(isPresent);
    }
}
