import myExceptions.ExceptionNoFound;
public class Bst<T extends Comparable<T>> {
    private Node<T> root;

    public Bst() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T x) throws ExceptionNoFound {
        this.root = insert(x, this.root);
    }

    private Node<T> insert(T x, Node<T> current) throws ExceptionNoFound {
        Node<T> hoja = current;
        if (current == null) {
            hoja = new Node<>(x);
        } else {
            int bool = current.getData().compareTo(x);
            if (bool == 0)
                throw new ExceptionNoFound("Ya existe el elemento");
            if (bool < 0)
                hoja.setRight(insert(x, current.getRight()));
            else
                hoja.setLeft(insert(x, current.getLeft()));
        }
        return hoja;
    }

    public T search(T x) throws ExceptionNoFound {
        Node<T> aux = search(x, this.root);
        if (aux == null) {
            throw new ExceptionNoFound("No se encontró el elemento");
        }
        return aux.getData();
    }

    private Node<T> search(T x, Node<T> current) {
        if (current == null) {
            return null;
        } else {
            int bool = current.getData().compareTo(x);
            if (bool == 0)
                return current;
            if (bool < 0)
                return search(x, current.getRight());
            else
                return search(x, current.getLeft());
        }
    }
}