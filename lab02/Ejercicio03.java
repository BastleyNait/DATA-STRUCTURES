public class Ejercicio03 {
    static int contador = 1;
    public static void main(String[] args) {
        trianguloRecursivo(4);
    }

    public static void trianguloRecursivo(int base){
        
        if(base == 0) {
            return;
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.print("*");
            }
            System.out.println();
            contador++;
            trianguloRecursivo(base - 1);
        }
    }
}
