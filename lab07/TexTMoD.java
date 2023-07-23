import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TexTMoD extends JFrame {
    private JPanel mainPanel;
    private JTextField Reemplar;
    private JButton btReem;
    private JEditorPane newTexto;
    private JButton btElim;
    private JButton btBuscar;
    private JTextField Eliminar;
    private JTextField Buscar;
    private JTextArea Texto;

    public TexTMoD() {

        setContentPane(mainPanel);
        setTitle("TexT MoD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoT = "<html>" +
                        "<font style='background-color: orange;'>"+Texto.getText()+"</font>" +
                        "</html>";
                newTexto.setContentType("text/html");
                newTexto.setText(nuevoT);
            }
        });
    }

    public static void main(String[] args) {
        FlatMaterialDarkerIJTheme.setup();
        new TexTMoD();
    }
}
