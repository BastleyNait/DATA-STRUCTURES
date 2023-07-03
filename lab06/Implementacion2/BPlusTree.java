public class BPlusTree {
    private static final int MIN_KEYS = 2; // Mínimo de claves en un nodo
    private static final int MAX_KEYS = 4; // Máximo de claves en un nodo

    private BPlusNode root;

    // Constructor de BPlusTree
    public BPlusTree() {
        root = new BPlusNode();
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

    public void delete(int key) {
        // Buscar el nodo hoja que contiene la clave a eliminar
        BPlusNode leafNode = findLeafNode(key);

        // Eliminar la clave del nodo hoja
        boolean keyDeleted = leafNode.deleteKey(key);

        // Reestructurar el árbol si es necesario
        if (keyDeleted && leafNode.keys.size() < MIN_KEYS) {
            // Verificar si el nodo hoja está desequilibrado
            if (leafNode != root) {
                // Si el nodo hoja no es la raíz, intentar redistribuir o fusionar
                BPlusNode siblingNode = getSiblingNode(leafNode);
                if (siblingNode != null && siblingNode.keys.size() > MIN_KEYS) {
                    redistributeNodes(leafNode, siblingNode);
                } else {
                    mergeNodes(leafNode, siblingNode);
                }
            } else if (root.keys.isEmpty()) {
                // Si la raíz se ha quedado vacía, eliminarla y asignar el primer hijo como nueva raíz
                root = leafNode.children.get(0);
            }
        }
    }
}
