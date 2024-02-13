/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verificadores;

import DTOS.ClienteDTO;
import entidadesPOJO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.ConexionBD;
import persistencia.IConexionBD;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class VerificarValidar {
    
    public VerificarValidar(){
        
        
        
    }
    
    /**
     *
     * @param numeroCuenta
     * @return 1 si existe, -1 si no existe
     */
    public int validarNumeroCuenta(int numeroCuenta){
        
        IConexionBD conexionBD = new ConexionBD();
        String sql = "SELECT COUNT(*) AS total FROM cuentas WHERE numeroCuenta = ?;";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, numeroCuenta);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    
                    int total = result.getInt("total");
                    if(total > 0){
                        
                        return 1;
                        
                    }
                }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        return -1;
        
    }
    
    
    /**
     *
     * @param cliente
     * @return true si el correo existe falso en caso contrario
     */
    public boolean verificarCorreoExistente(Cliente cliente) {
        ConexionBD conexionBD = new ConexionBD();
        String sql = "SELECT COUNT(*) AS total FROM clientes WHERE correo = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getCorreo());

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    // Obtener el total de filas que coinciden con el usuario en la base de datos
                    int total = result.getInt("total");

                    // Si el total es mayor que cero, significa que el usuario existe
                    return total > 0;
                }
            }

        } catch (SQLException e) {
            
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        return false;
    
    }
    
    /**
     *
     * @param cliente
     * @return true si la contraseña existe, falso en caso contrario
     */
    public boolean verificarContraseña(Cliente cliente) {
        ConexionBD conexionBD = new ConexionBD();
        String sql = "SELECT contrasenia FROM clientes WHERE correo = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getCorreo());

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    // Obtener la contraseña almacenada en la base de datos
                    String contraseñaAlmacenada = result.getString("contrasenia");

                    // Obtener la contraseña ingresada por el usuario
                    String contraseñaIngresada = cliente.getContrasenia();

                    // Verificar si las contraseñas coinciden
                    return contraseñaAlmacenada.equals(contraseñaIngresada);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        // Si no se encontró el usuario o hubo un error en la base de datos, devolver false
        return false;
}
   
}
