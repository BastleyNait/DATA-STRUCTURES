import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree();

        insertar(bPlusTree);
        encontrarMaxyMin(bPlusTree);
        

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
        System.out.println(tree.father(new Node(nodo)));
        
    }
    public static void encontrarHijo(BPlusTree tree){
        System.out.println("de quien quiere encontrar su hijo");
        int nodo = sc.nextInt();
        System.out.println(tree.father(new Node(nodo)));
    }

    public static void encontrarNodo(BPlusTree tree) {
        System.out.println("que nodo quiere saber si se encuentra en el arbol?");
        int nodo = sc.nextInt();
        tree.search(nodo);
    }

}
