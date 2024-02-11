package persistencia;

import entidadesPOJO.Cliente;
import entidadesPOJO.Cuenta;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ClienteDAO {
    
    //Creacion de cuentas y clientes
    
    
    /**
     * Metodo para crear una cuenta
     * @param usuario Usuario asociado
     * @param contraseña Contraseña asociada
     * @param idCliente IdCliente asociado
     * @param idCuenta IdCuenta asociada
     * @return Cuenta creada
     */
    public Cuenta crearCuenta(String usuario, String contraseña,  int idCliente, int idCuenta ) {
        LocalDate fechaActual = LocalDate.now();
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario);
        cuenta.setFechaApertura(String.valueOf(fechaActual));
        cuenta.setContraseña(contraseña);
        cuenta.setIdCliente(idCliente);
        cuenta.setIdCuenta(idCuenta);
        cuenta.setSaldo(0);

        return cuenta;

    }
    
    /**
     * Metodo que crea un cliente
     * @param fechaNacimiento Fecha de nacimiento asociada
     * @param email Email asociado
     * @param EstadoRepublica Estado asociado
     * @param ciudad Ciudad asociada
     * @param nombresCliente Nombres asociados
     * @param apellidoPaterno Apellido paterno asociado
     * @param apellidoMaterno Apellido materno asociado
     * @param calle Calle asociada
     * @param codigoPostal CP asociado
     * @param numExterior Num exterior asociado
     * @return Cliente creado
     */
    public Cliente crearCliente(Date fechaNacimiento, String email, String EstadoRepublica, String ciudad, String nombresCliente, String apellidoPaterno, String apellidoMaterno, String calle, int codigoPostal, int numExterior) {


        // Formatear la fecha en el formato "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = sdf.format(fechaNacimiento);

        Cliente cliente = new Cliente();
        cliente.setFechaNacimiento(fechaFormateada);
        cliente.setEmail(email);
        cliente.setEstado(EstadoRepublica);
        cliente.setCiudad(ciudad);
        String[] nombres = separarNombres(nombresCliente);
        cliente.setPrimerNombre(nombres[0]);
        if (nombres.length != 1) {
            cliente.setSegundoNombre(nombres[1]);
        }
        cliente.setApellidoPaterno(apellidoPaterno);
        cliente.setApellidoMaterno(apellidoMaterno);
        cliente.setCalle(calle);
        cliente.setCodigoPostal(codigoPostal);
        cliente.setNumero(numExterior);

        return cliente;
        

    }
    
    /**
     * Metodo que separa nombres de un solo string separados por espacio
     * @param nombre a separar
     * @return Array de nombres separados
     */
    private String[] separarNombres(String nombre) {
        
        String[] nombres = nombre.split(" ");

        return nombres;

    }

}
