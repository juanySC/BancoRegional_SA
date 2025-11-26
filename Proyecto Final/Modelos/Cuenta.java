package Modelos;

import Enums.TipoCuenta;
import Excepciones.CampoInvalidoExcepcion;
import Excepciones.PinInvalidoExcepcion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta 
{
    // Constantes
    public static final int MAX_INTENTOS_FALLIDOS = 3;
    
    // Atributos
    private String numeroCuenta;
    private double saldo;
    private String pin;
    private TipoCuenta tipoCuenta;
    private Cliente titular;
    private List<Transaccion> historial; 
    private LocalDate fechaCreacion;
    
    private int intentosFallidos;
    private boolean bloqueada;  

    // Constructor
    public Cuenta(String numeroCuenta, String pin, TipoCuenta tipoCuenta, Cliente titular) 
    {
        validarCampos(numeroCuenta, pin, tipoCuenta, titular);

        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
        this.pin = pin;
        this.tipoCuenta = tipoCuenta;
        this.titular = titular;
        this.historial = new ArrayList<>();
        this.fechaCreacion = LocalDate.now();
        this.intentosFallidos = 0;
        this.bloqueada = false;
    }

    // Métodos
    public String mostrarDetallesCuenta()
    {
        return "---------------\n" +
               "Número de Cuenta: " + this.numeroCuenta + 
               "\nTipo de Cuenta: " + this.tipoCuenta + 
               "\nSaldo: " + String.format("%.2f", saldo) + 
               "\nTitular: " + this.titular.getNombreCompleto() +
               "\nFecha de Creación: " + this.fechaCreacion;
    }

    /**
     * Registra una transacción en el historial.
     * Si la transaccion es nula, lanza la excepcion.
     */
    public void agregarTransaccion(Transaccion transaccion) 
    {
        if (transaccion == null)
            throw new CampoInvalidoExcepcion("La transacción no puede ser nula.");
        historial.add(transaccion);
    }

    /**
     * Aplica un depósito a la cuenta: valida monto, actualiza saldo y registra la transacción.
     */
    public void aplicarDeposito(double monto, Transaccion transaccion)
    {
        if (monto <= 0)
            throw new Excepciones.MontoInvalidoExcepcion("El monto del depósito debe ser mayor que cero.");

        this.saldo += monto;
        agregarTransaccion(transaccion);
    }

    /**
     * Aplica un retiro a la cuenta: valida monto y fondos, actualiza saldo y registra la transacción.
     */
    public void aplicarRetiro(double monto, Transaccion transaccion)
    {
        if (monto <= 0)
            throw new Excepciones.MontoInvalidoExcepcion("El monto del retiro debe ser mayor que cero.");

        if (this.saldo < monto)
            throw new Excepciones.FondosInsuficientesExcepcion(this.numeroCuenta);

        this.saldo -= monto;
        agregarTransaccion(transaccion);
    }

    /**
     * Valida que los campos no estén vacíos o nulos y que el PIN tenga formato correcto.
     */
    private void validarCampos(String numeroCuenta, String pin, TipoCuenta tipoCuenta, Cliente titular)
    {
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty())
            throw new CampoInvalidoExcepcion("El número de cuenta no puede estar vacío.");

        validarPin(pin);

        if (tipoCuenta == null)
            throw new CampoInvalidoExcepcion("El tipo de cuenta no puede ser nulo.");

        if (titular == null)
            throw new CampoInvalidoExcepcion("El titular de la cuenta no puede ser nulo.");
    }

    /**
     * Valida que el PIN tenga exactamente 4 dígitos numéricos.
     * @throws PinInvalidoExcepcion si el PIN es inválido.
     */
    private void validarPin(String pin)
    {
        if (pin == null || pin.trim().isEmpty())
            throw new PinInvalidoExcepcion("El PIN no puede estar vacío.");

        if (!pin.matches("\\d{4}"))
            throw new PinInvalidoExcepcion("El PIN debe tener exactamente 4 dígitos numéricos.");
    }

    /**
     * Getters y Setters
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    // protected porque solo se modifica internamente mediante operaciones
    //eso significa que no puede ser modificado desde fuera de la clase o paquete
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        validarPin(pin);
        this.pin = pin;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Aqui no se permite cambiar el tipo de cuenta despues de creada.
     * El tipo de cuenta no puede quedar vacio ya que es un campo oblicatorio por la verificacion implementada.
     * 
     */
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        if (tipoCuenta == null)
            throw new CampoInvalidoExcepcion("El tipo de cuenta no puede ser nulo.");
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente getTitular() {
        return titular;
    }

    /**
     * No se permite 
     */
    public void setTitular(Cliente titular) {
        if (titular == null)
            throw new CampoInvalidoExcepcion("El titular de la cuenta no puede ser nulo.");
        this.titular = titular;
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Transaccion> historial) {
        if (historial == null)
            throw new CampoInvalidoExcepcion("El historial no puede ser nulo.");
        this.historial = historial;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece el saldo inicial al cargar desde almacenamiento sin crear transacciones.
     * Útil exclusivamente durante la reconstrucción al arrancar la aplicación.
     */
    public void cargarSaldoInicial(double nuevoSaldo) {
        if (nuevoSaldo < 0) throw new Excepciones.MontoInvalidoExcepcion("Saldo inicial inválido.");
        this.saldo = nuevoSaldo;
    }


    /**
     * Verifica si la cuenta está bloqueada por los intentos
     * @return true si la cuenta está bloqueada, false lo contrario
     */
    public boolean estaBloqueada() {
        return bloqueada;
    }

    /**
     * Obtiene el número de los intentos hechos fallidos
     * @return número intentos 
     */
    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    /**
     * Incrementa el contador para esto se utiliza el final para 
     * Si este llega a 3 entonces la cuenta se bloquea 
     */
    public void incrementarIntentosFallidos() {
        this.intentosFallidos++;
        if (this.intentosFallidos >= MAX_INTENTOS_FALLIDOS) {
            this.bloqueada = true;
        }
    }

    /**
     * Reinicia los intentos fallidos a 0 para comenzar de nuevo estto 
     * para cuando el usuario de nuevo entre al sistema
     */
    public void reiniciarIntentosFallidos() {
        this.intentosFallidos = 0;
    }

    /**
     * Desbloquea la cuenta (opcional, para administración).
     */
    public void desbloquearCuenta() {
        this.bloqueada = false;
        this.intentosFallidos = 0;
    }

    /**
     * Obtiene el resultado o muestra el estado del bloque
     * @return true = bloqueado, false = no esta bloqueado 
     */
    public boolean isBloqueada() {
        return bloqueada; //regresa un valor si esta bloqueado o no 
    }

    /**
     * Establece el estado de bloqueo 
     * @param bloqueada true = bloquear , false = no esta bloqueado
     */
    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada; //regresa un valor y se lo asiga al atributo 
    }
}
