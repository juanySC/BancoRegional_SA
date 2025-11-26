package Modelos;

public abstract class ClienteEmpresarial extends Cliente {

    //constructor
    public ClienteEmpresarial(String idCliente, String nombreCompleto) {
        super(idCliente, nombreCompleto);
    }

    //llamo a mi metodo de liminte diario de 50000
    @Override
    public double obtenerLimiteRetiroDiario(){
        return Cliente.LIMITE_EMPRESARIAL;
    }
}
