public class Node<T> {
    private T data; // Almacena el valor de datos del nodo
    private Node<T> nextNode; // Referencia al siguiente nodo en la lista

    // Constructor que recibe el valor de datos del nodo
    public Node(T value) {
        data = value;
        this.nextNode = null; // Inicialmente,
        // el nodo no tiene un
        // siguiente nodo, por lo que se establece como null
    }

    // Método para obtener el valor de datos del nodo
    public T getData() {
        return data;
    }

    // Método para establecer el valor de datos del nodo
    public void setData(T value) {
        this.data = value;
    }

    // Método para obtener la referencia al siguiente nodo
    public Node<T> getNextNode() {
        return nextNode;
    }

    // Método para establecer la referencia al siguiente nodo
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
