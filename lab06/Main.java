import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree();

        insertar(bPlusTree);

        System.out.println("¿El número 20 está en el árbol? " + bPlusTree.search(20));
        System.out.println("¿El número 15 está en el árbol? " + bPlusTree.search(15));
        System.out.println("Mínimo valor del árbol: " + bPlusTree.min());
        System.out.println("Máximo valor del árbol: " + bPlusTree.max());

        bPlusTree.print();
    }
    public static void insertar(BPlusTree tree) {
        System.out.println("Cuantos nodos desea insertar al arbo B+?:");
        int num = sc.nextInt();
        int c = 0;
        System.out.println("ingrese los numeros:");
        while (c<num) {
            int key = sc.nextInt();
            tree.insert(key);
            c++;
        }
    }
    public static void encontrarMaxyMin (BPlusTree tree) {
        System.out.println("El maximo es: " + tree.max());
        System.out.println("El minimo es: " + tree.min());
    }

    public static void encontrarPadre(BPlusTree tree){
        System.out.println("de quien quiere encontrar su padre");
        int nodo = sc.nextInt();
        tree.father(new Node(nodo));
        
    }
    public static void encontrarHijo(BPlusTree tree){
        System.out.println("de quien quiere encontrar su hijo");
        int nodo = sc.nextInt();
        tree.father(new Node(nodo));
    }
}
