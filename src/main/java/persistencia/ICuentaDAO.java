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
 * @author PC
 */
public interface ICuentaDAO {
    
    public int transferenciaDinero(int numeroCuentaEmisora, int numeroCuentaReceptora, int cantidad) throws PersistenciaException;
    
    public int revisarSaldo(CuentaDTO cuentaDTO);
    
    public int retirarDinero(int numeroCuenta, int cantidad);
    
    public CuentaDTO crearCuenta(Cuenta cuenta);
    
    public CuentaDTO buscarCuentaPorNumeroCuenta(Cuenta cuenta);
    
    public int verificarRetiroSinCuenta(int folio, int contrasenia, int numeroCuenta);
    
    public int efectuarRetiroSinCuenta(String nombre, int folio, int contrasenia, int numeroCuenta);
    
    public Folio generarFolioRetiroSinCuenta(int monto, int numeroCuenta);
    
    
}
