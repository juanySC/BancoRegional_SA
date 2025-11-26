package Modelos;

public abstract class ClienteNormal extends Cliente {

    //constructor 
    public ClienteNormal(String idCliente, String nombreCompleto) {
        super(idCliente, nombreCompleto);
        
    }

    //llamo al metodo y delimito el retiro diario 2000
    @Override
    public double obtenerLimiteRetiroDiario() {
        return Cliente.LIMITE_NORMAL;
    }
    
}
