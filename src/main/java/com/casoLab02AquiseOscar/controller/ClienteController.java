package com.casoLab02AquiseOscar.controller;

import com.casoLab02AquiseOscar.dtos.ClienteCreateDTO;
import com.casoLab02AquiseOscar.dtos.ClienteDTO;
import com.casoLab02AquiseOscar.dtos.ClienteUpdateDTO;
import com.casoLab02AquiseOscar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ClienteController {

    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService){this.clienteService=clienteService;}

    @GetMapping("cliente")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return   new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("clienteId") long clienteId){
        return  new ResponseEntity<> ( clienteService.obtenerClientePorID(clienteId),HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){
        return  new ResponseEntity <>( clienteService.registrarCliente(clienteCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("cliente")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return new ResponseEntity<>(clienteService.actualizarCliente(clienteUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/cliente/[clienteId")
    public ResponseEntity<String>eliminarCliente(@PathVariable("clienteId")long clienteId){
        return new ResponseEntity<>(clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }

}
