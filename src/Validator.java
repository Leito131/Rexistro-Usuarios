import java.util.Date;

public class Validator {
    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        int arroba = email.indexOf('@');
        int punto = email.lastIndexOf('.');
        if (arroba < 1 || punto < arroba + 2 || punto + 2 > email.length()) {
            return false;
        }
        return true;
    }

    public static String validarContrasinal(String contrasinal) {
        if (contrasinal == null || contrasinal.length() < 8 ) {
            return "La contraseña no es lo suficientemente larga.";
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
            } else if ("@#$%^&+=".indexOf(c) >= 0) {
                tieneCaracterEspecial = true;
            }
        }
        return "tieneNumero: " + tieneNumero + " | tieneLetra: " + tieneLetra + " | tieneLetra: " + tieneCaracterEspecial;
    }

    public static boolean validarWeb(String web) {
        if (web == null || web.isEmpty()) {
            return false;
        }
        try {
            new java.net.URL(web).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarNacemento(Date nacemento) {
        if (nacemento == null) {
            return false;
        }
        Date dataActual = new Date();
        return nacemento.before(dataActual);
    }

}
