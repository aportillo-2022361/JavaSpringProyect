package com.AngelPortillo.RepuestosAutomotrices.Controller;

import com.AngelPortillo.RepuestosAutomotrices.Model.Empleados;
import com.AngelPortillo.RepuestosAutomotrices.Service.EmpleadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadosService empleadosService;
    public EmpleadoController(EmpleadosService empleadosService) {this.empleadosService = empleadosService;}

    @GetMapping
    public List<Empleados> getAllEmpleados(){return empleadosService.getAllEmpleados();}

    @PostMapping
    public ResponseEntity<Object> createEmpleado(Empleados empleados) {
        return null;
    }
}
