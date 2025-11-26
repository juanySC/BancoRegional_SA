package Excepciones;

/**
 * Excepción cuando ya se ha llegado al limite de los intentos 
 * entoces envia este error 
 */

public class CuentaBloqueadaExcepcion extends RuntimeException {
    public CuentaBloqueadaExcepcion(String mensaje) {
        super(mensaje);
    }

    public CuentaBloqueadaExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
