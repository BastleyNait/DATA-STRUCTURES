import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        //Creamos el clase archivos con el objeto testDeIq
        Archivos testDeIq = new Archivos();
        String texto = testDeIq.leerArchivo("TestdeIQ.txt");
        String[] lineas = texto.split("\n");

        // Iteramos sobre el arreglo de cuestionario
        for (int i = 0; i < 20; i++) {
            // Obtenemos la pregunta y la respuesta
            String pregunta = testDeIq.leerPregunta(lineas, i);
            System.out.print(pregunta + "\nRespuesta: ");
            String respuesta = entrada.next();
        }
    }
}
