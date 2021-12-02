package com.example.itstest;

import com.example.itstest.dto.EmpleadoDTO;
import com.example.itstest.model.Empleados;
import com.example.itstest.service.EmpleadosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ItsTestApplication.class)
@AutoConfigureMockMvc
public class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmpleadosService empleadosService;

    private final Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();

    private final ObjectMapper objectMapper = mapperBuilder.build();

    Empleados createEmployee(){
        Empleados empleados = new Empleados();
        empleados.setIdentificacion(121212);
        empleados.setNombres("Prueba");
        empleados.setApellidos("Apellido prueba");
        empleados.setFechaNacimiento(new Date());
        empleados.setCargo("Cargo prueba");
        this.empleadosService.saveEmployee(empleados);
        return empleados;
    }

    @Test
    void addNewEmployee() throws Exception{
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        String uri= "/employee/add";
        Empleados empleados =  createEmployee();
        Empleados saved = empleadosService.findByIdEmployee(empleados.getIdentificacion()).get();
        assertEquals(saved.getIdentificacion(), empleadosService.findByIdEmployee(empleados.getIdentificacion()).get().getIdentificacion());
    }
}
