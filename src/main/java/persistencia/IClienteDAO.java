/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IClienteDAO {
    
    /**
     *
     * @param limit
     * @param offset
     * @return una lista de los clientes
     */
    public List<ClienteDTO> buscarListaTabla(int limit, int offset);

    /**
     *
     * @param id
     * @return la informacion del cliente a buscar null si no se encuentra
     */
    public ClienteDTO buscarPorIdEmpleado(int id);

    /**
     *
     * @param clienteDTO
     * @return regresa el cliente guardado, null si no se guardo
     */
    public ClienteDTO guardar(ClienteDTO clienteDTO);

    /**
     *
     * @param clienteDTO
     * @return cliente editado null si no se edito
     */
    public ClienteDTO editar(ClienteDTO clienteDTO);

    /**
     *
     * @param clienteDTO
     * @return cliente eliminado null si no se elimino
     */
    public ClienteDTO eliminar(ClienteDTO clienteDTO);
    
    /**
     *
     * @param correo
     * @param contrasenia
     * @return cliente buscado null si no se encontro
     */
    public ClienteDTO buscarPorCorreoContrasenia(String correo, String contrasenia);
    
    /**
     *
     * @param cuentaDTO
     * @return cliente buscadp null si no se encontro
     */
    public ClienteDTO buscarPorCuenta(CuentaDTO cuentaDTO);
    
    
}
