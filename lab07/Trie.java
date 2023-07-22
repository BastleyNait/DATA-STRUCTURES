public class Trie<T> {
    static final int ALPHABET_SIZE = 27;
    private NodeTrie<T> root = new NodeTrie<>();
    private int contPala = 0;


    public boolean insert(String key) {
        /*
        if (this.root.getChildren()[0] != null)
            this.root.getChildren()[key.charAt(0) - 97] = new NodeTrie<>();
        */
        NodeTrie<T> aux = this.root;
        for (int i = 0; i < key.length(); i++) {
            if (aux.getChildren()[key.charAt(i) - 97] == null) {
                aux.getChildren()[key.charAt(i) - 97] = new NodeTrie<>();
            }
            aux = aux.getChildren()[key.charAt(i) - 97];
        }
        if (aux.isEndOfWord()){
            System.out.println("la palabra ya se encuentra en el arbol");
        } else {
            aux.setEndOfWord(true);
            contPala++;
        }
        return false;
    }

    public int numDePalabras() {
        return this.contPala;
    }
}
