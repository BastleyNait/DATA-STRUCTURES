public class Hoja extends Nodo{
    private final char caracter;

    private String data;
    public char getCaracter() {
        return caracter;
    }
    public Hoja(char caracter, int freq) {
        super(freq);
        this.caracter = caracter;
        this.data = this.caracter + " " + this.getFrequency();
    }
    public String getData() {
        return data;
    }
}
