import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VentanaUsuario {
    // Lista para almacenar os usuarios rexistrados
    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    public static void main(String[] args) {
        // Crear a ventá principal
        JFrame frame = new JFrame("Rexistro de Usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Crear o panel e engadilo á ventá
        JPanel panel = new JPanel();
        frame.add(panel);

        // Campos de texto para introducir os datos do usuario
        JTextField correoField = new JTextField(20);
        JTextField contrasinalField = new JTextField(20);
        JTextField webField = new JTextField(20);
        JTextField nacementoField = new JTextField(20);

        // Engadir etiquetas e campos de texto ao panel
        panel.add(new JLabel("Correo:"));
        panel.add(correoField);
        panel.add(new JLabel("Contrasinal:"));
        panel.add(contrasinalField);
        panel.add(new JLabel("Web:"));
        panel.add(webField);
        panel.add(new JLabel("Nacemento (dd/MM/yyyy):"));
        panel.add(nacementoField);

        // Engadir o botón "Rexistrar" ao panel
        JButton btnRexistrar = new JButton("Rexistrar");
        panel.add(btnRexistrar);

        // Engadir un ActionListener ao botón "Rexistrar"
        btnRexistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recuperar os datos introducidos nos campos de texto
                String correo = correoField.getText();
                String contrasinal = contrasinalField.getText();
                String web = webField.getText();
                LocalDate nacemento = LocalDate.parse(nacementoField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                // Crear un novo usuario coa información introducida
                Usuario usuario = new Usuario(correo, contrasinal, web, nacemento);
                // Engadir o usuario á lista de usuarios rexistrados
                usuariosRegistrados.add(usuario);
                // Imprimir a información do usuario rexistrado na consola
                System.out.println("Usuario rexistrado: " + usuario);
            }
        });

        // Facendo visible a ventá
        frame.setVisible(true);
    }
}
