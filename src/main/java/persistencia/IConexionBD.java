/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author elimo
 */
public interface IConexionBD {
    
    /**
     *
     * @return coneccion de bd
     * @throws SQLException
     */
    public Connection crearConexion()throws SQLException;
    
}
