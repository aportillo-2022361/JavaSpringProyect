package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Repuestos;
import com.AngelPortillo.RepuestosAutomotrices.Exception.BadRequestException;
import com.AngelPortillo.RepuestosAutomotrices.Exception.ResourceNotFoundException;
import com.AngelPortillo.RepuestosAutomotrices.Repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceImplements implements RepuestosService{
    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceImplements(RepuestosRepository repuestosRepository) {
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getAllRepuestos() {
        return repuestosRepository.findAll();
    }

    @Override
    public Repuestos saveRepuestos(Repuestos repuestos) {
        if (repuestos.getCategoriaRepuesto() == null || repuestos.getCategoriaRepuesto().trim().isEmpty()
        ||  repuestos.getNombreRepuesto() == null    || repuestos.getNombreRepuesto().trim().isBlank()
        ||  repuestos.getIdProveedor() == null
        ||  repuestos.getPrecioCompra() == null
        ||  repuestos.getPrecioVenta() == null)
            throw new BadRequestException("Campos Vacios, Por favor rellenar todos los campos");
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepestos(Integer id, Repuestos repuestos) {
        Repuestos existingRepuestos = repuestosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));

        existingRepuestos.setNombreRepuesto(repuestos.getNombreRepuesto());
        existingRepuestos.setCategoriaRepuesto(repuestos.getCategoriaRepuesto());
        existingRepuestos.setPrecioCompra(repuestos.getPrecioCompra());
        existingRepuestos.setPrecioVenta(repuestos.getPrecioVenta());

        return repuestosRepository.save(existingRepuestos);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        repuestosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));
        repuestosRepository.deleteById(id);
    }
}
