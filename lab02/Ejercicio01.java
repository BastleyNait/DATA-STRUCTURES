public class Ejercicio01 {
    public static void main(String args[]) {
        int [] A = {1,2,3};
        int [] B = invertirArray(A);
        imprimir(B);
 
    }

    public static int[] invertirArray(int[] A){
        int [] Ain = new int[A.length];
        for (int i = 0, j = A.length - 1; i < Ain.length; i++, j--) {
            Ain[j] = A[i]; 
        }
        return Ain;
    }
    public static void imprimir(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}


