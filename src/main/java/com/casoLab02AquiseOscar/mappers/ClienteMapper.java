package com.casoLab02AquiseOscar.mappers;


import com.casoLab02AquiseOscar.dtos.ClienteCreateDTO;
import com.casoLab02AquiseOscar.dtos.ClienteDTO;
import com.casoLab02AquiseOscar.dtos.ClienteUpdateDTO;
import com.casoLab02AquiseOscar.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);

    List<ClienteDTO> listaClientesAListaClientesDTO(List<Cliente> listaCliente);
}
