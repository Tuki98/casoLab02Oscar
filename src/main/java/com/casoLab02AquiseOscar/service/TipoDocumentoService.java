package com.casoLab02AquiseOscar.service;

import com.casoLab02AquiseOscar.dtos.TipoDocumentoDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumentoUpdateDTO;
import com.casoLab02AquiseOscar.dtos.TipoDocumetoCreateDTO;
import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumentoDTO> listarTipoDocumento();
    TipoDocumentoDTO obtenerTipoDocumentoPorID(long id);
    TipoDocumentoDTO registrarTipoDocumento(TipoDocumetoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    String eliminarTipoDocumento(long id);
}
