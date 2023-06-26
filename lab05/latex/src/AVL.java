import myExceptions.ExceptionNoFound;

public class AVL<T extends Comparable<T>> {
    private Nodo<T> root;

    public AVL() {
        this.root = null;
    }

    public Nodo<T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    // Insertar un elemento en el árbol AVL
    public void insert(T x) throws ExceptionNoFound {
        this.root = insert(x, this.root);
    }

    private Nodo<T> insert(T x, Nodo<T> current) {
        if (current == null) {
            current = new Nodo<>(x);
        } else {
            int bool = current.getData().compareTo(x);
            if (bool <= 0)
                current.setRight(insert(x, current.getRight()));
            else
                current.setLeft(insert(x, current.getLeft()));
        }
        updateHeight(current);
        return applyRotation(current);
    }

    // Eliminar un elemento del árbol AVL
    public void remove(T x) throws ExceptionNoFound {
        this.root = remove(x, this.root);
    }

    private Nodo<T> remove(T x, Nodo<T> current) throws ExceptionNoFound {
        if (current == null)
            throw new ExceptionNoFound("No se encontró el elemento");

        int bool = current.getData().compareTo(x);
        if (bool < 0)
            current.setRight(remove(x, current.getRight()));
        else if (bool > 0)
            current.setLeft(remove(x, current.getLeft()));
        else {
            // si tiene un hijo o es hoja
            if (current.getLeft() == null)
                return current.getRight();
            else if (current.getRight() == null)
                return current.getLeft();
            // dos hijos
            current.setData(getMin(current.getRight()));
            current.setRight(remove(current.getData(), current.getRight()));
        }
        updateHeight(current);
        return applyRotation(current);
    }

    // Buscar un elemento en el árbol AVL
    public T search(T x) throws ExceptionNoFound {
        Nodo<T> aux = search(x, this.root);
        if (aux == null) {
            throw new ExceptionNoFound("No se encontró el elemento");
        }
        return aux.getData();
    }
//was
    public Nodo<T> searchNode(T x) throws ExceptionNoFound {
        Nodo<T> aux = search(x, this.root);
        if (aux == null) {
            throw new ExceptionNoFound("No se encontró el elemento");
        }
        return aux;
    }

    private Nodo<T> search(T x, Nodo<T> current) {
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

    // Obtener el elemento mínimo del árbol AVL
    private T getMin(Nodo<T> node) {
        T minKey = node.getData();
        while (node.getLeft() != null) {
            minKey = node.getLeft().getData();
            node = node.getLeft();
        }
        return minKey;
    }

    public T getMin() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("El árbol está vacío");
        Nodo<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    // Obtener el elemento máximo del árbol AVL
    public T getMax() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("El árbol está vacío");
        Nodo<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    // Obtener el padre de un elemento en el árbol AVL
    public T parent(T x) throws ExceptionNoFound {
        if (findParent(x, this.root) == null)
            throw new ExceptionNoFound("El nodo no tiene padre");
        return findParent(x, this.root).getData();
    }

    private Nodo<T> findParent(T x, Nodo<T> current) {
        if (current == null || current.getData().equals(x))
            return null;
        /*
         * comparamos si el nodo izq o der del nodo actual es igual al dato que le
         * pasamos
         */
        if (current.getLeft() != null && current.getLeft().getData().equals(x) || current.getRight() != null && current.getRight().getData().equals(x))
            return current;
        /*
         * Si no es así volvemos a llamar a la función hasta que encontremos
         */
        int bool = x.compareTo(current.getData());
        if (bool < 0)
            return findParent(x, current.getLeft());
        else
            return findParent(x, current.getRight());
    }

    // Recorrido inorden del árbol AVL
    public void inOrden() {
        if (isEmpty())
            System.out.println("El árbol está vacío");
        else
            inOrden(this.root);
    }

    private void inOrden(Nodo<T> current) {
        if (current.getLeft() != null)
            inOrden(current.getLeft());
        System.out.println(current);
        if (current.getRight() != null)
            inOrden(current.getRight());
    }

    // Actualizar la altura de un nodo en el árbol AVL
    public void updateHeight(Nodo<T> current) {
        int maxHeight = Math.max(
                height(current.getLeft()),
                height(current.getRight())
        );
        current.setHeight(maxHeight + 1);
    }

    // Obtener la altura de un nodo en el árbol AVL
    public int height(Nodo<T> nodo) {
        return (nodo != null) ? nodo.getHeight() : 0;
    }

    // Aplicar rotación según el balance del nodo en el árbol AVL
    public Nodo<T> applyRotation(Nodo<T> current) {
        int balance = balance(current);
        // Izquierda pesada
        if (balance > 1) {
            if (balance(current.getLeft()) < 0) {
                current.setLeft(rotateLeft(current.getLeft()));
            }
            return rotateRight(current);
        }
        // Derecha pesada
        if (balance < -1) {
            if (balance(current.getRight()) > 0) {
                current.setRight(rotateRight(current.getRight()));
            }
            return rotateLeft(current);
        }
        return current;
    }

    // Realizar rotación hacia la derecha
    private Nodo<T> rotateRight(Nodo<T> nodo) {
        // Para esto tenemos que guardar la información de los siguientes nodos:
        // el nodo izquierdo:
        Nodo<T> leftNode = nodo.getLeft();
        // el nodo derecho del nodo izquierdo
        Nodo<T> centralNode = leftNode.getRight();
        leftNode.setRight(nodo);
        nodo.setLeft(centralNode);
        updateHeight(nodo);
        updateHeight(leftNode);
        return leftNode;
    }

    // Realizar rotación hacia la izquierda
    private Nodo<T> rotateLeft(Nodo<T> nodo) {
        // Para esto tenemos que guardar la información de los siguientes nodos:
        // el nodo derecho:
        Nodo<T> rightNode = nodo.getRight();
        // el nodo izquierdo del nodo derecho
        Nodo<T> centralNode = rightNode.getLeft();
        rightNode.setLeft(nodo);
        nodo.setRight(centralNode);
        updateHeight(nodo);
        updateHeight(rightNode);
        return rightNode;
    }

    // Calcular el balance de un nodo en el árbol AVL
    public int balance(Nodo<T> nodo) {
        return (nodo != null)
                ? height(nodo.getLeft()) - height(nodo.getRight())
                : 0;
    }
}
