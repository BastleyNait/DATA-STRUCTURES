import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
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

        Node rootNode = addNodeToGraph(tree.getRoot(), graph);

        graph.display();
    }

    private static Node addNodeToGraph(Nodo<Character> nodo, Graph graph) {
        Node graphNode = graph.addNode(String.valueOf(nodo.getData()));
        graphNode.setAttribute("ui.label", graphNode.getId());

        if (nodo.getLeft() != null) {
            Node leftNode = addNodeToGraph(nodo.getLeft(), graph);
        }

        if (nodo.getRight() != null) {
            Node rightNode = addNodeToGraph(nodo.getRight(), graph);
        }

        return graphNode;
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
