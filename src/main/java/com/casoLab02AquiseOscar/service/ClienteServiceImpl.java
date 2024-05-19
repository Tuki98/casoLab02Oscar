package com.casoLab02AquiseOscar.service;

import com.casoLab02AquiseOscar.dtos.ClienteCreateDTO;
import com.casoLab02AquiseOscar.dtos.ClienteDTO;
import com.casoLab02AquiseOscar.dtos.ClienteUpdateDTO;
import com.casoLab02AquiseOscar.mappers.ClienteMapper;
import com.casoLab02AquiseOscar.mappers.TipoDocumentoMapper;
import com.casoLab02AquiseOscar.model.Cliente;
import com.casoLab02AquiseOscar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> listarClientes() {

        return ClienteMapper.instancia.listaClientesAListaClientesDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> cliente= clienteRepository.findById(id);
        ClienteDTO clienteDTO=null ;
        if(cliente.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente.get());
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);
        return ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
            Cliente cliente=ClienteMapper.instancia.clienteUpdateDTOACliente((clienteUpdateDTO));
            Cliente respuestaEntity=clienteRepository.save(cliente);
            return ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
    }

    @Override
    public String eliminarCliente(long id) {
        Optional<Cliente> clienteOptional=clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
            return "Registro Eliminado";
        } else {
            return "No se pudo realizar la eliminacion";
        }
    }
}
