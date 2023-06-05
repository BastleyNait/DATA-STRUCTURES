
public class test {
    public static void main(String[] args) {
        MyList<String> nombres = new MyList<String>();
        nombres.add("Selena");
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Fiorella");
        //impriendolo con un bucle
        for (int i = 0; i < nombres.getSize(); i++) {
            System.out.println(nombres.get(i));
        }
        //imprimeindo con el metodo implementado en MyList
        nombres.printList();
    }

}
