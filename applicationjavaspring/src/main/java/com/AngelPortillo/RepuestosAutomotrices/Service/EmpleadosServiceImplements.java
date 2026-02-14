package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Empleados;
import com.AngelPortillo.RepuestosAutomotrices.Exception.BadRequestException;
import com.AngelPortillo.RepuestosAutomotrices.Exception.ResourceNotFoundException;
import com.AngelPortillo.RepuestosAutomotrices.Repository.EmpleadosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosServiceImplements implements EmpleadosService{
    private final EmpleadosRepository empleadosRepository;

    public EmpleadosServiceImplements(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleados getEmpleadoById(Integer id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados saveEmpleado(Empleados empleados) throws RuntimeException {
        if (empleados.getNombreEmpleado() == null          || empleados.getNombreEmpleado().trim().isEmpty()
                || empleados.getApellidoEmpleado() == null || empleados.getApellidoEmpleado().trim().isEmpty()
                || empleados.getEmailEmpleado() == null    || empleados.getEmailEmpleado().trim().isEmpty()
                || empleados.getPuestoEmpleado() == null   || empleados.getPuestoEmpleado().trim().isEmpty())
            throw new BadRequestException("Campos Vacios, Por favor rellenar todos los campos");
        return empleadosRepository.save(empleados);
    }
    
    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleados) {
        Empleados existingEmpleado = empleadosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));

        existingEmpleado.setNombreEmpleado(empleados.getNombreEmpleado());
        existingEmpleado.setApellidoEmpleado(empleados.getApellidoEmpleado());
        existingEmpleado.setPuestoEmpleado(empleados.getPuestoEmpleado());
        existingEmpleado.setEmailEmpleado(empleados.getEmailEmpleado());

        return empleadosRepository.save(existingEmpleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con ID " + id + " no existe"));
        empleadosRepository.deleteById(id);
    }
}
