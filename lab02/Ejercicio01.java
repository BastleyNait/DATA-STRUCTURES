public class Ejercicio01 {
    public static void main(String args[]) {
        int [] A = {1,2,3}; // Creamos un array A con elementos 1, 2 y 3
        int [] B = invertirArray(A); // Llamamos al método invertirArray y pasamos el array A como argumento
        imprimir(B); // Llamamos al método imprimir y pasamos el array invertido B como argumento
    }

    // Método para invertir un array
    public static int[] invertirArray(int[] A){
        int [] Ain = new int[A.length]; // Creamos un nuevo array Ain con la misma longitud que el array A
        for (int i = 0, j = A.length - 1; i < Ain.length; i++, j--) {
            Ain[j] = A[i]; // Asignamos el elemento en la posición i del array A al elemento en la posición j del array Ain
        }
        return Ain; // Devolvemos el array invertido Ain
    }

    // Método para imprimir un array
    public static void imprimir(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " "); // Imprimimos cada elemento del array separado por un espacio
        }
        System.out.println(); // Imprimimos una nueva línea después de imprimir el array completo
    }
}



