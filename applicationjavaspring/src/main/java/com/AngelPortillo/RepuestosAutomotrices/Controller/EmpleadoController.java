package com.AngelPortillo.RepuestosAutomotrices.Controller;

import com.AngelPortillo.RepuestosAutomotrices.Model.Empleados;
import com.AngelPortillo.RepuestosAutomotrices.Service.EmpleadosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadosService empleadosService;
    public EmpleadoController(EmpleadosService empleadosService) {this.empleadosService = empleadosService;}

    @GetMapping
    public List<Empleados> getAllEmpleados(){return empleadosService.getAllEmpleados();}

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleados empleados) {
        try {
            Empleados createdEmpleado = empleadosService.saveEmpleado(empleados);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable Integer id) {
        try {
            Empleados deleteEmpleado = empleadosService.deleteEmpleado(id);
            return ResponseEntity.ok("Cliente eliminado correctament;e");
        }catch () {
        }
    }
}
