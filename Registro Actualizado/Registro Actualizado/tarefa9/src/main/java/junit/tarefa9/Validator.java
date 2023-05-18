package junit.tarefa9;

import java.time.LocalDate;
import java.util.Date;

public class Validator {

	public static boolean validarEmail(String email) {
        boolean valido = false;        
        if (email == null || email.isEmpty()) {
            System.err.println("El campo e-mail está vacío.");
            return valido;
        }
        int arroba = email.indexOf('@');
        int punto = email.lastIndexOf('.');
        if (arroba < 1 || punto < arroba + 2 || punto + 2 > email.length()) {
            System.err.println("El e-mail introducido no tiene el formato correcto.");
            return valido;
        }
        valido = true;
        return valido;
    }

    public static boolean validarContrasinal(String contrasinal) {
        boolean valido = false;
        if (contrasinal == null || contrasinal.length() < 8 ) {
            System.err.println("La contraseña no es lo suficientemente larga.");
            return valido;
        }
        boolean tieneNumero = false;
        boolean tieneLetra = false;
        boolean tieneCaracterEspecial = false;
        for (int i = 0; i < contrasinal.length(); i++) {
            char c = contrasinal.charAt(i);
            if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (Character.isLetter(c)) {
                tieneLetra = true;
            } else if ("@#$%^&+=.,-?¿!¡()*:;<>/".indexOf(c) >= 0) {
                tieneCaracterEspecial = true;
            }
        }

        if (!tieneNumero || !tieneLetra || !tieneCaracterEspecial){
            System.err.println("La contraseña debe contener un número, una letra y un caracter especial.");
            return valido;
        }else{
            valido = true;
            return valido;
        }
    }

    public static boolean validarWeb(String web) {
        if (web == null || web.isEmpty()) {
            System.err.println("El campo web está vacío.");
            return false;
        }
        try {
            new java.net.URL(web).toURI();
            return true;
        } catch (Exception e) {
            System.err.println("La web introducida no tiene el formato correcto.");
            return false;
        }
    }

    public static boolean validarNacemento(LocalDate nacemento) {
        boolean valido = false;
        if (nacemento == null) {
            System.err.println("El campo nacimiento está vacío.");
            return valido;
        }

        LocalDate dataActual =  LocalDate.now();

        if (!nacemento.isBefore(dataActual)){
            System.err.println("La fecha introducida no es válida.");
            return valido;
        }else{
            valido = true;
            return valido;
        }

        
         
    }

}
