import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;

import java.util.Iterator;

import myExceptions.ExceptionNoFound;

public class Test {
    public static void main(String[] args) throws ExceptionNoFound {
        Bst<Character> arbol = new Bst<>();
        addString("FABION", arbol);
        arbol.inOrden();
        crearArbol(arbol);

    }

    public static void addString(String str, Bst<Character> tree) throws ExceptionNoFound {
        for (int i = 0; i < str.length(); i++) {
            tree.insert(str.charAt(i));
        }
    }

    public static void crearArbol(Bst<Character> tree) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("GraphStream_Example_03");
        graph.setAttribute("ui.stylesheet", styleSheet);
        Nodo<Character> nodo = tree.getRoot();
        Node root=graph.addNode(String.valueOf(nodo.getData()));
        root.setAttribute("ui.label", root.getId());
        while (nodo.getRight() != null || nodo.getLeft() != null) {
            if (nodo.getRight() != null) {
                Node right = graph.addNode(String.valueOf(nodo.getRight()));
                right.setAttribute("ui.label", right.getId());

                nodo = nodo.getRight();
            } else if (nodo.getLeft() != null) {
                Node left = graph.addNode(String.valueOf(nodo.getLeft()));
                left.setAttribute("ui.label", left.getId());
                nodo = nodo.getLeft();
            }

        }
        graph.display();
    }


        protected static String styleSheet =
                "node {" +
                        "	shape: circle;" +
                        "	size: 40px;" +
                        " text-size: 12;" +
                        "	fill-mode: plain;" +
                        "	fill-color: skyblue;" +
                        "	stroke-mode: plain;" +
                        "	stroke-color: black;" +
                        "	stroke-width: 1px;" +
                        "}" +
                        "edge { arrow-shape: arrow; arrow-size: 20px, 4px; }";


    }
