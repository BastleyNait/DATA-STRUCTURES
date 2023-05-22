public class MyList<T> {
    Node<T> root; // referencia al nodo inicial
    private int size; // tamaño de la lista

    // Constructor
    public MyList() {
        root = null;
        size = 0;
    }

    // Obtener la longitud de la lista
    public int getSize() {
        return size;
    }

    // Verificar si la lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Imprimir la lista
    public void printList() {
        Node<T> current = root;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    // Añadir un elemento al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node<T> current = root;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        size++;
    }

    // Obtener el elemento en un índice específico
    public T get(int index) {
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current.getData();
    }

    // Eliminar el elemento en un índice específico
    public void remove(int index) {
        if (index == 0) {
            root = root.getNextNode();
        } else {
            Node<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextNode();
            }
            current.setNextNode(current.getNextNode().getNextNode());
        }
        size--;
    }
}
