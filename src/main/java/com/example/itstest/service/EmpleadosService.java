package com.example.itstest.service;


import com.example.itstest.model.Empleados;
import com.example.itstest.repository.EmpleadosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadosService {
    private final EmpleadosRepository empleadosRepository;

    public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public Iterable<Empleados> findAllEmployees(){
        return empleadosRepository.findAll();
    }

    public Optional<Empleados> findByIdEmployee(Integer id){
        return empleadosRepository.findById(id);
    }

    public Empleados saveEmployee(Empleados empleados){
       return empleadosRepository.save(empleados);
    }

    public void deleteEmployeeById(Integer id){
        empleadosRepository.deleteById(id);
    }
}
