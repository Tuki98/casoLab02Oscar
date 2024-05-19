package com.casoLab02AquiseOscar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String dni;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 200, nullable = false)
    private String apePaterno;

    @Column(length = 200, nullable = false)
    private String apeMaterno;

    @Column(name="fechaNacimiento", nullable = false)
    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @Column(length = 200, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoDoc")
    private TipoDocumento tipodocumento;

}
