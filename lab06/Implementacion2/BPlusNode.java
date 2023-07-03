import java.util.*;
public class BPlusNode {
    private static final int MAX_KEYS = 4;
    private static final int MIN_KEYS = 2;
    // Lista de de claves que tendra un nodo
    // No los hago privados para no hacer un codigo tan extenso
    List<Integer> keys;
    // Lista de punteros a otros nodos
    List<BPlusNode> children;

    //Referencia al nodo padre
    BPlusNode parent;

    //false si es interno y true si es hoja

    boolean isLeaf;

    public BPlusNode(){
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
        parent = null;
        isLeaf = true;
    }

    // Método para dividir el nodo en dos
    public BPlusNode split() {
        // Creamos un nuevo nodo que será el nodo derecho después de la división
        BPlusNode rightNode = new BPlusNode();

        // Calculamos el índice donde se dividirá el nodo actual
        int midIndex = keys.size() / 2;

        // Movemos la mitad derecha de las claves y punteros al nuevo nodo
        rightNode.keys.addAll(keys.subList(midIndex, keys.size()));
        keys.subList(midIndex, keys.size()).clear();

        // Movemos los punteros si el nodo es interno
        if (!isLeaf) {
            rightNode.children.addAll(children.subList(midIndex, children.size()));
            children.subList(midIndex, children.size()).clear();
        }

        // Actualizamos el nodo padre para ambos nodos (si existe)
        if (parent != null) {
            rightNode.parent = parent;
            int insertIndex = parent.findInsertIndex(rightNode.keys.get(0));
            parent.children.add(insertIndex + 1, rightNode);
        }

        // Devolvemos el nuevo nodo derecho creado después de la división
        return rightNode;
    }

    // Método para encontrar la posición de inserción de una clave en el nodo
    int findInsertIndex(int key) {
        int insertIndex = 0;
        while (insertIndex < keys.size() && key > keys.get(insertIndex)) {
            insertIndex++;
        }
        return insertIndex;
    }

    public void mergeWith(BPlusNode rightNode) {
        // Movemos todas las claves y punteros del nodo derecho al nodo actual
        keys.addAll(rightNode.keys);
        children.addAll(rightNode.children);

        // Actualizamos el padre del nodo derecho para que apunte al nodo actual
        for (BPlusNode child : rightNode.children) {
            child.parent = this;
        }

        // Borramos la referencia del nodo derecho en el padre (ya no será necesario)
        if (parent != null) {
            parent.children.remove(rightNode);
        }
    }

    // Método para encontrar el índice del nodo vecino derecho
    public int findRightNeighborIndex() {
        if (parent == null) {
            return -1; // No hay nodo vecino derecho (el nodo actual es la raíz)
        }
        return parent.children.indexOf(this) + 1;
    }

    // Método para encontrar el índice del nodo vecino izquierdo
    public int findLeftNeighborIndex() {
        if (parent == null) {
            return -1; // No hay nodo vecino izquierdo (el nodo actual es la raíz)
        }
        return parent.children.indexOf(this) - 1;
    }
    // Metodo para obtener la clave central
    public int getCentralKey() {
        int midIndex = keys.size() / 2;
        return keys.get(midIndex);
    }

    public int findKeyPosition(int key) {
        int left = 0;
        int right = keys.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midKey = keys.get(mid);

            if (midKey == key) {
                return mid; // Encontramos la clave en la posición 'mid'
            } else if (midKey < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Si no encontramos la clave, devolvemos la posición donde debería estar
        return left;
    }

    public List<Integer> getAllKeys() {
        return this.keys;
    }

    // Método para imprimir el contenido del nodo y sus hijos
    public void printNode() {
        System.out.print("Keys: ");
        for (int key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        if (!isLeaf) {
            System.out.print("Children: ");
            for (BPlusNode child : children) {
                System.out.print(child.getCentralKey() + " ");
            }
            System.out.println();

            for (BPlusNode child : children) {
                child.printNode();
            }
        }
    }

    public void balanceTree() {
        if (keys.size() <= MAX_KEYS) {
            // El nodo está equilibrado, no es necesario hacer nada
            return;
        }

        if (parent == null) {
            // Si el nodo es la raíz y ha alcanzado el máximo de claves permitidas,
            // creamos un nuevo nodo como la nueva raíz y dividimos el nodo actual
            BPlusNode newRoot = new BPlusNode();
            newRoot.children.add(this);
            parent = newRoot;
            newRoot.split();
            return;
        }

        // Si el nodo está desequilibrado y no es la raíz, dividimos el nodo y
        // realizamos la inserción del nodo resultado en el padre
        parent.split();
    }

}