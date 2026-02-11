package com.AngelPortillo.RepuestosAutomotrices.Controller;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Ventas;
import com.AngelPortillo.RepuestosAutomotrices.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas () {
        return ventasService.getAllVentas();
    }

    @PostMapping
    public ResponseEntity<Object> createVenta (@Valid @RequestBody Ventas ventas) {
        try {
            Ventas createVenta = ventasService.saveVentas(ventas);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta (@PathVariable Integer id, @Valid @RequestBody Ventas ventas) {
        try {
            Ventas updateVenta = ventasService.updateVentas(id, ventas);
            return ResponseEntity.ok(updateVenta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta (@PathVariable Integer id) {
        try {
            ventasService.deleteVentas(id);
            return ResponseEntity.ok("Venta eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
