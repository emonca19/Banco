/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import presentacion.Cliente;

/**
 *
 * @author elimo
 */
public interface IClienteDAO {
    
    public Cliente insertarCliente(Cliente cliente, Connection conexion) throws PersistenciaException;
    
    public Cliente generarUsuario() throws PersistenciaException;
    
    
}
