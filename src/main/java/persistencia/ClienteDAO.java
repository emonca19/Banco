package persistencia;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import entidadesPOJO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;
    
    public ClienteDAO(IConexionBD conexionBD){
        
        this.conexionBD = conexionBD;
        
    }

    @Override
    public ClienteDTO buscarPorCuenta(CuentaDTO cuentaDTO) {
        
        String sql = "SELECT * FROM clientes WHERE id = ?;";
        try (Connection conexion = conexionBD.crearConexion(); 
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, cuentaDTO.getIdCliente());
            
            System.out.println("antes del if");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear un objeto Cliente con los datos de la base de datos
                    ClienteDTO clienteDTO = new ClienteDTO();
                    clienteDTO.setId(resultSet.getInt("id"));
                    clienteDTO.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    clienteDTO.setNombres(resultSet.getString("nombres"));
                    clienteDTO.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                    clienteDTO.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                    clienteDTO.setCalle(resultSet.getString("calle"));
                    clienteDTO.setColonia(resultSet.getString("colonia"));
                    clienteDTO.setCodigoPostal(resultSet.getString("codigoPostal"));
                    clienteDTO.setEdad(resultSet.getInt("edad"));
                    clienteDTO.setCorreo("correo");
                    clienteDTO.setContrasenia("contrasenia");
                    
                    return clienteDTO;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de la excepción en la práctica
        }

        return null; // Retorna null si no se encuentra el cliente
        
    }

    
    
    @Override
    public ClienteDTO buscarPorCorreoContrasenia(String correo, String contrasenia) {
        
        String sql = "SELECT * FROM clientes WHERE correo = ? AND contrasenia = ?;";
        try (Connection conexion = conexionBD.crearConexion(); 
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasenia);
            
            System.out.println("antes del if");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear un objeto Cliente con los datos de la base de datos
                    ClienteDTO clienteDTO = new ClienteDTO();
                    clienteDTO.setId(resultSet.getInt("id"));
                    clienteDTO.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    clienteDTO.setNombres(resultSet.getString("nombres"));
                    clienteDTO.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                    clienteDTO.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                    clienteDTO.setCalle(resultSet.getString("calle"));
                    clienteDTO.setColonia(resultSet.getString("colonia"));
                    clienteDTO.setCodigoPostal(resultSet.getString("codigoPostal"));
                    clienteDTO.setEdad(resultSet.getInt("edad"));
                    clienteDTO.setCorreo(correo);
                    clienteDTO.setContrasenia(contrasenia);
                    
                    System.out.println("si cliente completo");
                    
                    return clienteDTO;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de la excepción en la práctica
        }

        return null; // Retorna null si no se encuentra el cliente
        
    }
    
    
    
        
    
    
    
    @Override
    public List<ClienteDTO> buscarListaTabla(int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO buscarPorIdEmpleado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO guardar(ClienteDTO clienteDTO) {
    
        Logger logger = Logger.getLogger(ClienteDAO.class.getName());
        String agregarUsuario = """
        CALL crearCliente(?, ?, ?, ?, ?, ?, ?, ?, ?);
        """;
        try{
            Connection conexion = conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(agregarUsuario);
            
            comando.setString(1, clienteDTO.getFechaNacimiento());
            comando.setString(2, clienteDTO.getNombres());
            comando.setString(3, clienteDTO.getApellidoPaterno());
            comando.setString(4, clienteDTO.getApellidoMaterno());
            comando.setString(5, clienteDTO.getCalle());
            comando.setString(6, clienteDTO.getColonia());
            comando.setString(7, clienteDTO.getCodigoPostal());
            comando.setString(8, clienteDTO.getCorreo());
            comando.setString(9, clienteDTO.getContrasenia());
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
                    
        }catch(SQLException ex){
            
            logger.log(Level.SEVERE, "No se pudo agregar el clientes", ex);
            
            
//            System.out.println(ex.getMessage());
            
        }
        
        return clienteDTO;
    
    }

    
    
    @Override
    public ClienteDTO editar(ClienteDTO cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO eliminar(ClienteDTO cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
//    @Override
//    public ClienteDAO guardarCliente(entidadesPOJO.Cliente cliente) throws PersistenciaException{
//        
//        return null;
//        
//    }
//    
////    @Override
////    public Cliente insertarCliente(Cliente cliente, Connection conexion) throws PersistenciaException {
////        
////        return null;
////        
////    }
////
////    @Override
////    public Cliente generarUsuario() throws PersistenciaException {
////        
////        return null;
////        
////    }
//    
//    private void guardarNombres(Nombre nom) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/banco";
//        String usuario = "root";
//        String contraseña = "2004";
//        
//        String[] nombres = separarNombres();
//
//        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
//            conexion.setAutoCommit(false);
//            String sql = "INSERT INTO NOMBRE(PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES (?,?,?,?)";
//            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//                preparedStatement.setString(1, nombres[0]);
//
//                preparedStatement.setString(2,  nombres[1]);
//
//                preparedStatement.setString(3,  txtApellidoPaterno.getText());
//                
//                preparedStatement.setString(4,  txtApellidoMaterno.getText());
//                preparedStatement.executeUpdate();
//            }
//            conexion.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    private void guardarDomicilio(Domicilio dom) throws SQLException {
//    String url = "jdbc:mysql://localhost:3306/banco";
//    String usuario = "root";
//    String contraseña = "2004";
//
//    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
//        String sql = "INSERT INTO DOMICILIO (CODIGO_POSTAL, CALLE, NUMERO) VALUES (?,?,?)";
//        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//            // Establecer los valores de los parámetros
//            preparedStatement.setInt(1, Integer.parseInt(txtCP.getText()));
//            preparedStatement.setString(2, txtCalle.getText());
//            preparedStatement.setInt(3, Integer.parseInt(txtNumExterior.getText()));
//
//            // Ejecutar la inserción
//            preparedStatement.executeUpdate();
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//    
//    private void guardarCliente(Cliente cliente) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/banco";
//        String usuario = "root";
//        String contraseña = "2004";
//        
//        String[] nombres = separarNombres();
//
//        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
//            String sql = "INSERT INTO Cliente (GMAIL,FECHA_NACIMIENTO) VALUES (?, ?)";
//            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//                preparedStatement.setString(1, (comboBoxAño.getSelectedItem()+"/"+comboBoxMes.getSelectedItem()+"/"+comboBoxDia.getSelectedItem()));
//                preparedStatement.setString(2, txtEmail.getText());
//                
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
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


