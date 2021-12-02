package com.example.itstest.dto;

public class EmpleadoUpdateDTO {
    private String nombres;
    private Integer edad;
    private String apellidos;
    private String fechaNacimiento;
    private String cargo;

    public EmpleadoUpdateDTO() {
    }

    public String getNombres() {
        return nombres;
    }

    public Integer getEdad() {
        return edad;
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
