package entidadesPOJO;

import java.sql.Date;

public class Cliente {

    private int idCliente;
    private int idNombre;
    private int idDomicilio;
    private Date fechaNacimiento;

    // Constructores

    public Cliente() {
        // Constructor vacío
    }

    public Cliente(int idCliente, int idNombre, int idDomicilio, Date fechaNacimiento) {
        this.idCliente = idCliente;
        this.idNombre = idNombre;
        this.idDomicilio = idDomicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(int idNombre) {
        this.idNombre = idNombre;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Otros métodos si es necesario

}



