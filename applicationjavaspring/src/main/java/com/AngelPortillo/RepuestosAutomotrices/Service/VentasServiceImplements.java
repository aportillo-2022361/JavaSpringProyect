package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Ventas;
import com.AngelPortillo.RepuestosAutomotrices.Repository.VentasRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas saveVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas existingVentas = ventasRepository.findById(id).orElseThrow(() ->  new RuntimeException("La venta ya existe"));

        existingVentas.setFechaVenta(ventas.getFechaVenta());
        existingVentas.setCantidad(ventas.getCantidad());
        existingVentas.setTotal(ventas.getTotal());
        existingVentas.setIdEmpleado(ventas.getIdEmpleado());
        existingVentas.setIdRepuesto(ventas.getIdRepuesto());

        return ventasRepository.save(existingVentas);
    }

    @Override
    public void deleteVentas(Integer id) {
        ventasRepository.deleteById(id);
    }
}
