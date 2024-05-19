package com.casoLab02AquiseOscar.service;

import com.casoLab02AquiseOscar.dtos.ClienteCreateDTO;
import com.casoLab02AquiseOscar.dtos.ClienteDTO;
import com.casoLab02AquiseOscar.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);
}
