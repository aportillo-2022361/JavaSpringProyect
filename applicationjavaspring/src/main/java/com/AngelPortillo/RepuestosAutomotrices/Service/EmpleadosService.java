package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Model.Empleados;

import java.util.List;

public interface EmpleadosService {
    List<Empleados> getAllEmpleados();
    Empleados getEmpleadoById(Integer id);
    Empleados saveEmpleado (Empleados empleados) throws RuntimeException;
    Empleados updateEmpleado (Integer id, Empleados empleados);
    void deleteEmpleado (Integer id);
}
