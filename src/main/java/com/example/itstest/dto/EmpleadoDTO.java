package com.example.itstest.dto;

import java.util.Date;

public class EmpleadoDTO {
    private Integer identificacion;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String cargo;

    public EmpleadoDTO() {
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }
}
