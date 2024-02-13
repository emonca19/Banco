/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import entidadesPOJO.Cuenta;
import entidadesPOJO.Folio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amos Heli Olguin Quiroz


 */
public class CuentaDAO implements ICuentaDAO{

    private IConexionBD conexionBD;
    
    /**
     *
     * @param conexionBD
     */
    public CuentaDAO(IConexionBD conexionBD){
        
        this.conexionBD = conexionBD;
        
    }

    /**
     *
     * @param monto
     * @param numeroCuenta
     * @return
     */
    @Override
    public Folio generarFolioRetiroSinCuenta(int monto, int numeroCuenta) {
        
        Logger logger = Logger.getLogger(CuentaDAO.class.getName());
        String crearCuenta = """
        CALL retiroSinCuentaDinero(?,?);
        """;
        try{
            
            Connection conexion = conexionBD.crearConexion();
            CallableStatement comando = conexion.prepareCall(crearCuenta);
            
            comando.setInt(1, monto);
            comando.setInt(2, numeroCuenta);
            
            comando.execute();
            
//            int numeroRegistrosInsertados = comando.executeUpdate();
//            logger.log(Level.INFO, "Se generaron {0} retiros sin cuenta", numeroRegistrosInsertados);
            
            try (ResultSet resultSet = comando.getResultSet()) {
                if (resultSet.next()) {
                    int folioGenerado = resultSet.getInt("folio");
                    
                    String folios = "SELECT folio, contraseniaTemporal, monto, numeroCuenta, estado FROM retiroSinCuenta WHERE folio = ?";
                    try(Connection conexion2 = conexionBD.crearConexion();
                        PreparedStatement comando2 = conexion2.prepareStatement(folios);){
                        
                        comando2.setInt(1, folioGenerado);
                        
                        try (ResultSet result2 = comando2.executeQuery()) {
                            
                            if (result2.next()) {

                                Folio folio = new Folio();
                                folio.setFolio(result2.getInt("folio"));
                                folio.setContraseniaTemporal(result2.getInt("contraseniaTemporal"));
                                folio.setMonto(result2.getInt("monto"));
                                folio.setNumeroCuenta(result2.getInt("numeroCuenta"));
                                folio.setEstado(result2.getString("estado"));

                                return folio;

                            }

                        } 
                        
                    }

                } else {
                    
                    
                }
            }
            
        }catch(SQLException ex){
            
            logger.log(Level.SEVERE, "No se pudo generar ningun retiro sin cuenta", ex);
            
        }
        
        return null;
        
    }

    /**
     *
     * @param nombre
     * @param folio
     * @param contrasenia
     * @param numeroCuenta
     * @return
     */
    @Override
    public int efectuarRetiroSinCuenta(String nombre,int folio, int contrasenia, int numeroCuenta) {
    
        Logger logger = Logger.getLogger(CuentaDAO.class.getName());
        String crearCuenta = """
        CALL efectuarRetiroSinCuenta(?,?, ?, ?);
        """;
        try{
            
            Connection conexion = conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(crearCuenta);
            
            comando.setString(1, nombre);
            comando.setInt(3, folio);
            comando.setInt(4, contrasenia);
            comando.setInt(2, numeroCuenta);
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se cobraron {0} retiros sin cuenta", numeroRegistrosInsertados);
            
            String estado = "SELECT monto FROM retiroSinCuenta WHERE folio = ? AND contraseniaTemporal = ? AND numeroCuenta = ?;";
            try(PreparedStatement comando2 = conexion.prepareStatement(estado)){

                comando2.setInt(1, folio);
                comando2.setInt(2, contrasenia);
                comando2.setInt(3, numeroCuenta);

                try (ResultSet result2 = comando2.executeQuery()) {
                            
                    if (result2.next()) {

                        int monto = result2.getInt("monto");

                        return monto;

                    }

                } 
                    



            }
            
            
        }catch(SQLException ex){
            
            logger.log(Level.SEVERE, "No se pudo cobrar ningun retiro sin cuenta", ex);
            
        }
        
        return -1;
            
    }
    
    /**
     *
     * @param folio
     * @param contrasenia
     * @param numeroCuenta
     * @return
     */
    @Override
    public int verificarRetiroSinCuenta(int folio, int contrasenia, int numeroCuenta) {
        
        String sql = "SELECT COUNT(*) AS total FROM retiroSinCuenta WHERE folio = ? AND contraseniaTemporal = ? AND numeroCuenta = ?;";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, folio);
            preparedStatement.setInt(2, contrasenia);
            preparedStatement.setInt(3, numeroCuenta);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    
                    int total = result.getInt("total");
                    if(total > 0){
                        
                        String estado = "SELECT estado FROM retiroSinCuenta WHERE folio = ? AND contraseniaTemporal = ? AND numeroCuenta = ?;";
                        try(Connection conexion2 = conexionBD.crearConexion();
                            PreparedStatement comando2 = conexion2.prepareStatement(estado)){
                            
                            comando2.setInt(1, folio);
                            comando2.setInt(2, contrasenia);
                            comando2.setInt(3, numeroCuenta);
                            
                            
                            try (ResultSet result2 = comando2.executeQuery()) {
                            
                                if (result2.next()) {

                                    String estadoRetiro = result2.getString("estado");

                                    if(estadoRetiro.equalsIgnoreCase("No cobrado")){

                                        return 2;

                                    }else if(estadoRetiro.equalsIgnoreCase("Cobrado")){

                                        return 3;

                                    }else{
                                        
                                        return 1;
                                        
                                    }

                                }

                            }    

                        }
                    }    
                    
                        
                }
            }

        } catch (SQLException e) {
            
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        return -1;
        
    }
    
    /**
     *
     * @param cuenta
     * @return
     */
    @Override
    public CuentaDTO buscarCuentaPorNumeroCuenta(Cuenta cuenta) {
        
        String sql = "SELECT * FROM cuentas WHERE numeroCuenta = ?;";
        
        System.out.println("AAAAAAAAAAAAA" + cuenta.getNumeroCuenta());
        
        try (Connection conexion = conexionBD.crearConexion(); 
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, cuenta.getNumeroCuenta());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    // Crear un objeto Cliente con los datos de la base de datos
                    CuentaDTO cuentaDTO = new CuentaDTO();
                    
                    cuentaDTO.setNumeroCuenta(resultSet.getInt("numeroCuenta"));
                    cuentaDTO.setFechaApertura(resultSet.getString("fechaApertura"));
                    cuentaDTO.setSaldo(resultSet.getInt("saldo"));
                    cuentaDTO.setIdCliente(resultSet.getInt("idCliente"));
                    cuentaDTO.setEstado(resultSet.getInt("estado"));
                    
                    
                    return cuentaDTO;
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de la excepción en la práctica
        }

        return null; // Retorna null si no se encuentra el cliente
        
    }

    
    
    
    /**
     *
     * @param cuenta
     * @return
     */
    @Override
    public CuentaDTO crearCuenta(Cuenta cuenta) {
    
        Logger logger = Logger.getLogger(CuentaDAO.class.getName());
        String crearCuenta = "CALL crearCuenta(?, ?);";

        try (Connection conexion = conexionBD.crearConexion();
             CallableStatement comando = conexion.prepareCall(crearCuenta)) {

            comando.setInt(1, cuenta.getSaldo());
            comando.setInt(2, cuenta.getIdCliente());

            // Ejecutar el procedimiento almacenado
            boolean resultado = comando.execute();

            if (resultado) {
                logger.log(Level.INFO, "Se creó la cuenta con éxito");

                // Obtener el numeroCuenta directamente con una consulta SELECT
                try (ResultSet resultSet = comando.getResultSet()) {
                    if (resultSet.next()) {
                        int numeroCuentaP = resultSet.getInt("numeroCuenta");

                        cuenta.setNumeroCuenta(numeroCuentaP);

                        ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
                        CuentaDTO cuentaDTO = cuentaDAO.buscarCuentaPorNumeroCuenta(cuenta);

                        if (cuentaDTO == null) {
                            return null;
                        } else {
                            return cuentaDTO;
                        }
                    }
                }
            } else {
                logger.log(Level.SEVERE, "No se pudo crear la cuenta");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al ejecutar el procedimiento almacenado", ex);
        }

        return null;
        
        
        
    }

    /**
     *
     * @param numeroCuenta
     * @param cantidad
     * @return
     */
    @Override
    public int retirarDinero(int numeroCuenta, int cantidad) {
        
        Logger logger = Logger.getLogger(CuentaDAO.class.getName());
        String transferenciaDinero = """
        CALL retiroDinero(?, ?);
        """;
        try{
            Connection conexion = conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(transferenciaDinero);
            
            comando.setInt(1, numeroCuenta);
            comando.setInt(2, cantidad);
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se realizaron {0} retiros", numeroRegistrosInsertados);
                    
            String nuevoSaldo = """
            SELECT saldo FROM cuentas WHERE numeroCuenta = ?;
            """;
            
            
            try (PreparedStatement preparedStatement = conexion.prepareStatement(nuevoSaldo)) {

                preparedStatement.setInt(1, numeroCuenta);

                try (ResultSet result = preparedStatement.executeQuery()) {
                    if (result.next()) {
                        // Obtener el total de filas que coinciden con el usuario en la base de datos
                        int saldo = result.getInt("saldo");

                        return saldo;
                        
                    }
                }

            } catch (SQLException e) {

                e.printStackTrace();
                // Manejar la excepción adecuadamente
            }
            
        }catch(SQLException ex){
            
            logger.log(Level.SEVERE, "No se pudo realizar el retiro", ex);
            
        }
        
        return -1;
                
                
    }
    
    /**
     *
     * @param cuentaDTO
     * @return
     */
    @Override
    public int revisarSaldo(CuentaDTO cuentaDTO) {
        
        // Consulta SQL para obtener el saldo de la cuenta a partir del usuario
        String sql = "SELECT saldo FROM cuentas WHERE numeroCuenta = ?";
        try (Connection conexion = conexionBD.crearConexion(); 
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            // Se establece el valor del parámetro en la consulta SQL
            preparedStatement.setInt(1, cuentaDTO.getSaldo());
            try (ResultSet result = preparedStatement.executeQuery()) {
                // Si se encuentra un resultado en la consulta, se obtiene el saldo de la cuenta
                if (result.next()) {
                    int saldo = result.getInt("saldo");
                    return saldo;
                }
            }
        } catch (SQLException e) {
            // Se registra cualquier excepción ocurrida durante la ejecución del bloque de código
            e.getStackTrace();
        }
        // Si no se encuentra ningún resultado, se retorna un saldo de 0
        return -1;
        
    }
    
    /**
     *
     * @param numeroCuentaEmisora
     * @param numeroCuentaReceptora
     * @param cantidad
     * @return
     * @throws PersistenciaException
     */
    @Override
    public int transferenciaDinero(int numeroCuentaEmisora, int numeroCuentaReceptora, int cantidad) throws PersistenciaException {
    
        Logger logger = Logger.getLogger(CuentaDAO.class.getName());
        String transferenciaDinero = """
        CALL transferenciaDinero(?, ?, ?);
        """;
        try{
            Connection conexion = conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(transferenciaDinero);
            
            comando.setInt(1, numeroCuentaEmisora);
            comando.setInt(2, numeroCuentaReceptora);
            comando.setInt(3, cantidad);
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se realizaron {0} transferencias", numeroRegistrosInsertados);
                    
            String nuevoSaldo = """
            SELECT saldo FROM cuentas WHERE numeroCuenta = ?;
            """;
            
            
            try (PreparedStatement preparedStatement = conexion.prepareStatement(nuevoSaldo)) {

                preparedStatement.setInt(1, numeroCuentaEmisora);

                try (ResultSet result = preparedStatement.executeQuery()) {
                    if (result.next()) {
                        // Obtener el total de filas que coinciden con el usuario en la base de datos
                        int saldo = result.getInt("saldo");

                        return saldo;
                        
                    }
                }

            } catch (SQLException e) {

                e.printStackTrace();
                // Manejar la excepción adecuadamente
            }
            
        }catch(SQLException ex){
            
            logger.log(Level.SEVERE, "No se pudo realizar la transferencia", ex);
            
        }
        
        return -1;
        
    }
    
    
    
}
