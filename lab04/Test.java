import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import myExceptions.ExceptionNoFound;

public class Test {
    public static void main(String[] args) throws ExceptionNoFound {
        Bst<Character> arbol = new Bst<>();
        addString("ABCDEFGHIJKLMNO", arbol);
        crearArbol(arbol);

    }

    public static void addString(String str, Bst<Character> tree) throws ExceptionNoFound {
        for (int i = 0; i < str.length(); i++) {
            tree.insert(str.charAt(i));
        }
    }

    static Graph graph = new SingleGraph("GraphStream_Example_03");

    public static void crearArbol(Bst<Character> tree) throws ExceptionNoFound {
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", styleSheet);
        Node rootNode = addNodeToGraph(tree.getRoot(), graph);
        addEdges(tree);
        graph.display();
    }

    private static Node addNodeToGraph(Nodo nodo, Graph graph) {
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

    public static void addEdges(Bst<Character> tree) throws ExceptionNoFound {
        Nodo raiz = tree.getRoot();
        Edge edgeI;
        Edge edgeD;

        /*for (Node node : graph) {
            //hallamos el nodo del grafo dentro del nodo del bst
            Character ind = node.getId().charAt(0);
            Nodo i = tree.searchNode(ind);
            Character p = tree.search(ind);
            if (i.getRight() != null && i.getLeft() != null) {
                Character cd = i.getRight().getData();
                Character ci = i.getLeft().getData();
                graph.addEdge(p + "" + cd, node, graph.getNode(String.valueOf(cd)), true);
                graph.addEdge(p + "" + ci, node, graph.getNode(String.valueOf(ci)), true);
            }
        }*/
        int r = 'r';
        int a = 'a';

        System.out.println();
        /*while (nodo.getRight() != null && nodo.getLeft() != null) {
            if (nodo.getRight() != null && nodo.getLeft() != null && edgeI != graph.getEdge(edgeI.getId()) && edgeD != graph.getEdge(edgeD.getId())) {
                edgeI = graph.addEdge(String.valueOf(nodo.getData() + nodo.getRight().getData()), String.valueOf(nodo.getData()), String.valueOf(nodo.getRight().getData()), true);
                edgeD = graph.addEdge(String.valueOf(nodo.getData() + nodo.getLeft().getData()), String.valueOf(nodo.getData()), String.valueOf(nodo.getLeft().getData()), true);
            } else if (nodo.getRight() != null && nodo.getLeft() == null && edgeD != graph.getEdge(edgeD.getId())) {
                edgeD = graph.addEdge(String.valueOf(nodo.getData() + nodo.getRight().getData()), String.valueOf(nodo.getData()), String.valueOf(nodo.getRight().getData()), true);
                nodo = nodo.getRight();
            } else if (nodo.getLeft() != null && nodo.getRight() == null && edgeI != graph.getEdge(edgeI.getId())) {
                edgeI = graph.addEdge(String.valueOf(nodo.getData() + nodo.getLeft().getData()), String.valueOf(nodo.getData()), String.valueOf(nodo.getLeft().getData()), true);
                nodo = nodo.getRight();
            }
        }*/
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
