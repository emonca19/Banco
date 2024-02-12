/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesPOJO;

/**
 *
 * @author PC
 */
public class Folio {
    
    private int folio;
    private int contraseniaTemporal;
    private int monto;
    private int numeroCuenta;
    private String estado;

    public Folio(int folio, int contraseniaTemporal, int monto, int numeroCuenta, String estado) {
        this.folio = folio;
        this.contraseniaTemporal = contraseniaTemporal;
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
        this.folio = folio;
    }

    public Folio() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getContraseniaTemporal() {
        return contraseniaTemporal;
    }

    public void setContraseniaTemporal(int contraseniaTemporal) {
        this.contraseniaTemporal = contraseniaTemporal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
    
}
