package Modelos;

public abstract class ClienteVIP extends Cliente {

    //constructor
    public ClienteVIP(String idCliente, String nombreCompleto) {
        super(idCliente, nombreCompleto);
    }

    //llamo a mi metodo del limiete diario de 10000
    @Override
    public double obtenerLimiteRetiroDiario(){
        return Cliente.LIMITE_VIP;
    }
    
}
