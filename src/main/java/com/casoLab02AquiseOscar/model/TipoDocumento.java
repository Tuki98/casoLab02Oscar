package com.casoLab02AquiseOscar.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_tipo_documento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoDoc;

    @Column(length = 200, nullable = false)
    private String des_tipoDoc;
}
