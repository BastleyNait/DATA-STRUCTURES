import myExceptions.ExceptionNoFound;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;

import java.util.Scanner;

public class Aplicacion {
    public static void main(String args[]) throws ExceptionNoFound {
        generar();
    }

    public static void generar() throws ExceptionNoFound {
        System.setProperty("org.graphstream.ui", "swing");

        // Crear un grafo
        Graph graph = new SingleGraph("Aplicacion");

        // Crear un visor para el grafo
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();

        // Establecer la hoja de estilo para la representación visual de los nodos y las aristas
        graph.setAttribute("ui.stylesheet", styleSheet);

        // Leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese palabra en mayúsculas :");
        String word = sc.next(); // Ingresa tu palabra en mayúsculas aquí

        AVL<String> AVL = new AVL<>();
        int i = 0;

        char[] words = word.toCharArray();
        for (char c : words) {
            try {
                try {
                    AVL.search(String.valueOf(c));
                    // Si la búsqueda no arroja una excepción, se ejecuta este bloque
                    AVL.insert(String.valueOf(c) + "-" + i);
                    i++;
                } catch (ExceptionNoFound e) {
                    AVL.insert((String.valueOf(c)));
                }

            } catch (ExceptionNoFound e) {
                e.printStackTrace();
            }
        }
//
        // Agregar nodos al grafo
        addNodesToGraph(AVL.getRoot(), graph, 0.0, 0.0);

        // Crear otro grafo y visor para mostrar el grafo modificado
        Graph graph2 = new SingleGraph("Aplicacion2");
        graph2.setAttribute("ui.stylesheet", styleSheet);
        Viewer viewer2 = graph2.display();

        // Verificar las aristas en el árbol AVL
        verifyEdges(AVL.getRoot(), graph2);
        viewer2.disableAutoLayout();

        // Leer la entrada para eliminar un nodo
        System.out.println("Ingrese letra a eliminar :");
        String eliminar = sc.next(); // Ingresa tu palabra en mayúsculas aquí

        // Eliminar el nodo especificado del árbol AVL y del grafo
        AVL.remove(eliminar);
        graph.removeNode(eliminar);

        // Agregar nodos al grafo modificado
        addNodesToGraph(AVL.getRoot(), graph2, 0.0, 0.0);

        // Mostrar el valor mínimo y máximo en el árbol AVL
        System.out.println("Valor mínimo: " + AVL.getMin());
        Node node1 = graph2.addNode(String.valueOf(AVL.getMin()) + "-");
        node1.setAttribute("ui.label", node1.getId());
        node1.setAttribute("xy", 2, 2);

        System.out.println("Valor máximo: " + AVL.getMax());
        Node node2 = graph2.addNode(String.valueOf(AVL.getMax()) + "+");
        node2.setAttribute("ui.label", node2.getId());
        node2.setAttribute("xy", 3, 2);

        // Leer la entrada para buscar un nodo
        System.out.println("Ingrese letra a buscar:");
        String buscar = sc.next(); // Ingresa tu palabra en mayúsculas aquí
        System.out.println("Buscar " + buscar + ": " + AVL.search(buscar));
        System.out.println("Padre de " + buscar + ": " + AVL.parent(buscar));
        Node node3 = graph2.addNode(String.valueOf(AVL.search(buscar)) + "-s");
        Node node4 = graph2.addNode(String.valueOf(AVL.parent(buscar)) + "-P");
        node3.setAttribute("ui.label", node3.getId());
        node3.setAttribute("xy", 4, 2);

        node4.setAttribute("ui.label", node4.getId());
        node4.setAttribute("xy", 5, 2);

        // Leer la entrada para buscar los hijos de un nodo
        System.out.println("Ingrese letra a nodo a buscar hijos: ");
        String son = sc.next(); // Ingresa tu palabra en mayúsculas aquí
    }

    // Agregar nodos al grafo de forma recursiva
    private static void addNodesToGraph(Nodo current, Graph graph, double x, double y) {
        if (current != null) {
            // Agregar el nodo actual al grafo
            Node node = graph.addNode(String.valueOf(current.getData()));
            node.setAttribute("ui.label", node.getId());
            node.setAttribute("xy", x, y);
            double leftX = x - 10*Math.pow(2,current.getHeight());
            double rightX = x + 10*Math.pow(2,current.getHeight());
            double childY = y - 100;

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

    // Verificar las aristas en el árbol AVL
    public static void verifyEdges(Nodo current, Graph graph) {
        for (Node nodo : graph) {
            System.out.println("ID del nodo: " + nodo.getId());
        }
    }

    // Hoja de estilo para la representación visual de nodos y aristas
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
