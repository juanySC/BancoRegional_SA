package org.example.transaccion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transaccion {
    //atributos final porque no se puede modificar diante la ejecucion
    private final TipoTransaccion tipoTransaccion;
    private final double montoInvolucrado;
    private final LocalDateTime fechaHora;
    private final String idCuenta;
    private final double saldoResultante;

    //constructor

    public Transaccion(TipoTransaccion tipoTransaccion, double montoInvolucrado, LocalDateTime fechaHora, String idCuenta, double saldoResultante) {
        this.tipoTransaccion = tipoTransaccion;
        this.montoInvolucrado = montoInvolucrado;
        this.fechaHora = LocalDateTime.now();
        this.idCuenta = idCuenta;
        this.saldoResultante = saldoResultante;
    }

    //metodo


    //getter and setter

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public double getMontoInvolucrado() {
        return montoInvolucrado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getIdCuenta() {
        return idCuenta;
    }
    //no incluyo set porque el id es permanenete

    public double getSaldoResultante() {
        return saldoResultante;
    }

    //toString

    @Override
    public String toString() {
        return "Transaccion{" +
                "tipoTransaccion=" + tipoTransaccion +
                ", montoInvolucrado=" + montoInvolucrado +
                ", fechaHora=" + fechaHora +
                ", idCuenta='" + idCuenta + '\'' +
                ", saldoResultante=" + saldoResultante +
                '}';
    }
}
