import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Base64;

public class Usuario {
    // Atributos da clase Usuario
    private String correo;
    private String contrasinalHash;
    private String web;
    private LocalDate nacemento;

    // Constructor da clase Usuario
    public Usuario(String correo, String contrasinal, String web, LocalDate nacemento) {
        this.correo = correo;
        this.contrasinalHash = xerarHashContrasinal(contrasinal);
        this.web = web;
        this.nacemento = nacemento;
    }

    // Método para xerar o hash da contrasinal usando o algoritmo SHA-256
    private String xerarHashContrasinal(String contrasinal) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasinal.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Nunca debería suceder, pois SHA-256 é un algoritmo soportado
            throw new RuntimeException(e);
        }
    }

    // Métodos get e set para os atributos da clase Usuario
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasinalHash() {
        return contrasinalHash;
    }

    public void setContrasinalHash(String contrasinalHash) {
        this.contrasinalHash = contrasinalHash;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    // Método toString para amosar a información do usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", contrasinalHash='" + contrasinalHash + '\'' +
                ", web='" + web + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}
