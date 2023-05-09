import java.io.BufferedReader;
import java.io.FileReader;

public class Archivos {
    private int numPregunta;
    private int numDelinea = 0;

    public String leerTxt(String ruta) {
        //este método tiene como atributo una string la cual es la ubicacion del archivo
        //seguidamente lo lo am
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            String linea;
            String temp = "";
            int contador = 1;
            while (numDelinea != 0 && numDelinea - 6 < numPregunta * 6) {
                bf.readLine();
                numDelinea++;
            }
            while ((linea = bf.readLine()) != null && contador < 6) {
                temp += linea + "\n";
                contador++;
            }
            numDelinea += contador;
            texto = temp;
            numPregunta++;
        } catch (Exception e) {
            System.err.println("No se encontró el archivo en la ruta especificada");
        }
        return texto;
    }
}
