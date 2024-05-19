package com.casoLab02AquiseOscar.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ClienteUpdateDTO {
    private Long id;
    private String dni;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaNacimiento;
    private String email;
}
