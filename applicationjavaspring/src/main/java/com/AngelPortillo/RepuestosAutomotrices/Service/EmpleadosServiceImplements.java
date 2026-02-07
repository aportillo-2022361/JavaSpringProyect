package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Model.Empleados;
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
        return empleadosRepository.save(empleados);
    }

    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleados) {
        Empleados existingEmpleado = empleadosRepository.findById(id).orElseThrow(() -> new RuntimeException("El empleado no existe"));

        existingEmpleado.setNombreEmpleado(empleados.getNombreEmpleado());
        existingEmpleado.setApellidoEmpleado(empleados.getApellidoEmpleado());
        existingEmpleado.setPuestoEmpleado(empleados.getPuestoEmpleado());
        existingEmpleado.setEmailEmpleado(empleados.getEmailEmpleado());

        return empleadosRepository.save(existingEmpleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadosRepository.deleteById(id);
    }
}
