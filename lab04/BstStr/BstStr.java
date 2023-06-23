package BstStr;

import myExceptions.ExceptionNoFound;
import org.graphstream.graph.Node;

public class BstStr {
    private Core root;
    public BstStr(){
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(String data) {
        this.root=insert(data, this.root);
    }

    private Core insert(String data, Core current) {
        int rp = 1;
        Core aux = new Core(data);
        Core node = current;
        if (current == null) {
            node = new Core(data);
        }
        else {
            if(node.getValue() < aux.getValue()) {
                current.setRight(insert(data,current.getRight()));
            }
            else if(node.getValue() > aux.getValue()) {
                current.setLeft(insert(data,current.getLeft()));

            }
            else {
                data = data + rp++;
                Core rep = new Core(data);
                current.setRight(rep);
            }
        }
        return node;
    }

    public String search(String data) {
        Core aux = search(data, this.root );
        if (aux == null ) {
            System.out.println("no se encontro el elemento");
        }
        return aux.getData();
    }

    private Core search(String data, Core current) {
        if (current.getData() == null) {
            return null;
        }
        else {
            if(current.getValue() < data.charAt(0)) {
                return search(data, current.getRight());
            }
            else if(current.getValue() > data.charAt(0)) {
                return search(data, current.getLeft());
            }
            else {
                return current;
            }
        }
    }
    public String getMin() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("el arbol esta vacio");
        Core current = this.root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    public String getMax() throws ExceptionNoFound {
        if (isEmpty())
            throw new ExceptionNoFound("el arbol esta vacio");
        Core current = this.root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    public String parent(String x) throws ExceptionNoFound {
        if (findParent(x, this.root) == null)
            throw new ExceptionNoFound("El nodo no tiene padre");
        return findParent(x, this.root).getData();
    }

    private Core findParent(String x, Core current) {
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
        if (current.getValue() > x.charAt(0))
            return findParent(x, current.getLeft());
        else
            return findParent(x, current.getRight());
    }

}
