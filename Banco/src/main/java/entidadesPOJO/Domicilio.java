package entidadesPOJO;

public class Domicilio {

    private int idDomicilio;
    private int codigoPostal;
    private String calle;
    private int numero;
    private String colonia;

    // Constructores

    public Domicilio() {
        // Constructor vacío
    }

    public Domicilio(int idDomicilio, int codigoPostal, String calle, int numero, String colonia) {
        this.idDomicilio = idDomicilio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    // Getters y Setters

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
}

