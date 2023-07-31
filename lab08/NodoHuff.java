public class Nodo implements Comparable<Nodo>{
    private final int frequency;

    private int height = 1;

    public void setData(String data) {
        this.data = data;
    }

    private String data = "";
    private Nodo left;

    private Nodo right;

    public Nodo(int freq) {
        this.frequency = freq;
    }
    public Nodo (Nodo left, Nodo right) {
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

    public Nodo getRight() {
        return right;
    }

    public Nodo getLeft() {
        return left;
    }


    // ya que este nodo no almacena directamente caracteres tenemos que crear una clase
    // hija, porque solo las hojas son las que almacenan caracteres
    @Override
    public int compareTo(Nodo nodo) {
        return Integer.compare(frequency, nodo.getFrequency());
    }

    public int getFrecuency() {
        return frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}