import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Archivos testDeIq = new Archivos();
        String texto = testDeIq.leerArchivo("TestdeIQ.txt");
        String[] lineas = texto.split("\n");

        int aciertos = 0; // Contador de respuestas correctas

        for (int i = 0; i < 20; i++) {
            String pregunta = testDeIq.leerPregunta(lineas, i);
            System.out.print(pregunta + "\nRespuesta: ");
            String respuesta = entrada.next();
            String[] claves = {"b","a","a","a","a", "b","a","a", "b","a","b", "b","a","b", "b","a","b", "b","a","b"};

            // Comparar la respuesta con la respuesta esperada
            String respuestaEsperada = claves[i].toLowerCase();

            if (respuesta.equalsIgnoreCase(respuestaEsperada)) {
                aciertos++;
            }
        }

        // Calcular rango aproximado de CI basado en la cantidad de aciertos
        int rangoCI = 0;

        if (aciertos > 18) {
            rangoCI = 150;
        } else if (aciertos > 15) {
            rangoCI = 140;
        } else if (aciertos > 12) {
            rangoCI = 130;
        } else if (aciertos > 9) {
            rangoCI = 120;
        } else if (aciertos > 6) {
            rangoCI = 110;
        } else if (aciertos > 3) {
            rangoCI = 100;
        } else {
            rangoCI = 90;
        }

        System.out.println("Cantidad de respuestas correctas: " + aciertos);
        System.out.println("Rango aproximado de CI: " + rangoCI);
    }
}
