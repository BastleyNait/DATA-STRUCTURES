public class NodoHuff implements Comparable<NodoHuff>{
    private final int frequency;

    private int height = 1;

    public void setData(String data) {
        this.data = data;
    }

    private String data = "";
    private NodoHuff left;

    private NodoHuff right;

    public NodoHuff(int freq) {
        this.frequency = freq;
    }
    public NodoHuff(NodoHuff left, NodoHuff right) {
        this.frequency = left.getFrecuency() + right.getFrecuency();
        this.left = left;
        this.right = right;
        this.data = String.valueOf(frequency);

    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getData() {
        return data;
    }

    public NodoHuff getRight() {
        return right;
    }

    public NodoHuff getLeft() {
        return left;
    }


    // ya que este nodo no almacena directamente caracteres tenemos que crear una clase
    // hija, porque solo las hojas son las que almacenan caracteres
    @Override
    public int compareTo(NodoHuff nodoHuff) {
        return Integer.compare(frequency, nodoHuff.getFrequency());
    }

    public int getFrecuency() {
        return frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}