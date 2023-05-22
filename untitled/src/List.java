public abstract class List<T> {
    private Node<T> root; // Referencia al nodo inicial de la lista

    public List() {
        this.root = null; // Inicializa la referencia al nodo inicial como null al crear la lista
    }

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean contains(Object o);

    public abstract boolean add(T element);

    public abstract boolean remove(Object o);

    // Resto de métodos de la lista...
}
