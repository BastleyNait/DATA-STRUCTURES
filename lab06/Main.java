import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree();

        bPlusTree.insert(10);
        bPlusTree.insert(20);
        bPlusTree.insert(5);
        bPlusTree.insert(7);

        System.out.println("¿El número 20 está en el árbol? " + bPlusTree.search(20));
        System.out.println("¿El número 15 está en el árbol? " + bPlusTree.search(15));
        System.out.println("Mínimo valor del árbol: " + bPlusTree.min());
        System.out.println("Máximo valor del árbol: " + bPlusTree.max());

        bPlusTree.print();
    }
    public static void insertar() {
        System.out.println("Cuantos nodos desea insertar al arbo B+?:");
        int num = sc.nextInt();
        int c = 0;
        System.out.println("ingrese los numeros:");
        while (c<num) {
            int nddo = 
        }
    }
}
