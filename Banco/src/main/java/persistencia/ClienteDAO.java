package persistencia;

import entidadesPOJO.Nombre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import presentacion.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente insertarCliente(Cliente cliente, Connection conexion) throws PersistenciaException {
        
        return null;
        
    }

    @Override
    public Cliente generarUsuario() throws PersistenciaException {
        
        return null;
        
    }
    
    private void guardarNombres(Nombre nom) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";
        
        String[] nombres = separarNombres();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            conexion.setAutoCommit(false);
            String sql = "INSERT INTO NOMBRE(PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, nombres[0]);

                preparedStatement.setString(2,  nombres[1]);

                preparedStatement.setString(3,  txtApellidoPaterno.getText());
                
                preparedStatement.setString(4,  txtApellidoMaterno.getText());
                preparedStatement.executeUpdate();
            }
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private void guardarDomicilio(Domicilio dom) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contraseña = "2004";

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "INSERT INTO DOMICILIO (CODIGO_POSTAL, CALLE, NUMERO) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, Integer.parseInt(txtCP.getText()));
            preparedStatement.setString(2, txtCalle.getText());
            preparedStatement.setInt(3, Integer.parseInt(txtNumExterior.getText()));

            // Ejecutar la inserción
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    private void guardarCliente(Cliente cliente) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String contraseña = "2004";
        
        String[] nombres = separarNombres();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String sql = "INSERT INTO Cliente (GMAIL,FECHA_NACIMIENTO) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, (comboBoxAño.getSelectedItem()+"/"+comboBoxMes.getSelectedItem()+"/"+comboBoxDia.getSelectedItem()));
                preparedStatement.setString(2, txtEmail.getText());
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


void listar() {
    String sql = "select * from clientes where ESTA_ELIMINADO =0 ";
    try {
        cn = con.getConnection();
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        Object[] cliente = new Object[6]; 
        modelo = (DefaultTableModel) TablaClientes.getModel();


        while (rs.next()) {
            cliente[0] = rs.getInt("IDCLIENTE");
            cliente[1] = rs.getString("NOMBRE");
            cliente[2] = rs.getString("APELLIDO_PATERNO");
            cliente[3] = rs.getString("APELLIDO_MATERNO");
            cliente[4] = rs.getString("ESTA_ELIMINADO");
            cliente[5] = rs.getString("FECHA_HORA_REGISTRO");
            
            // Agregar la fila al modelo
            modelo.addRow(cliente);
        }
        TablaClientes.setModel(modelo);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}


