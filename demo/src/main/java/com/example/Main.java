package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
		Image icono = Toolkit.getDefaultToolkit().getImage("CoronaAzul.png");
		setIconImage(icono);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		add(new PanelRegistro());
	
		setVisible(true);
	}
}

class PanelRegistro extends JPanel {
	private Font error = new  Font("Arial", Font.BOLD, 10);
	private JLabel lblError = new JLabel("");
	public LocalDate FchDefault = LocalDate.now();
	public Usuario[] usuarios = new Usuario[150];
	public JTextField txtUsuario = new JTextField(20);
	public JPasswordField txtConstraseña = new JPasswordField(20);
	public JTextField txtMail = new JTextField(20);
	public JTextField txtWeb = new JTextField(20);
	public JTextField txtDate = new JTextField(FchDefault + "", 20);
	public JButton btnregistrar = new JButton("Registrar");

	public PanelRegistro() {
		add(new JLabel("Usuario:"));
		add(txtUsuario);
		add(new JLabel("Constraseña:"));
		add(txtConstraseña);
		lblError.setFont(error);
		lblError.setForeground(Color.RED);
		add(lblError);
		add(new JLabel("Correo:"));
		add(txtMail);
		add(new JLabel("Web:"));
		add(txtWeb);
		add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
		add(txtDate);
		add(btnregistrar);
		setBackground(Color.getHSBColor(0.6f, 0.4f,0.9f));
		btnregistrar.addActionListener(new Comprobar());

	}

	class Comprobar extends Validator implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String user = txtUsuario.getText();
			String pass = txtConstraseña.getText();
			String mail = txtMail.getText();
			String web = txtWeb.getText();
			String fechaString = txtDate.getText();
			LocalDate fechaDate;
			try { 
				fechaDate = LocalDate.parse(fechaString);
			}
			catch (DateTimeParseException w) {
				System.err.println("Error fecha con formato incorrecto");
				JOptionPane.showMessageDialog(btnregistrar, "ERROR, fecha con formato invalido");
				txtDate.requestFocus();
				txtDate.setText(FchDefault + "");
				return;
			}

			if (!Validator.validarContrasinal(pass)) {
				txtConstraseña.setText("");
				txtConstraseña.requestFocus();
				lblError.setText("Min 8 caracteres, 1 numero y 1 caracter especial.");
				return;
			}
			lblError.setText("");
			if (!Validator.validarEmail(mail)) {
				txtMail.setText("");
				txtMail.requestFocus();
				return;
			}
			if (!Validator.validarWeb(web)) {
				txtWeb.setText("");
				txtWeb.requestFocus();
				return;
			}
			if (!Validator.validarNacemento(fechaDate)) {
				txtDate.setText("");
				txtDate.requestFocus();
				return;
			}
			int indice = 0;
			
			usuarios[indice++] = new Usuario(user, pass, mail, web, fechaString);
			JOptionPane.showMessageDialog(btnregistrar, "Usuario creado correctamente");
			txtUsuario.setText("");
			txtConstraseña.setText("");
			txtMail.setText("");
			txtWeb.setText("");
			txtDate.setText(FchDefault + "");
			System.out.println(usuarios[--indice]);
		}

	}
}
