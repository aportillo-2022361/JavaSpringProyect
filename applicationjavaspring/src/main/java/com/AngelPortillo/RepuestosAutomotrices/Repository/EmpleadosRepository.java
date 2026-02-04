package com.AngelPortillo.RepuestosAutomotrices.Repository;

import com.AngelPortillo.RepuestosAutomotrices.Model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

}
