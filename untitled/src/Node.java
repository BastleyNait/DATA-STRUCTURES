public class Node<T> {
    private T data; // Propiedad para almacenar los datos de tipo T
    private Node<T> next; // Propiedad para enlazar al siguiente nodo

    public Node(T data) {
        this.data = data; // Inicializa la propiedad data con el valor proporcionado al crear el nodo
        this.next = null; // Inicializa el enlace next como null, ya que al crear el nodo no hay ningún nodo siguiente
    }
    public T getData() {
        return data; // Devuelve el valor almacenado en la propiedad data
    }

    public void setData(T data) {
        this.data = data; // Actualiza el valor almacenado en la propiedad data con el valor proporcionado
    }
}
