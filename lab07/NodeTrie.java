import java.util.Arrays;

public class NodeTrie<T> {
    public NodeTrie<T>[] getChildren() {
        return children;
    }

    public void setChildren(NodeTrie<T>[] children) {
        this.children = children;
    }

    private NodeTrie<T>[] children = new NodeTrie[Trie.ALPHABET_SIZE];

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    private boolean isEndOfWord;

    public NodeTrie() {
        this.isEndOfWord = false;
        Arrays.fill(this.children, null);
    }
}
