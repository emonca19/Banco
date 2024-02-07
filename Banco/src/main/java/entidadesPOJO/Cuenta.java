package entidadesPOJO;

import java.util.Date;

public class Cuenta {
    private int idCuenta;
    private String usuario;
    private String contraseña;
    private String fechaApertura;
    private int saldo;
    private int idCliente;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor con todos los campos
    public Cuenta(int idCuenta, String usuario, String contraseña, String fechaApertura, int saldo, int idCliente) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    // Getters y setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }



}
