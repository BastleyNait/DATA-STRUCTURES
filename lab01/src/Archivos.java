import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {
    // ...

    public String leerArchivo(String ruta) {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = bf.readLine()) != null) {
                texto += linea + "\n";
            }
        } catch (Exception e) {
            System.err.println("No se encontró el archivo en la ruta especificada");
        }
        return texto;
    }

    public String leerPregunta(String[] lineas, int numPregunta) {
        String pregunta = "";
        int inicio = numPregunta * 6;
        for (int i = inicio; i < inicio + 6; i++) {
            pregunta += "\n" + lineas[i];
        }
        System.out.println("\b");
        return pregunta;
    }
}
