package com.casoLab02AquiseOscar.controller;

import com.casoLab02AquiseOscar.dtos.*;
import com.casoLab02AquiseOscar.service.ClienteService;
import com.casoLab02AquiseOscar.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoDocumentoController {
    private final TipoDocumentoService tipoDocumentoService;
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService){this.tipoDocumentoService=tipoDocumentoService;}


    @GetMapping("tipoDocumento")
    public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumento(){
        return new ResponseEntity<>(tipoDocumentoService.listarTipoDocumento(), HttpStatus.OK);
    }
    @GetMapping("/tipoDocumento/{tipoDocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDocumentoPorId(@PathVariable("tipoDocumentoId") long tipoDocumentoId){
        return new ResponseEntity<>(tipoDocumentoService.obtenerTipoDocumentoPorID(tipoDocumentoId),HttpStatus.OK);
    }
    @PostMapping("tipoDocumento")
    public ResponseEntity<TipoDocumentoDTO> registrarTipoDocumento(@RequestBody TipoDocumetoCreateDTO tipoDocumentoCreateDTO){
        return  new ResponseEntity <>(tipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDTO), HttpStatus.OK) ;
    }

    @PutMapping("tipoDocumento")
    public ResponseEntity<TipoDocumentoDTO> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO){
        return new ResponseEntity<>(tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/tipoDocumento/[tipoDocumentoId")
    public ResponseEntity<String>eliminarTipoDocumento(@PathVariable("tipoDocumentoId")long tipoDocumentoId){
        return new ResponseEntity<>(tipoDocumentoService.eliminarTipoDocumento(tipoDocumentoId),HttpStatus.OK);
    }

}
