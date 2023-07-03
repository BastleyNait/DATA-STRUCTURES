import java.util.*;

public class Node {
        List<Integer> keys;
        List<Node> children;
        boolean isLeaf;

        Node() {
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.isLeaf = true;
        }

        Node(int key) {
            this();
            this.keys.add(key);
        }
        @Override
        public String toString() {
            return "keys: " + this.keys.toString() +
                 "\nhijos: " + this.children.toString() ;
        }
    }