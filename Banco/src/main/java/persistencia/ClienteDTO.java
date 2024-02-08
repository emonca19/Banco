package persistencia;

import entidadesPOJO.Cuenta;
import entidadesPOJO.Nombre;
import entidadesPOJO.Cliente;
import entidadesPOJO.Domicilio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ClienteDTO  {

    public void guardarNombres(Nombre nom) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";
       

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String sql = "INSERT INTO NOMBRE(PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, nom.getPrimerNombre());

                preparedStatement.setString(2,  nom.getSegundoNombre());

                preparedStatement.setString(3,  nom.getApellidoPaterno());
                
                preparedStatement.setString(4,  nom.getApellidoMaterno());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
    public void guardarDomicilio(Domicilio dom) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contraseña = "2004";

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "INSERT INTO DOMICILIO (CODIGO_POSTAL, CALLE, NUMERO) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, dom.getCodigoPostal());
            preparedStatement.setString(2, dom.getCalle());
            preparedStatement.setInt(3, dom.getNumero());

            // Ejecutar la inserción
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
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
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void guardarCliente(Cliente cliente, int idNombre, int idDomicilio) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String sql = "INSERT INTO Cliente (IDCLIENTE, IDNOMBRE, IDDOMICILIO, GMAIL, FECHA_NACIMIENTO) VALUES (?,?,?,?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
               
                preparedStatement.setInt(1, cliente.getIdCliente());
                preparedStatement.setInt(2, idNombre);
                preparedStatement.setInt(3, idDomicilio);
                preparedStatement.setString(4, cliente.getEmail());
                preparedStatement.setString(5, cliente.getFechaNacimiento());
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//void listar() {
//    String sql = "select * from clientes where ESTA_ELIMINADO =0 ";
//    try {
//        cn = con.getConnection();
//        st = cn.createStatement();
//        rs = st.executeQuery(sql);
//        Object[] cliente = new Object[6]; 
//        modelo = (DefaultTableModel) TablaClientes.getModel();
//
//
//        while (rs.next()) {
//            cliente[0] = rs.getInt("IDCLIENTE");
//            cliente[1] = rs.getString("NOMBRE");
//            cliente[2] = rs.getString("APELLIDO_PATERNO");
//            cliente[3] = rs.getString("APELLIDO_MATERNO");
//            cliente[4] = rs.getString("ESTA_ELIMINADO");
//            cliente[5] = rs.getString("FECHA_HORA_REGISTRO");
//            
//            // Agregar la fila al modelo
//            modelo.addRow(cliente);
//        }
//        TablaClientes.setModel(modelo);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
}



