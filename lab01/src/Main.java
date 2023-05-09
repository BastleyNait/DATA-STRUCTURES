public class Main {
    public static void main(String[] args) {
        //Creamos el clase archivos con el objeto tesDeIq
        Archivos testDeIq = new Archivos();
        String texto = testDeIq.leerTxt("TestdeIQ.txt");
        System.out.println(texto);
        String texto2 = testDeIq.leerTxt("TestdeIQ.txt");
        System.out.println(texto2);
    }

}
