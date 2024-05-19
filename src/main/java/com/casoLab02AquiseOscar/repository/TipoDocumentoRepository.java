package com.casoLab02AquiseOscar.repository;

import com.casoLab02AquiseOscar.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Long> {
}
