import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextMod extends JFrame {
    private JPanel mainPanel;
    private JTextField Palabra;
    private JButton btReem;
    private JEditorPane newTexto;
    private JButton btElim;
    private JButton btBuscar;
    private JTextField Eliminar;
    private JTextField Buscar;
    private JTextArea Texto;
    private JTextField newPalabra;

    private Trie<Character> miTrie = new Trie<>();

    public TextMod() {

        setContentPane(mainPanel);
        setTitle("TexT MoD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTexto.setContentType("text/html");
                String[] arrText = Texto.getText().split("(?<= )|(?= )");
                insertar(Texto.getText());
                String palabra = Buscar.getText();
                newTexto.setText(buscar(palabra,arrText));
            }
        });
        btElim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTexto.setContentType("text/html");
                String[] arrText = Texto.getText().split("(?<= )|(?= )");
                insertar(Texto.getText());
                String palabra = Eliminar.getText();
                newTexto.setText(eliminar(palabra,arrText));
            }
        });
        btReem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTexto.setContentType("text/html");
                String[] arrText = Texto.getText().split("(?<= )|(?= )");
                insertar(Texto.getText());
                String palabra = Palabra.getText();
                String newpalabra = newPalabra.getText();
                newTexto.setText(reemplazar(palabra,newpalabra,arrText));
            }
        });
    }

    public static void main(String[] args) {
        FlatMaterialDarkerIJTheme.setup();
        new TextMod();
    }



    public String insertar(String texto) {
        String[] arrText = texto.split("(?<= )|(?= )");
        for (int i = 0; i < arrText.length; i++) {
            if (!arrText[i].equals(" ") ) {
                if(arrText[i].charAt(arrText[i].length() - 1 ) == '.' || arrText[i].charAt(arrText[i].length() - 1 ) == ',')
                    miTrie.insert(arrText[i] + "\b");
                else
                    miTrie.insert(arrText[i]);
            }
        }
        return "";
    }

    public String eliminar(String palabra, String[] texto) {

        String result = "";
        if (miTrie.search(palabra) > 0) {
            for (int i = 0; i < texto.length; i++) {
                if (palabra.equals(texto[i]) || palabra.equals(texto[i].substring(0,texto[i].length()-1)))
                    result += "";
                else
                    result += texto[i];
            }
            result = "<html>"+result+"</html>";
            System.out.println(result);
        }
        else {
            JOptionPane.showMessageDialog(null, "no se encontró el elemento");
        }
        return result;
    }

    public String reemplazar(String palabra,String newPalabra, String[] texto) {

        String result = "";
        if (miTrie.search(palabra) > 0) {
            for (int i = 0; i < texto.length; i++) {
                if (palabra.equals(texto[i]) || palabra.equals(texto[i].substring(0,texto[i].length()-1)))
                    result += newPalabra;
                else
                    result += texto[i];
            }
            result = "<html>"+result+"</html>";
            System.out.println(result);
        }
        else {
            JOptionPane.showMessageDialog(null, "no se encontró el elemento");
        }
        return result;
    }

    public String buscar(String palabra, String[] texto) {

        String result = "";
        if (miTrie.search(palabra) > 0) {
            for (int i = 0; i < texto.length; i++) {
                if (palabra.equals(texto[i]) || palabra.equals(texto[i].substring(0,texto[i].length()-1)))
                    result += "<font style='background-color: orange;'>"+texto[i]+"</font>";
                else
                    result += texto[i];
            }
            result = "<html>"+result+"</html>";
            System.out.println(result);
        }
        else {
            JOptionPane.showMessageDialog(null, "no se encontró el elemento");
        }
        return result;
    }
}
