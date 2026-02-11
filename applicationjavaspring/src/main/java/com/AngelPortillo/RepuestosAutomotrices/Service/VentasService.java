package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas saveVentas (Ventas ventas);
    Ventas updateVentas (Integer id, Ventas ventas);
    void deleteVentas (Integer id);
}
