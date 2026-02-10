package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Repuestos;
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
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepestos(Integer id, Repuestos repuestos) {
        Repuestos existingRepuestos = repuestosRepository.findById(id).orElseThrow(() -> new RuntimeException("El repuesto ya existe"));

        existingRepuestos.setNombreRepuesto(repuestos.getNombreRepuesto());
        existingRepuestos.setCategoriaRepuesto(repuestos.getCategoriaRepuesto());
        existingRepuestos.setPrecioCompra(repuestos.getPrecioCompra());
        existingRepuestos.setPrecioVenta(repuestos.getPrecioVenta());

        return repuestosRepository.save(existingRepuestos);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        repuestosRepository.deleteById(id);
    }
}
