package persistencia;

import java.sql.Connection;
import presentacion.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente insertarCliente(Cliente cliente, Connection conexion) throws PersistenciaException {
        
        return null;
        
    }

    @Override
    public Cliente generarUsuario() throws PersistenciaException {
        
    }
    
    

}
