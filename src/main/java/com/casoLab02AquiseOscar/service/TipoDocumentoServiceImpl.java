package com.casoLab02AquiseOscar.service;

import com.casoLab02AquiseOscar.dtos.TipoDocumentoDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumentoUpdateDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumetoCreateDTO;
import com.casoLab02AquiseOscar.mappers.TipoDocumentoMapper;
import com.casoLab02AquiseOscar.model.TipoDocumento;
import com.casoLab02AquiseOscar.repository.ClienteRepository;
import com.casoLab02AquiseOscar.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

    @Autowired
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public List<TipoDocumentoDTO> listarTipoDocumento() {
        return TipoDocumentoMapper.instancia.listaTipoDocumentoAlistaTipoDocumentoDTO( tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDTO obtenerTipoDocumentoPorID(long id) {
        Optional<TipoDocumento> tipoDocumento=tipoDocumentoRepository.findById(id);
        TipoDocumentoDTO tipoDocumentoDTO=null;
        if(tipoDocumento.isPresent()){
            tipoDocumentoDTO=TipoDocumentoMapper.instancia.tipoDocumentoADocumentoDTO(tipoDocumento.get());
        }
        return tipoDocumentoDTO;
    }

    @Override
    public TipoDocumentoDTO registrarTipoDocumento(TipoDocumetoCreateDTO tipoDocumentoCreateDTO) {
        TipoDocumento tipoDocumento=TipoDocumentoMapper.instancia.tipoDocumentoCreateDTOATipoDocumento(tipoDocumentoCreateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        return TipoDocumentoMapper.instancia.tipoDocumentoADocumentoDTO(respuestaEntity);
    }

    @Override
    public TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO) {
        TipoDocumento tipoDocumento=TipoDocumentoMapper.instancia.tipoDocumentoUpdateTOTipoDocumento(tipoDocumentoUpdateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        return TipoDocumentoMapper.instancia.tipoDocumentoADocumentoDTO(respuestaEntity);
    }

    @Override
    public String eliminarTipoDocumento(long id) {
        Optional<TipoDocumento> tipoDocumentoOptional=tipoDocumentoRepository.findById(id);
        if(tipoDocumentoOptional.isPresent()){
            tipoDocumentoRepository.delete(tipoDocumentoOptional.get());
            return "Registro Eliminado";
        } else{
            return "No se pudo realizar la eliminacion";
        }
    }
}
