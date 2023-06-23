import myExceptions.ExceptionNoFound;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.ui.view.Viewer;


import java.util.Iterator;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String args[]) throws ExceptionNoFound {
        generar();
    }

    public static void generar() throws ExceptionNoFound {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Aplicacion");

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();

        graph.setAttribute("ui.stylesheet", styleSheet);
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese palabra en mayusculas :");
        String word = sc.next(); // Ingresa tu palabra en mayúsculas aquí

        Bst<String> bst = new Bst<>();
        int i = 0;

        char[] words = word.toCharArray();
        for (char c : words) {
            try {
                try {
                    bst.search(String.valueOf(c));
                    // Si la búsqueda no arroja una excepción, se ejecuta este bloque
                    bst.insert(String.valueOf(c) + "-" + i);

                } catch (ExceptionNoFound e) {
                    bst.insert((String.valueOf(c)));
                }

            } catch (ExceptionNoFound e) {
                e.printStackTrace();
            }
        }
        addNodesToGraph(bst.getRoot(), graph, 0.0, 0.0);
        Graph graph2 = new SingleGraph("Aplicacion2");
        graph2.setAttribute("ui.stylesheet", styleSheet);
        Viewer viewer2 = graph2.display();
        viewer2.disableAutoLayout();

        System.out.println("ingrese letra a eliminar :");
        String eliminar = sc.next(); // Ingresa tu palabra en mayúsculas aquí
        bst.remove(eliminar);
        graph.removeNode(eliminar);
        addNodesToGraph(bst.getRoot(), graph2, 0.0, 0.0);
        //comentario
        System.out.println("Minimo valor: " + bst.getMin());
        Node node1 = graph2.addNode(String.valueOf(bst.getMin()) + "-");
        node1.setAttribute("ui.label", node1.getId());
        node1.setAttribute("xy", 2, 2);

        System.out.println("Maximo valor: " + bst.getMax());
        Node node2 = graph2.addNode(String.valueOf(bst.getMax()) + "+");
        node2.setAttribute("ui.label", node2.getId());
        node2.setAttribute("xy", 3, 2);

        System.out.println("ingrese letra a  buscar:");
        String buscar = sc.next(); // Ingresa tu palabra en mayúsculas aquí
        System.out.println("buscar " + buscar + ": " + bst.search(buscar));
        System.out.println("parent " + buscar + ": " + bst.parent(buscar));
        Node node3 = graph2.addNode(String.valueOf(bst.search(buscar)) + "-s");
        Node node4 = graph2.addNode(String.valueOf(bst.parent(buscar)) + "-P");
        node3.setAttribute("ui.label", node3.getId());
        node3.setAttribute("xy", 4, 2);

        node4.setAttribute("ui.label", node4.getId());
        node4.setAttribute("xy", 5, 2);

        System.out.println("ingrese letra a  nodo a buscar sons: ");
        String son = sc.next(); // Ingresa tu palabra en mayúsculas aquí
    }

    private static void addNodesToGraph(Nodo current, Graph graph, double x, double y) {
        if (current != null) {
            // Agregar el nodo actual al grafo
            Node node = graph.addNode(String.valueOf(current.getData()));
            node.setAttribute("ui.label", node.getId());
            node.setAttribute("xy", x, y);

            double leftX = x - 1.0;
            double rightX = x + 1.0;
            double childY = y - 1.0;

            // Agregar los nodos hijos recursivamente
            if (current.getLeft() != null) {
                addNodesToGraph(current.getLeft(), graph, leftX, childY);
                graph.addEdge((current.getData() + "-" + current.getLeft().getData()),
                        String.valueOf(current.getData()), String.valueOf(current.getLeft().getData()));
            }
            if (current.getRight() != null) {
                addNodesToGraph(current.getRight(), graph, rightX, childY);
                graph.addEdge((current.getData() + "-" + current.getRight().getData()),
                        String.valueOf(current.getData()), String.valueOf(current.getRight().getData()));
            }
        }
    }

    protected static String styleSheet = "node {" +
            "    shape: circle;" +
            "    size: 40px;" +
            "    text-size: 12;" +
            "    fill-mode: plain;" +
            "    fill-color: skyblue;" +
            "    stroke-mode: plain;" +
            "    stroke-color: black;" +
            "    stroke-width: 1px;" +
            "}" +
            "edge {" +
            "    arrow-shape: arrow;" +
            "    arrow-size: 20px, 4px;" +
            "}" +
            "node.root {" +
            "    fill-color: yellow;" +
            "}";
}