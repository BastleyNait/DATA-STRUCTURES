public class Node<T> {
    private T data;

    private Node<T> left;

    private Node<T> right;

    public Node (T data) {
        this(data,null,null);
    }
    public Node(T data, Node<T> left,Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
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
