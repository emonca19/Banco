package entidadesPOJO;

import java.util.Date;

public class Cuenta {
    
    private int numeroCuenta;
    private int saldo;
    private String fechaApertura;
    private int idCliente;
    private int estado;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor con todos los campos

    public Cuenta(int numeroCuenta, int saldo, String fechaApertura, int idCliente, int estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public Cuenta(int idCliente, int saldo, int estado) {
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cuenta(int saldo, int idCliente) {
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    


}
