package org.example;

import org.example.cliente.Cliente;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //pruba de llamar a cliente
        Cliente cliente = new Cliente("P2145","Richard Parker");
        System.out.println(cliente.toString());
    }
}