

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaRegistro();
		
	}

}

class VentanaRegistro extends JFrame {
	public VentanaRegistro() {
		setTitle("Formulario Contornos");
		setBounds(10, 10, 265, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PanelRegistro());

		setVisible(true);
	}
}

class PanelRegistro extends JPanel {
	public Usuario[] usuarios = new Usuario[1500];		
	public JTextField txtUsuario = new JTextField(20);
	public JPasswordField txtConstraseña = new JPasswordField(20);
	public JTextField txtMail = new JTextField(20);
	public JTextField txtWeb = new JTextField(20);
	public JTextField txtDate = new JTextField("0000-01-01", 20);
	public JButton btnregistrar = new JButton("Registrar");

	public PanelRegistro() {
		setLayout(new BorderLayout());
		add(new JLabel("Usuario:"));
		add(txtUsuario);
		add(new JLabel("Constraseña"));
		add(txtConstraseña);
		add(new JLabel("Correo:"));
		add(txtMail);
		add(new JLabel("Web"));
		add(txtWeb);
		add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
		add(txtDate, "asd");
		add(btnregistrar);
		btnregistrar.addActionListener(new Comprobar());

	}

	class Comprobar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String user = txtUsuario.getText();
			String pass = txtConstraseña.getText();
			String mail = txtMail.getText();
			String web = txtWeb.getText();
			String fechaString = txtDate.getText();
			LocalDate fechaDate= LocalDate.parse(fechaString);
			
			if (!Validator.validarContrasinal(pass))
				return;
			if (!Validator.validarEmail(mail))
				return;
			if (!Validator.validarWeb(web))
				return;
			 if(!Validator.validarNacemento(fechaDate)); 
			 int indice = 0;	 
				usuarios[indice++] = new Usuario(user,pass,mail,web,fechaString);
				System.out.println(usuarios[--indice]);
		}

	}
}
