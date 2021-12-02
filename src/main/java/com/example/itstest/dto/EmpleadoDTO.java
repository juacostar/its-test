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

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
