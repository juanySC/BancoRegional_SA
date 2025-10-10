package org.example;

import org.example.cliente.Cliente;
import org.example.transaccion.TipoTransaccion;
import org.example.transaccion.Transaccion;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //LLAMANDO A CLASE CLIENTE
        Cliente cliente = new Cliente("P2145","Richard Parker");
        System.out.println(cliente.toString());

        //LLAMANDO A CLASE TRANSACCION
        Transaccion trans = new Transaccion(TipoTransaccion.DEPOSITO, 78.9, LocalDateTime.now(),"P100",10);
        System.out.println(trans.toString());

    }

}