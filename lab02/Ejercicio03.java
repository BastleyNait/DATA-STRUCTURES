public class Ejercicio03 {
    public static void main(String[] args) {
        trianguloRecursivo(4);
    }

    public static void trianguloRecursivo(int base){
        if(base == 0) {
            return;
        } else {
            for (int i = base; i > 0; i--) {
                System.out.print("*");
            }
            System.out.println();
            trianguloRecursivo(base - 1);
        }
    }
}
