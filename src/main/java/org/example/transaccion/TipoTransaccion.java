/*el tipo que hare como retiro, deposito*/
package org.example.transaccion;

public enum TipoTransaccion {
    DEPOSITO("Dinero ingresado"),
    RETIRO("Retiro de dinero"),
    CONSULTA_CUENTA("Consultando saldo");

    //para que nos muestre simplemente lo que hace cada enum
    //en lugar de decir retiro = retiro de dinero en efectivo
    private final String descripcion;

    //ya que no me interesa que las demas clases vean el tipo
    private TipoTransaccion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter para obtener la descripción de los enum
    public String getDescripcion() {
        return descripcion;
    }
}
