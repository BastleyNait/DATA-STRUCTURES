import java.util.*;

public class BPlusTree {
    private static final int ORDER = 5; // Orden del árbol B+
    private Node root;

    BPlusTree() {
        root = new Node();
    }

    // Método para buscar un valor en el árbol B+
    public boolean search(int key) {
        return searchKey(root, key);
    }

    private boolean searchKey(Node node, int key) {
        if (node == null) {
            return false;
        }

        int index = findIndex(node.keys, key);

        if (index < node.keys.size() && node.keys.get(index) == key) {
            return true;
        } else if (node.isLeaf) {
            return false;
        } else {
            return searchKey(node.children.get(index), key);
        }
    }

    // Método para insertar un valor en el árbol B+
    public void insert(int key) {
        if (!search(key)) {
            if (root.keys.size() == ORDER) {
                Node newRoot = new Node();
                newRoot.children.add(root);
                splitChild(newRoot, 0);
                insertNonFull(newRoot, key);
                root = newRoot;
            } else {
                insertNonFull(root, key);
            }
        }
    }

    private void insertNonFull(Node node, int key) {
        int index = findIndex(node.keys, key);

        if (node.isLeaf) {
            node.keys.add(index, key);
        } else {
            Node child = node.children.get(index);
            if (child.keys.size() == ORDER) {
                splitChild(node, index);
                if (key > node.keys.get(index)) {
                    index++;
                }
            }
            insertNonFull(node.children.get(index), key);
        }
    }

    private void splitChild(Node parentNode, int index) {
        Node childNode = parentNode.children.get(index);
        Node newNode = new Node();

        parentNode.keys.add(index, childNode.keys.get(ORDER / 2));
        parentNode.children.add(index + 1, newNode);

        for (int i = ORDER / 2 + 1; i < ORDER; i++) {
            newNode.keys.add(childNode.keys.get(i));
        }

        for (int i = ORDER / 2 + 1; i < ORDER; i++) {
            if (!childNode.isLeaf) {
                newNode.children.add(childNode.children.get(i));
            }
        }

        for (int i = ORDER - 1; i >= ORDER / 2; i--) {
            childNode.keys.remove(i);
            if (!childNode.isLeaf) {
                childNode.children.remove(i);
            }
        }
    }

    // Método para eliminar un valor del árbol B+
    public void delete(int key) {
        deleteKey(root, key);
    }

    private void deleteKey(Node node, int key) {
        if (node == null) {
            return;
        }

        int index = findIndex(node.keys, key);

        if (index < node.keys.size() && node.keys.get(index) == key) {
            if (node.isLeaf) {
                node.keys.remove(index);
            } else {
                Node leftChild = node.children.get(index);
                Node rightChild = node.children.get(index + 1);

                if (leftChild.keys.size() >= ORDER / 2 + 1) {
                    int predecessor = getPredecessor(leftChild);
                    node.keys.set(index, predecessor);
                    deleteKey(leftChild, predecessor);
                } else if (rightChild.keys.size() >= ORDER / 2 + 1) {
                    int successor = getSuccessor(rightChild);
                    node.keys.set(index, successor);
                    deleteKey(rightChild, successor);
                } else {
                    mergeChildren(node, index);
                    deleteKey(leftChild, key);
                }
            }
        } else {
            Node child = node.children.get(index);
            if (child.keys.size() == ORDER / 2) {
                Node leftSibling = (index > 0) ? node.children.get(index - 1) : null;
                Node rightSibling = (index < node.children.size() - 1) ? node.children.get(index + 1) : null;

                if (leftSibling != null && leftSibling.keys.size() >= ORDER / 2 + 1) {
                    borrowFromLeftSibling(node, index);
                } else if (rightSibling != null && rightSibling.keys.size() >= ORDER / 2 + 1) {
                    borrowFromRightSibling(node, index);
                } else if (leftSibling != null) {
                    mergeChildren(node, index - 1);
                } else {
                    mergeChildren(node, index);
                }
            }

            deleteKey(node.children.get(index), key);
        }
    }

    private int getPredecessor(Node node) {
        while (!node.isLeaf) {
            node = node.children.get(node.children.size() - 1);
        }
        return node.keys.get(node.keys.size() - 1);
    }

    private int getSuccessor(Node node) {
        while (!node.isLeaf) {
            node = node.children.get(0);
        }
        return node.keys.get(0);
    }

    private void borrowFromLeftSibling(Node node, int index) {
        Node child = node.children.get(index);
        Node leftSibling = node.children.get(index - 1);

        int borrowedKey = leftSibling.keys.remove(leftSibling.keys.size() - 1);
        Node borrowedChild = leftSibling.children.remove(leftSibling.children.size() - 1);

        child.keys.add(0, node.keys.get(index - 1));
        node.keys.set(index - 1, borrowedKey);

        if (!child.isLeaf) {
            child.children.add(0, borrowedChild);
        }
    }

    private void borrowFromRightSibling(Node node, int index) {
        Node child = node.children.get(index);
        Node rightSibling = node.children.get(index + 1);

        int borrowedKey = rightSibling.keys.remove(0);
        Node borrowedChild = rightSibling.children.remove(0);

        child.keys.add(node.keys.get(index));
        node.keys.set(index, borrowedKey);

        if (!child.isLeaf) {
            child.children.add(borrowedChild);
        }
    }

    private void mergeChildren(Node node, int index) {
        Node leftChild = node.children.get(index);
        Node rightChild = node.children.get(index + 1);

        leftChild.keys.add(node.keys.remove(index));
        leftChild.keys.addAll(rightChild.keys);
        leftChild.children.addAll(rightChild.children);

        node.children.remove(index + 1);
    }

    // Método para obtener el valor mínimo del árbol B+
    public int min() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío.");
        }

        Node node = root;
        while (!node.isLeaf) {
            node = node.children.get(0);
        }

        return node.keys.get(0);
    }

    // Método para obtener el valor máximo del árbol B+
    public int max() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío.");
        }

        Node node = root;
        while (!node.isLeaf) {
            node = node.children.get(node.children.size() - 1);
        }

        return node.keys.get(node.keys.size() - 1);
    }

    // Método para obtener el padre de un nodo dado
    public Node father(Node child) {
        return findFather(root, child);
    }

    private Node findFather(Node node, Node child) {
        if (node == null || child == null) {
            return null;
        }

        if (node.children.contains(child)) {
            return node;
        } else {
            for (Node n : node.children) {
                Node parent = findFather(n, child);
                if (parent != null) {
                    return parent;
                }
            }
        }
        return null;
    }

    // Método de impresión para verificar el árbol
    public void print() {
        printNode(root, 0);
    }

    private void printNode(Node node, int level) {
        if (node != null) {
            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i) + " ");
            }
            System.out.println();

            if (!node.isLeaf) {
                for (Node child : node.children) {
                    printNode(child, level + 1);
                }
            }
        }
    }

    private int findIndex(List<Integer> list, int key) {
        int index = 0;
        while (index < list.size() && list.get(index) < key) {
            index++;
        }
        return index;
    }
}
