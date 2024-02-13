package DTOS;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class ClienteDTO {

    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String fechaNacimiento;
    private int edad;
    private String correo;
    private String contrasenia;

    public ClienteDTO() {
    }
    
    
    
    public ClienteDTO(int id, String nombres, String apellidoPaterno, String apellidoMaterno, String calle, String colonia, String codigoPostal, String fechaNacimiento, int edad, String correo, String contrasenia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String calle, String colonia, String codigoPostal, String fechaNacimiento, String correo, String contrasenia) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

//    public void guardarCuenta(Cuenta cuenta, int idCliente) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/banco";
//        String usuario = "root";
//        String contraseña = "2004";
//
//        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
//            String sql = "INSERT INTO CUENTA (USUARIO, CONTRASEÑA, FECHA_APERTURA, SALDO, IDCLIENTE) VALUES (?,?,?,?,?)";
//            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//                // Establecer los valores de los parámetros
//                preparedStatement.setString(1, cuenta.getUsuario());
//                preparedStatement.setString(2, cuenta.getContraseña());
//                preparedStatement.setString(3, cuenta.getFechaApertura());
//                preparedStatement.setInt(4, cuenta.getSaldo());
//                preparedStatement.setInt(5, idCliente);
//
//                // Ejecutar la inserción
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void guardarCliente(Cliente cliente) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/banco";
//        String usuario = "root";
//        String contraseña = "2004";
//
//        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
//            String sql = "INSERT INTO Cliente (GMAIL,ESTADO , CIUDAD, FECHA_NACIMIENTO, CODIGO_POSTAL, CALLE, NUMERO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//
//                preparedStatement.setString(1, cliente.getEmail());
//                preparedStatement.setString(2, cliente.getEstado());
//                preparedStatement.setString(3, cliente.getCiudad());
//                preparedStatement.setString(4, cliente.getFechaNacimiento());
//                preparedStatement.setInt(5, cliente.getCodigoPostal());
//                preparedStatement.setString(6, cliente.getCalle());
//                preparedStatement.setInt(7, cliente.getNumero());
//                preparedStatement.setString(8, cliente.getPrimerNombre());
//                if (cliente.getSegundoNombre() != null) {
//                    preparedStatement.setString(9, cliente.getSegundoNombre());
//                } else {
//                    preparedStatement.setString(9, "No registrado");
//                }
//                preparedStatement.setString(10, cliente.getApellidoPaterno());
//                preparedStatement.setString(11, cliente.getApellidoMaterno());
//
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
////void listar() {
////    String sql = "select * from clientes where ESTA_ELIMINADO =0 ";
////    try {
////        cn = con.getConnection();
////        st = cn.createStatement();
////        rs = st.executeQuery(sql);
////        Object[] cliente = new Object[6]; 
////        modelo = (DefaultTableModel) TablaClientes.getModel();
////
////
////        while (rs.next()) {
////            cliente[0] = rs.getInt("IDCLIENTE");
////            cliente[1] = rs.getString("NOMBRE");
////            cliente[2] = rs.getString("APELLIDO_PATERNO");
////            cliente[3] = rs.getString("APELLIDO_MATERNO");
////            cliente[4] = rs.getString("ESTA_ELIMINADO");
////            cliente[5] = rs.getString("FECHA_HORA_REGISTRO");
////            
////            // Agregar la fila al modelo
////            modelo.addRow(cliente);
////        }
////        TablaClientes.setModel(modelo);
////    } catch (Exception e) {
////        e.printStackTrace();
////    }
////}



    
}
