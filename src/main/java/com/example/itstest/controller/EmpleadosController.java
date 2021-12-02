package com.example.itstest.controller;


import com.example.itstest.dto.EmpleadoDTO;
import com.example.itstest.dto.EmpleadoUpdateDTO;
import com.example.itstest.model.Empleados;
import com.example.itstest.service.EmpleadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadosController {
    private final EmpleadosService empleadosService;

    public EmpleadosController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @PostMapping(path = "/employee/add")
    public @ResponseBody ResponseEntity<Empleados> addNewEmployee(@RequestBody EmpleadoDTO empleadoDTO) throws ParseException {
        Empleados empleados = new Empleados();
        Optional<Empleados> oldEmployee = empleadosService.findByIdEmployee(empleadoDTO.getIdentificacion());
        if(oldEmployee.isPresent()){
            return ResponseEntity.badRequest().body(null);
        }
        empleados.setIdentificacion(empleadoDTO.getIdentificacion());
        empleados.setNombres(empleadoDTO.getNombres());
        empleados.setApellidos(empleadoDTO.getApellidos());
        Date born = new SimpleDateFormat("dd-mm-yyyy").parse(empleadoDTO.getFechaNacimiento());
        int years = calculateAge(born);
        empleados.setEdad(years);
        empleados.setFechaNacimiento(born);
        empleados.setCargo(empleadoDTO.getCargo());

        Empleados saved = empleadosService.saveEmployee(empleados);

        return ResponseEntity.ok().body(saved);

    }

    @GetMapping(path = "employee")
    public ResponseEntity<List<Empleados>> getAllEmployees(){
        List<Empleados> empleados = (List<Empleados>) empleadosService.findAllEmployees();
        return ResponseEntity.ok().body(empleados);
    }

    @GetMapping(path = "employee/{id}")
    public ResponseEntity<Empleados> getEmployeeById(@PathVariable Integer id){
        Optional<Empleados> empleados = empleadosService.findByIdEmployee(id);
        return ResponseEntity.ok().body(empleados.get());
    }

    @PutMapping(path = "employee/update/{id}")
    public ResponseEntity<Empleados> updateEmployee(@PathVariable Integer id, @RequestBody EmpleadoUpdateDTO empleadoUpdateDTO) throws ParseException {
        Optional<Empleados> empleadosOptional= empleadosService.findByIdEmployee(id);
        if(!empleadosOptional.isPresent()){
            return ResponseEntity.badRequest().body(null);
        }
        Empleados empleados = empleadosOptional.get();
        empleados.setNombres(empleadoUpdateDTO.getNombres());
        empleados.setApellidos(empleadoUpdateDTO.getApellidos());
        if(empleadoUpdateDTO.getFechaNacimiento() != null){
            Date born = new SimpleDateFormat("dd-mm-yyyy").parse(empleadoUpdateDTO.getFechaNacimiento());
            int years = calculateAge(born);
            empleados.setEdad(years);
            empleados.setFechaNacimiento(born);
        }
        empleados.setCargo(empleadoUpdateDTO.getCargo());
        Empleados saved = empleadosService.saveEmployee(empleados);
        return ResponseEntity.ok().body(saved);
    }

    public int calculateAge(Date born){
        Instant instant = born.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate bornDate = zone.toLocalDate();
        Period period = Period.between(bornDate, LocalDate.now());
        return period.getYears();
    }
}
