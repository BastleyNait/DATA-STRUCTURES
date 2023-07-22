public class test {
    public static void main(String[] args) {
        Trie<Character> miTrie = new Trie<>();
        miTrie.insert("and");
        miTrie.insert("ant");
        miTrie.insert("antiguo");
        miTrie.insert("antecesor");
        miTrie.insert("anden");
        System.out.println(miTrie.numDePalabras());
        miTrie.search("and");
        miTrie.search("pocor");
        miTrie.search("an");
    }
}
