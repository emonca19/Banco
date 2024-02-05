package clientes.itson.edu.clientes_247782;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Clientes {

    public static void main(String[] args) throws SQLException {
        String cadenaConexion = "jdbc:mysql://localhost/clientes";
        Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "2004");
        Statement comando = conexion.createStatement();
//
//        try {
//
//            comando.executeUpdate("insert into clientes (nombre, apellido_paterno, apellido_materno, esta_eliminado, fecha_hora_registro) values ('Eliana', 'Monge', 'Cámara', 1, '2022-01-23 12:30:00')");
//
//            conexion.close();
//            System.out.println("Se registraron los datos");
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//        try {
//
//            String consulta = "select nombre, apellido_paterno, apellido_materno from clientes where NOMBRE = 'Eliana'";
//            ResultSet registro = comando.executeQuery(consulta);
//            if (registro.next()) {
//                System.out.println(registro.getString("nombre"));
//                System.out.println(registro.getString("apellido_paterno"));
//            } else {
//                System.out.println("No existe un artículo con dicho código");
//            }
//            conexion.close();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        
//        try {
//
//            String consulta = "update clientes set nombre = 'Maria' where NOMBRE = 'Eliana'";
//            int registro = comando.executeUpdate(consulta);
//            if (registro > 0) {
//                System.out.println("Se actualizo el nombre de "+registro+" clientes");
//            } else {
//                System.out.println("No existe un artículo con dicho código");
//            }
//            conexion.close();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
        
        try {

            String consulta = "delete from clientes where NOMBRE = 'Maria'";
            int registro = comando.executeUpdate(consulta);
            if (registro > 0) {
                System.out.println("Se actualizo el nombre de "+registro+" clientes");
            } else {
                System.out.println("No existe un artículo con dicho código");
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
