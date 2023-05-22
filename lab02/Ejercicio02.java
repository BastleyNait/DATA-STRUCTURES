public class Ejercicio02 {
    public static void main(String[] args) {
        int [] A = {1,2,3,4,5}; // Creamos un array A con elementos 1, 2, 3, 4 y 5
        int [] B = rotarIzquierdaArray(A, 2); // Llamamos al método rotarIzquierdaArray y pasamos el array A y el valor 2 como argumentos
        imprimir(B); // Llamamos al método imprimir y pasamos el array rotado B como argumento
    }

    // Método para rotar un array hacia la izquierda
    public static int[] rotarIzquierdaArray(int[] A, int d){
        int[] Aiz = new int[A.length]; // Creamos un nuevo array Aiz con la misma longitud que el array A
        for (int i = 0; i < A.length; i++) {
            int j = (i + (A.length - d)) % A.length; // Calculamos la nueva posición j para el elemento en la posición i después de la rotación
            Aiz[j] = A[i]; // Asignamos el elemento en la posición i del array A al elemento en la posición j del array Aiz
        }
        return Aiz; // Devolvemos el array rotado Aiz
    }

    // Método para imprimir un array
    public static void imprimir(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " "); // Imprimimos cada elemento del array separado por un espacio
        }
        System.out.println(); // Imprimimos una nueva línea después de imprimir el array completo
    }
}
