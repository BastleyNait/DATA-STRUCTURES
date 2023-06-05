import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {
    /**
     * Lee el contenido de un archivo y lo devuelve como una cadena de texto.
     *
     * @param ruta La ruta del archivo a leer.
     * @return El contenido del archivo como una cadena de texto.
     */
    public String leerArchivo(String ruta) {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = bf.readLine()) != null) {
                texto += linea + "\n";
            }
            bf.close(); // Cerrar el archivo después de leerlo
        } catch (Exception e) {
            System.err.println("No se encontró el archivo en la ruta especificada");
        }
        return texto;
    }

    /**
     * Lee las líneas correspondientes a una pregunta del arreglo de líneas y las
     * concatena en una cadena de texto.
     *
     * @param lineas       El arreglo de líneas que contiene las preguntas.
     * @param numPregunta  El número de la pregunta a leer.
     * @return La pregunta como una cadena de texto.
     */
    public String leerPregunta(String[] lineas, int numPregunta) {
        String pregunta = "";
        int inicio = numPregunta * 6;
        for (int i = inicio; i < inicio + 6; i++) {
            pregunta += "\n" + lineas[i];
        }
        System.out.println("\b"); // Eliminar un carácter de nueva línea adicional
        return pregunta;
    }
}
