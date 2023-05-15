public class Ejercicio03 {
    public static void main(String[] args) {
        trianguloRecursivo(4);
    }

    public static void trianguloRecursivo(int base){
        String triangulo = "";
        if(base == 0) {
            System.out.println(triangulo);
        } else {
            triangulo += "*";
            trianguloRecursivo(base - 1);
        }
    }
}
