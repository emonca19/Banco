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
    
    
    
    public List<ClienteDTO> buscarListaTabla(int limit, int offset);

    public ClienteDTO buscarPorIdEmpleado(int id);

    public ClienteDTO guardar(ClienteDTO clienteDTO);

    public ClienteDTO editar(ClienteDTO clienteDTO);

    public ClienteDTO eliminar(ClienteDTO clienteDTO);
    
    public ClienteDTO buscarPorCorreoContrasenia(String correo, String contrasenia);
    
    public ClienteDTO buscarPorCuenta(CuentaDTO cuentaDTO);
    
    
}
