package junit.tarefa9;

import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ValidatorFalse {
    @Test
    public void ValidatorFalse() {

    }
    @Test
    public void testFechaMal() {
        boolean resultado = Validator.validarNacemento(null);
        assertFalse(resultado);
    }
    @Test
    public void testFechaMayor() {
        LocalDate fecha = LocalDate.of(2030, 10, 10);
        boolean resultado = Validator.validarNacemento(fecha);
        assertFalse(resultado);
    }
    @Test
    public void testContrasinalVacio() {
        boolean resultado = Validator.validarContrasinal(null);
        assertFalse(resultado);
    }

    @Test
    public void testEmail() {
        boolean resultado = Validator.validarEmail(null);
        assertFalse(resultado);
    }
    @Test
    public void testValidarWeb() {
        boolean resultado = Validator.validarWeb(null);
        assertFalse(resultado);
    }
}
