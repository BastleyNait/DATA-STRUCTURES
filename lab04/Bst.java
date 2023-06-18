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

    private T getMin(Node<T> node) {
        T minKey = node.getData();
        while (node.getLeft() != null) {
            minKey = node.getLeft().getData();
            node = node.getLeft();
        }
        return minKey;
    }

    public T getMin() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("el arbol esta vacio");
        Node<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    public T getMax() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("el arbol esta vacio");
        Node<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    public T parent(T x) throws ExceptionNoFound {
        if (findParent(x, this.root) == null)
            throw new ExceptionNoFound("El nodo no tiene padre");
        return findParent(x, this.root).getData();
    }
    private Node<T> findParent(T x, Node<T> current) {
        if (current == null || current.getData().equals(x))
            return null;
        /*
        * comparamos si el nodo izq o der del nodo actual es igual al dato que le
        * pasamos
         */
        if (current.getLeft() != null && current.getLeft().getData().equals(x) || current.getRight() != null && current.getRight().getData().equals(x))
            return current;
        /*
        * Si no es así volvemos a llamar a la funcion hasta que encontremos
         */
        int bool = x.compareTo(current.getData());
        if (bool < 0)
            return findParent(x, current.getLeft());
        else
            return findParent(x, current.getRight());
    }

    public void remove(T x) throws ExceptionNoFound {
        this.root = remove(x, this.root);
    }
    private Node<T> remove(T x, Node<T> current) throws ExceptionNoFound {
        if (current == null)
            throw new ExceptionNoFound("No se encontró el elemento");

        int bool = current.getData().compareTo(x);
        if (bool < 0)
            current.setRight(remove(x, current.getRight()));
        else if (bool > 0)
            current.setLeft(remove(x, current.getLeft()));
        else {
            if (current.getLeft() == null)
                return current.getRight();
            else if (current.getRight() == null)
                return current.getLeft();

            current.setData(getMin(current.getRight()));
            current.setRight(remove(current.getData(), current.getRight()));
        }

        return current;
    }


}