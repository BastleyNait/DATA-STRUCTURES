import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import myExceptions.ExceptionNoFound;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.ui.graphicGraph.GraphicEdge;

public class Test2 {
    public static void main(String[] args) {
        Graph graph = new SingleGraph("My_graph");
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("f");
        graph.nodes().forEach((e) -> System.out.println(e.toString()));

    }
}
