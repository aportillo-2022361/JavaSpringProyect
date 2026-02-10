package com.AngelPortillo.RepuestosAutomotrices.Controller;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Repuestos;
import com.AngelPortillo.RepuestosAutomotrices.Service.RepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {
    private final RepuestosService repuestosService;

    public RepuestosController(RepuestosService repuestosService) {
        this.repuestosService = repuestosService;
    }

    @GetMapping
    public List<Repuestos> getAllRepuestos() {
        return repuestosService.getAllRepuestos();
    }

    @PostMapping
    public ResponseEntity<Object> createRepuesto(@Valid @RequestBody Repuestos repuestos) {
        try {
            Repuestos createRepuesto = repuestosService.saveRepuestos(repuestos);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRepuesto(@PathVariable Integer id, @RequestBody Repuestos repuestos) {
        try {
            Repuestos updatedRepuesto = repuestosService.updateRepestos(id, repuestos);
            return ResponseEntity.ok(updatedRepuesto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepuestos(@PathVariable Integer id) {
        try {
            repuestosService.deleteRepuestos(id);
            return ResponseEntity.ok("Repuesto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
