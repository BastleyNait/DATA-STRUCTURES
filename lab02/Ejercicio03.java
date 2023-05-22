public class Ejercicio03 {
    static int contador = 1; // Variable estática para contar el número de asteriscos en cada nivel del triángulo

    public static void main(String[] args) {
        trianguloRecursivo(4); // Llamamos al método trianguloRecursivo con el valor de base igual a 4
    }

    public static void trianguloRecursivo(int base){
        // Si la base llega a ser 0, no hay nada más que imprimir y se termina la recursión
        if(base == 0) {
            return;
        } else {
            // Imprimimos asteriscos en cada nivel del triángulo
            for (int i = 0; i < contador; i++) {
                System.out.print("*");
            }
            System.out.println(); // Imprimimos una nueva línea después de imprimir los asteriscos del nivel actual

            contador++; // Incrementamos el contador para el siguiente nivel del triángulo
            trianguloRecursivo(base - 1); // Llamamos de forma recursiva al método, disminuyendo la base en 1 en cada llamada
        }
    }
}
