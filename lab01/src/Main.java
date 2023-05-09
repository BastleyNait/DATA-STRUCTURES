import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File testDeIq = new File("./Test de IQ.txt");
        try {
            FileReader file = new FileReader(testDeIq);
            BufferedReader lector = new BufferedReader(file);
            String linea;
            while ((linea = lector.readLine()) != null ) {
                System.out.println(linea);
            }
        } catch (IOException e){
            e.printStackTrace();
        }





    }
}
