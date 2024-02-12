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

/**
 *
 * @author PC
 */
public class VerificarClienteDTO {
    
    public VerificarClienteDTO(){
        
        
        
    }
    
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