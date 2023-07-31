import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {
    private NodoHuff root;

    private final String text;
    private Map<Character, Integer> charFreq;
    private final Map<Character, String> huffmanCod;
    public HuffmanTree(String text) {
        this.text = text;
        fillCharFreqMap();
        this.huffmanCod = new HashMap<>();
    }

    public void fillCharFreqMap() {
        charFreq = new HashMap<>();
        for (char caracter : text.toCharArray()) {
            Integer integer = charFreq.get(caracter);
            charFreq.put(caracter, integer != null ? integer + 1 : 1);
        }
    }

    public NodoHuff getRoot() {
        return root;
    }

    public String encode() {
        Queue<NodoHuff> cola = new PriorityQueue<>();
        charFreq.forEach((caracter, freq) -> cola.add(new Leaf(caracter, freq)));
        while (cola.size() > 1) {
            cola.add(new NodoHuff(cola.poll(), cola.poll()));
        }
        generateHuffmanCodes(root = cola.poll(), "");
        return getEncodeText();
    }

    private void generateHuffmanCodes(NodoHuff nodoHuff, String code) {
        if (nodoHuff instanceof Leaf) {
            huffmanCod.put(((Leaf) nodoHuff).getCaracter(), code);
            return;
        }
        // si nos vamos por la izquierda concatenamos con 0
        generateHuffmanCodes(nodoHuff.getLeft(), code.concat("0"));
        // si nos vamos por la derecha concatenamos con 1
        generateHuffmanCodes(nodoHuff.getRight(), code.concat("1"));
        updateHeight(nodoHuff);
    }

    private String getEncodeText() {
        StringBuilder sb = new StringBuilder();
        for (char caracter : text.toCharArray()) {
            sb.append(huffmanCod.get(caracter));
        }
        return sb.toString();
    }

    public String decode(String encodeText) {
        StringBuilder sb = new StringBuilder();
        NodoHuff current = root;
        for (char caracter : encodeText.toCharArray()) {
            current = caracter == '0' ? current.getLeft() : current.getRight();
            if (current instanceof Leaf) {
                sb.append(((Leaf) current).getCaracter());
                current = root;
            }
        }
        return sb.toString();
    }
    public void updateHeight(NodoHuff current) {
        int maxHeight = Math.max(
                height(current.getLeft()),
                height(current.getRight())
        );
        current.setHeight(maxHeight + 1);
    }

    public int height(NodoHuff nodoHuff) {
        return (nodoHuff != null) ? nodoHuff.getHeight() : 0;
    }

    // metodo para imprimir el los caracteres con sus respectivos codigos huffman
    public void printCodes () {
        huffmanCod.forEach((caracter, freq) -> System.out.println(caracter + ": " + freq)) ;
    }
}
