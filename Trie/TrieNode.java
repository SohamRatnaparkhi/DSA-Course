public class TrieNode {

    boolean isTerminal;
    TrieNode[] children;
    char data;

    public TrieNode(char data) {
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.data = data;
    }
}