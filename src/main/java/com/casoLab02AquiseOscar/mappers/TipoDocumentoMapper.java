package com.casoLab02AquiseOscar.mappers;

import com.casoLab02AquiseOscar.dtos.TipoDocumentoDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumentoUpdateDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumetoCreateDTO;
import com.casoLab02AquiseOscar.model.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocumentoMapper {
    TipoDocumentoMapper instancia = Mappers.getMapper(TipoDocumentoMapper.class);

    TipoDocumentoDTO tipoDocumentoADocumentoDTO(TipoDocumento tipoDocumento);
    TipoDocumento tipoDocumentoDTOATipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumento tipoDocumentoCreateDTOATipoDocumento(TipoDocumetoCreateDTO tipoDocumetoCreateDTO);
    TipoDocumento tipoDocumentoUpdateTOTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);

    List<TipoDocumentoDTO> listaTipoDocumentoAlistaTipoDocumentoDTO(List<TipoDocumento> listaTipoDocumento);

}
