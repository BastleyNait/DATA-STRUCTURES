public class BPlusTree {
    private static final int MIN_KEYS = 2; // Mínimo de claves en un nodo
    private static final int MAX_KEYS = 4; // Máximo de claves en un nodo

    private BPlusNode root;

    // Constructor de BPlusTree
    public BPlusTree() {
        root = new BPlusNode();
    }

    public void printTree() {
    if (root != null) {
        printTreeRecursive(root, 0);
    }
}

private void printTreeRecursive(BPlusNode node, int level) {
    if (node == null) {
        return;
    }

    for (int i = 0; i < node.keys.size(); i++) {
        if (!node.isLeaf) {
            printTreeRecursive(node.children.get(i), level + 1);
        }
        printNodeInfo(node.keys.get(i), level);
    }

    // Imprimir el último hijo (si existe) de un nodo no hoja
    if (!node.isLeaf) {
        printTreeRecursive(node.children.get(node.keys.size()), level + 1);
    }
}

private void printNodeInfo(int key, int level) {
    StringBuilder indent = new StringBuilder();
    for (int i = 0; i < level; i++) {
        indent.append("  "); // Dos espacios por nivel para indentación
    }
    System.out.println(indent.toString() + key);
}

    // Método para insertar una nueva clave en el árbol
    public void insert(int key) {
        BPlusNode leafNode = findLeafNode(key);
        leafNode.insertKey(key);
        leafNode.balanceTree();
    }

    // Método auxiliar para encontrar el nodo hoja donde debe insertarse la clave
    private BPlusNode findLeafNode(int key) {
        BPlusNode currentNode = root;
        while (!currentNode.isLeaf) {
            int index = 0;
            while (index < currentNode.keys.size() && key >= currentNode.keys.get(index)) {
                index++;
            }
            currentNode = currentNode.children.get(index);
        }
        return currentNode;
    }

    // Método para buscar una clave en el árbol
    public boolean search(int key) {
        BPlusNode currentNode = root;
        while (!currentNode.isLeaf) {
            int index = 0;
            while (index < currentNode.keys.size() && key >= currentNode.keys.get(index)) {
                index++;
            }
            currentNode = currentNode.children.get(index);
        }

        // Buscar la clave en el nodo hoja actual
        int index = 0;
        while (index < currentNode.keys.size() && key > currentNode.keys.get(index)) {
            index++;
        }

        return index < currentNode.keys.size() && currentNode.keys.get(index) == key;

    }
}
