import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.IdAlreadyInUseException;
public class GraphHuffman {

    public static void main(String[] args) {
        crearGrafo("uwu");

    }
    public static void crearGrafo(String text) {
        HuffmanTree arbol = new HuffmanTree(text);
        arbol.encode();
        System.setProperty("org.graphstream.ui", "swing");
        // Crear un grafo
        Graph graph = new SingleGraph("Aplicacion");
        // Establecer la hoja de estilo para la representación visual de los nodos y las aristas
        graph.setAttribute("ui.stylesheet", styleSheet);
        addNodesToGraph(arbol.getRoot(),graph,0,0);
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();

    }
    private static void addNodesToGraph(Nodo current, Graph graph, double x, double y) {
        if (current != null) {
            try {// Agregar el nodo actual al grafo
                Node node = graph.addNode(String.valueOf(current.getData()));
                node.setAttribute("ui.label", current.getData());
                node.setAttribute("xy", x, y);
                double leftX = x - 10 * Math.pow(2,current.getHeight());
                double rightX = x + 10 * Math.pow(2,current.getHeight());
                double childY = y - 100;

                // Agregar los nodos hijos recursivamente
                if (current.getLeft() != null) {
                    addNodesToGraph(current.getLeft(), graph, leftX, childY);
                    Edge edge = graph.addEdge((current.getData() + "-" + current.getLeft().getData()),
                            String.valueOf(current.getData()), String.valueOf(current.getLeft().getData()));
                    edge.setAttribute("ui.label", "0");
                }
                if (current.getRight() != null) {
                    addNodesToGraph(current.getRight(), graph, rightX, childY);
                    Edge edge = graph.addEdge((current.getData() + "-" + current.getRight().getData()),
                            String.valueOf(current.getData()), String.valueOf(current.getRight().getData()));
                    edge.setAttribute("ui.label", "1");
                }
            }
            catch (IdAlreadyInUseException e) {

            }
        }
    }
    protected static String styleSheet = "node {" +
            "    shape: circle;" +
            "    size: 40px;" +
            "    text-size: 12;" +
            "    fill-mode: plain;" +
            "    fill-color: orange;" +
            "    stroke-mode: plain;" +
            "    stroke-color: black;" +
            "    stroke-width: 1px;" +
            "}" +
            "edge {" +
            "    arrow-shape: arrow;" +
            "    arrow-size: 20px, 4px;" +
            "    text-size: 18; " +
            "    text-color: black;" +
            "}" +
            "node.root {" +
            "    fill-color: yellow;" +
            "}";
}

