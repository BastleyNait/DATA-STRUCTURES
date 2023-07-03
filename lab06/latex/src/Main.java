import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BPlusTree bpt = new BPlusTree();
        insertarKeys(bpt);
        bpt.printTree();
        buscar(bpt);
    }

    public static void insertarKeys(BPlusTree tree){
        int c = 0;
        System.out.println("Cuantos elementos desea insertar en el arbol b+");
        int n = sc.nextInt();
        System.out.println("Intruzca los valores");
        while(c<n){
            int key = sc.nextInt();
            tree.insert(key);
            c++;
        }
    }

    public static void buscar(BPlusTree tree) {
        System.out.println("que valor desea buscar?: ");
        int key = sc.nextInt();
        boolean bool = tree.search(key);
        if (bool) {
            System.out.printf("\nLa key " + key +  " sí se encuentra en el arbol");
        } 
        else {
            System.out.printf("\nLa key " + key +  " no se encuentra en el arbol");
        }
    }
}
