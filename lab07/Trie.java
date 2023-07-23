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
            //comprobacion para solo agregar las 27 palabras del alfabeto
            if ((key.charAt(i) > 96 && key.charAt(i) < 123) || (key.charAt(i) == 164) ) {
                if (aux.getChildren()[key.charAt(i) - 97] == null) {
                    aux.getChildren()[key.charAt(i) - 97] = new NodeTrie<>();
                }
                aux = aux.getChildren()[key.charAt(i) - 97];
            }
        }
        if (aux.isEndOfWord()){
            //System.out.println("la palabra ya se encuentra en el arbol");
            aux.getRepeticiones()[key.charAt(key.length() - 1) - 97]++;
        } else {
            aux.setEndOfWord(true);
            aux.getRepeticiones()[key.charAt(key.length() - 1) - 97]++;
            contPala++;
        }
        return false;
    }

    public int search(String key) {
        NodeTrie<T> aux = this.root;
        int cont = 0;
        for (int i = 0; i < key.length(); i++) {
            if (aux.getChildren()[key.charAt(i) - 97] == null) {
                //System.out.println("No se encontro la palabra");
                return 0;
            }
            else {
                aux = aux.getChildren()[key.charAt(i) - 97];
                if (aux.isEndOfWord()) {
                    int repe = aux.getRepeticiones()[key.charAt(i) - 97];
                    return repe;
                    //System.out.println("la palabra si se encuentra en el arbol");
                    //return true;
                }
            }
        }
        //System.out.println("No se encontro la palabra");
        return 0;
    }

    public int numDePalabras() {
        return this.contPala;
    }
}
