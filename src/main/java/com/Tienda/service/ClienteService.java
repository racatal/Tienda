package com.Tienda.service;

import com.Tienda.domain.Cliente;
import java.util.List;

/**
 *
 * @author Cata Valverde
 */
public interface ClienteService {
    public List<Cliente> getClientes();
    public Cliente getCliente(Cliente cliente);
    public void save(Cliente cliente); //tanto para insertar como modificar un registro
    public void delete(Cliente cliente);
    
    
    
    
}
