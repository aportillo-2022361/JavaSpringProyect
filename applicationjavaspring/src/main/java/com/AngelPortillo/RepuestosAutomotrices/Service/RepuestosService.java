package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestosService {
    List<Repuestos> getAllRepuestos();
    Repuestos saveRepuestos (Repuestos repuestos);
    Repuestos updateRepestos (Integer id, Repuestos repuestos);
    void deleteRepuestos (Integer id);
}
