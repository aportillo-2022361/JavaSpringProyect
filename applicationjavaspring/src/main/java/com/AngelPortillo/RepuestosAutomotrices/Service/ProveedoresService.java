package com.AngelPortillo.RepuestosAutomotrices.Service;

import com.AngelPortillo.RepuestosAutomotrices.Entity.Proveedores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedoresService {
    List<Proveedores> getallProveedores();
    Proveedores saveProveedor (Proveedores proveedores) throws RuntimeException;
    Proveedores updateProveedor (Integer id, Proveedores proveedores);
    void deleteProveedor (Integer id);
}
