package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class ConexionBD implements IConexionBD{
final String SERVER = "localhost";
    final String BASE_DATOS = "proyectobanco";
    private final String CADENA_CONEXION = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;
    final String USUARIO = "root";
    final String CONTRASEÑA = "Itson";
    
    /**
     *
     * @return conexion efectuada
     * @throws SQLException
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
        return conexion;   
    }

}
