package persistencia;

import entidadesPOJO.Cuenta;
import entidadesPOJO.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.CapturarDatos;

public class ClienteDTO {

    //Metodos para guardar

    /**
     * Metodo utilizado para guardar una cuenta en la base de datos
     * @param cuenta Cuenta creada con los atributos que le corresponden
     * @param idCliente idCliente del cliente a asociar a la cuenta
     * @throws SQLException 
     */
    public void guardarCuenta(Cuenta cuenta, int idCliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String sql = "INSERT INTO CUENTA (USUARIO, CONTRASEÑA, FECHA_APERTURA, SALDO, IDCLIENTE) VALUES (?,?,?,?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                // Establecer los valores de los parámetros
                preparedStatement.setString(1, cuenta.getUsuario());
                preparedStatement.setString(2, cuenta.getContraseña());
                preparedStatement.setString(3, cuenta.getFechaApertura());
                preparedStatement.setInt(4, cuenta.getSaldo());
                preparedStatement.setInt(5, idCliente);

                // Ejecutar la inserción
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
             Logger.getLogger(ClienteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo utilizado para guardar cliente ingresado en la base de datos
     * @param cliente Cliente creado con sus respectivos datos
     * @throws SQLException 
     */
    public void guardarCliente(Cliente cliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String sql = "INSERT INTO Cliente (GMAIL,ESTADO , CIUDAD, FECHA_NACIMIENTO, CODIGO_POSTAL, CALLE, NUMERO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

                preparedStatement.setString(1, cliente.getEmail());
                preparedStatement.setString(2, cliente.getEstado());
                preparedStatement.setString(3, cliente.getCiudad());
                preparedStatement.setString(4, cliente.getFechaNacimiento());
                preparedStatement.setInt(5, cliente.getCodigoPostal());
                preparedStatement.setString(6, cliente.getCalle());
                preparedStatement.setInt(7, cliente.getNumero());
                preparedStatement.setString(8, cliente.getPrimerNombre());
                if (cliente.getSegundoNombre() != null) {
                    preparedStatement.setString(9, cliente.getSegundoNombre());
                } else {
                    preparedStatement.setString(9, "No registrado");
                }
                preparedStatement.setString(10, cliente.getApellidoPaterno());
                preparedStatement.setString(11, cliente.getApellidoMaterno());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Metodos para verificar
    
    /**
     * Metodo que verifica la existencia en la base de datos de algun usuario
     * @param nombreUsuario Usuario a verificar existencia
     * @return Verdadero si ya existe, falso si no existe
     * @throws SQLException Excepcion de mysql
     */
    public static boolean verificarUsuario(String nombreUsuario) throws SQLException {
        ConexionBD conexionBD = new ConexionBD();

        String sql = "Select count(*) from cuenta where usuario = ?";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, nombreUsuario);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    int cantidadUsuarios = result.getInt(1);
                    return cantidadUsuarios > 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    

    
     /**
      * Metodo que verifica que el usuario y la contraseña coincidan en la base de datos
      * @param usuario Usuario a verificar
      * @param contraseña Contraseña a verificar
      * @return True si el usuario coincide con la contraseña, false en caso contrario
      */
    public static boolean verificarContraseña(String usuario, String contraseña) {
    ConexionBD conexionBD = new ConexionBD();
    String sql = "SELECT Contraseña FROM CUENTA WHERE USUARIO = ?";

    try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

        preparedStatement.setString(1, usuario);

        try (ResultSet result = preparedStatement.executeQuery()) {
            if (result.next()) {
                // Obtener la contraseña almacenada en la base de datos
                String contraseñaAlmacenada = result.getString("Contraseña");

                // Obtener la contraseña ingresada por el usuario
                String contraseñaIngresada = contraseña;

                // Verificar si las contraseñas coinciden
                return contraseñaAlmacenada.equals(contraseñaIngresada);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(ClienteDTO.class.getName()).log(Level.SEVERE, null, ex);
        // Manejar la excepción adecuadamente
    }

    // Si no se encontró el usuario o hubo un error en la base de datos, devolver false
    return false;
}
    
    /**
     * Metodo que verifica que un email este asociado a un cliente
     * @param email Email ingresado a verificar
     * @return True si el email si coincide con algun registro de cliente, false en caso contrario
     */
    public static boolean verificarEmail(String email){
        int idUsuario = -1;
        ConexionBD conexionBD = new ConexionBD();

        String sql = "SELECT IDCLIENTE FROM CLIENTE WHERE GMAIL = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    idUsuario = result.getInt("IDCLIENTE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapturarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUsuario>0;
    }
    
    
    // Metodos para obtener id
    
    /**
     * Metodo que obtiene el idCliente del cliente asociado a un email 
     * @param email Email asociado a cliente
     * @return idCliente del cliente asociado a email, -1 si no existe
     */
    public static int obtenerIdCliente(String email) {
        int idCliente = -1;
        ConexionBD conexionBD = new ConexionBD();
        String sql = "SELECT IDCLIENTE FROM CLIENTE WHERE GMAIL = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    idCliente = result.getInt("IDCLIENTE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapturarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCliente;
    }

    /**
     * Metodo que obtiene el idCuenta de alguna cuenta asociada a un usuario
     * @param usuario Usuario asociado a cuenta
     * @return IdCuenta de la cuenta asociada al usuario, -1 si no existe
     */
    public static int obtenerIdCuenta(String usuario) {
        int idCuenta = -1;
        ConexionBD conexionBD = new ConexionBD();

        String sql = "SELECT IDCUENTA FROM CUENTA WHERE USUARIO = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    idCuenta = result.getInt("IDCUENTA");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapturarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCuenta;
    }
}
