import java.io.BufferedReader;
import java.io.FileReader;

public class archivos {
    public void leerTxt(String ruta) {
        //este método tiene como atributo una string la cual es la ubicacion del archivo
        //seguidamente lo imprime linea por linea
        try {
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }
        }
        catch (Exception e) {System.err.println("No se encontró el archivo en la ruta especificada");}
    }
}
