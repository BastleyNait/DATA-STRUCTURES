import java.util.Arrays;

public class NodeTrie<T> {
    private NodeTrie<T>[] children = new NodeTrie[Trie.ALPHABET_SIZE];

    private int[] repeticiones = new int[Trie.ALPHABET_SIZE];

    private boolean isEndOfWord;
    public int[] getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int[] repeticiones) {
        this.repeticiones = repeticiones;
    }

    public NodeTrie() {
        this.isEndOfWord = false;
        Arrays.fill(this.children, null);
    }


    public NodeTrie<T>[] getChildren() {
        return children;
    }

    public void setChildren(NodeTrie<T>[] children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
