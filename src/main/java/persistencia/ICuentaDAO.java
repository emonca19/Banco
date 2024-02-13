/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import entidadesPOJO.Cuenta;
import entidadesPOJO.Folio;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public interface ICuentaDAO {
    
    /**
     *
     * @param numeroCuentaEmisora
     * @param numeroCuentaReceptora
     * @param cantidad
     * @return la cantidad de dinero que se transfirio -1 si no se
     * efectuo la transfercnia
     * @throws PersistenciaException
     */
    public int transferenciaDinero(int numeroCuentaEmisora, int numeroCuentaReceptora, int cantidad) throws PersistenciaException;
    
    /**
     *
     * @param cuentaDTO
     * @return el saldo de la cuenta especificada
     */
    public int revisarSaldo(CuentaDTO cuentaDTO);
    
    /**
     *
     * @param numeroCuenta
     * @param cantidad
     * @return la cantidad de dinero que se tiene en la cuenta especifica
     */
    public int retirarDinero(int numeroCuenta, int cantidad);
    
    /**
     *
     * @param cuenta
     * @return cuentaDTO con los datos de la cuenta creada, null en caso
     * contrario
     */
    public CuentaDTO crearCuenta(Cuenta cuenta);
    
    /**
     *
     * @param cuenta
     * @return cuentaDTO con los daso de la cuenta buscada, null en caso
     * contrario
     */
    public CuentaDTO buscarCuentaPorNumeroCuenta(Cuenta cuenta);
    
    /**
     *
     * @param folio
     * @param contrasenia
     * @param numeroCuenta
     * @return 1 si se verifico el retiro -1 en caso contrario
     */
    public int verificarRetiroSinCuenta(int folio, int contrasenia, int numeroCuenta);
    
    /**
     *
     * @param nombre
     * @param folio
     * @param contrasenia
     * @param numeroCuenta
     * @return 1 si se efectueo con exito -1 en caso contrario
     */
    public int efectuarRetiroSinCuenta(String nombre, int folio, int contrasenia, int numeroCuenta);
    
    /**
     *
     * @param monto
     * @param numeroCuenta
     * @return folio para retirar
     */
    public Folio generarFolioRetiroSinCuenta(int monto, int numeroCuenta);
    
    
}
