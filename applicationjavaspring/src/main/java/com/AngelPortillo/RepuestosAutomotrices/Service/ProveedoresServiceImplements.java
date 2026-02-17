package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Proveedores;
import com.AngelPortillo.RepuestosAutomotrices.Exception.MethodArgumentNotValidException;
import com.AngelPortillo.RepuestosAutomotrices.Exception.ResourceNotFoundException;
import com.AngelPortillo.RepuestosAutomotrices.Repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements implements ProveedoresService{
    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresServiceImplements(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<Proveedores> getallProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedores saveProveedor(Proveedores proveedores) throws RuntimeException {
        if (proveedores.getNombreProveedor() == null   || proveedores.getNombreProveedor().trim().isEmpty()
        ||  proveedores.getEmailProveedor() == null    || proveedores.getEmailProveedor().trim().isEmpty()
        ||  proveedores.getDireccion() == null         || proveedores.getDireccion().trim().isEmpty()
        ||  proveedores.getTelefonoProveedor() == null)
            throw new MethodArgumentNotValidException("Campos Vacios, Por favor rellenar todos los campos");
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedor(Integer id, Proveedores proveedores) {
        Proveedores existingProveedor = proveedoresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));

        existingProveedor.setNombreProveedor(proveedores.getNombreProveedor());
        existingProveedor.setTelefonoProveedor(proveedores.getTelefonoProveedor());
        existingProveedor.setDireccion(proveedores.getDireccion());
        existingProveedor.setEmailProveedor(proveedores.getEmailProveedor());

        return proveedoresRepository.save(existingProveedor);
    }

    @Override
    public void deleteProveedor(Integer id) {
        proveedoresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));
        proveedoresRepository.deleteById(id);
    }
}
