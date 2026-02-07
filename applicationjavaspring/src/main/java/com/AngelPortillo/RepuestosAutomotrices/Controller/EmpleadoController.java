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
    public ResponseEntity<?> deleteEmpleado(@PathVariable Integer id){
        try {
            empleadosService.deleteEmpleado(id);
            return ResponseEntity.ok("Empleado Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleado(@PathVariable Integer id, @RequestBody Empleados empleados) {

        try {
            Empleados actualizado = empleadosService.updateEmpleado(id, empleados);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
