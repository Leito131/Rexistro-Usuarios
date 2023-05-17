package junit.tarefa9;


import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



//Comprobar que se cree la estancia de la ventana
public class RegistroTest {
    @Test
    public void testMain() {
        assertNotNull(new VentanaRegistro());
    }
    
//Comprobar que se cree la estancia de la ventana
    @Test
    public void testVentanaRegistro() {
        VentanaRegistro ventana = new VentanaRegistro();
        assertEquals("Formulario Contornos", ventana.getTitle());
        assertEquals(828, ventana.getX());
        assertEquals(356, ventana.getY());
        assertEquals(265, ventana.getWidth());
        assertEquals(320, ventana.getHeight());
        assertFalse(ventana.isResizable());
        assertTrue(ventana.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE || ventana.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
        assertNotNull(ventana.getIconImage());
        assertTrue(ventana.getContentPane().getComponent(0) instanceof PanelRegistro);
        assertTrue(ventana.isVisible());
    }
    
    @Test
    public void testPanelRegistro() {
        PanelRegistro panel = new PanelRegistro();
        assertTrue(panel.getComponent(0) instanceof JLabel);
        assertTrue(panel.getComponent(1) instanceof JTextField);
        assertTrue(panel.getComponent(2) instanceof JLabel);
        assertTrue(panel.getComponent(3) instanceof JPasswordField);
        assertTrue(panel.getComponent(4) instanceof JLabel);
        assertTrue(panel.getComponent(5) instanceof JLabel);
        assertTrue(panel.getComponent(6) instanceof JTextField);
        assertTrue(panel.getComponent(7) instanceof JLabel);
        assertTrue(panel.getComponent(8) instanceof JTextField);
        assertTrue(panel.getComponent(9) instanceof JLabel);
        assertTrue(panel.getComponent(10) instanceof JTextField);
        assertTrue(panel.getComponent(11) instanceof JButton);
    }
 
    @Test
    public void testComprobarValidacionCampos() {
        PanelRegistro panel = new PanelRegistro();
        panel.txtUsuario.setText("usuario1");
        panel.txtConstraseña.setText("password1!");
        panel.txtMail.setText("usuario1@gmail.com");
        panel.txtWeb.setText("https://www.google.com");
        panel.txtDate.setText("2000-01-01");
        panel.btnregistrar.doClick();
        assertEquals(150, panel.usuarios.length);
        assertEquals("usuario1", panel.usuarios[0].getUsuario());
        assertEquals("password1!", panel.usuarios[0].getContrasinal());
        assertEquals("usuario1@gmail.com", panel.usuarios[0].getCorreo());
        assertEquals("https://www.google.com", panel.usuarios[0].getWeb());
        assertEquals("2000-01-01", panel.usuarios[0].getNacemento());
    }

    @Test
    public void testComprobarValidacionCamposMal() {
        PanelRegistro panel = new PanelRegistro();
        panel.txtConstraseña.setText("jacoco");
        panel.btnregistrar.doClick();

        assertEquals("Min 8 caracteres, 1 numero y 1 caracter especial.", panel.lblError.getText());
        assertEquals("Contraseña incorrecta", panel.ErrorPass);
    }



}


   
