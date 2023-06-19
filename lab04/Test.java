import myExceptions.ExceptionNoFound;

public class Test {
    public static void main(String[] args) throws ExceptionNoFound {
        Bst<Character> tree = new Bst<>();
        addString("hola", tree);
        tree.inOrden();

    }

    public static void addString(String str, Bst<Character> tree) throws ExceptionNoFound {
        for (int i = 0; i < str.length(); i++) {
            tree.insert(str.charAt(i));
        }
    }




}
