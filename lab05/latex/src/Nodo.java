public class Nodo <T extends Comparable<T>> {
    private T data;

    private Nodo <T> left;

    private int height = 1;

    private Nodo <T> right;
    public Nodo(T data) {
        this(data,null,null);
    }

    public Nodo(T data, Nodo <T> left, Nodo <T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public Nodo <T> getLeft() {
        return this.left;
    }

    public void setLeft(Nodo <T> left) {
        this.left = left;
    }

    public Nodo <T> getRight() {
        return this.right;
    }

    public void setRight(Nodo <T> right) {
        this.right = right;
    }

    public String toString() {
        return this.data.toString();
    }

    //recorridos en profundity
    /*
     * Raiz
     * Izquierda
     * Derecha
     * */
    // pre-order Rid:  3 1 6 4 5 8 7 9
    // in-order iRd:   1 3 5 4 6 7 8 9
    // post-order idR: 1 5 4 7 9 8 6 3

    // busqueda binary/dichotomy

}
