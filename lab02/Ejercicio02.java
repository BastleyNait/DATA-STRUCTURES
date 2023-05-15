public class Ejercicio02 {
    public static void main(String[] args) {
        int [] A = {1,2,3,4,5};
        int [] B = rotarIzquierdaArray(A, 2);
        imprimir(B); 
    }
    public static int[] rotarIzquierdaArray(int[] A, int d){
        int[] Aiz = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int j = (i + (A.length - d)) % A.length;
            Aiz[j] = A[i];
        }
        return Aiz;
    }
    public static void imprimir(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
