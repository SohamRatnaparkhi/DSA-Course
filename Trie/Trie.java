public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void add(String word) {
        TrieNode[] children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            int index = indexOf(current);
            if (children[index] == null) {
                children[index] = new TrieNode(current);
                if (i == word.length() - 1) {
                    children[index].isTerminal = true;
                }
            } 
                children = children[index].children;
            
        }
    }

    public boolean search(String word) {
        TrieNode[] children = root.children;
        TrieNode[] prevElementChildren = null;
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            index = indexOf(current);
            TrieNode element = children[index];
            if (element == null) {
                return false;
            } else {
                prevElementChildren = children;
                children = element.children;
            }
        }
        return prevElementChildren[index].isTerminal == true;
    }

    public void remove(String word) {
        
    }

    private int indexOf(char c) {
        int index = (int)c - 'a';
        return index;
    }
    
}
