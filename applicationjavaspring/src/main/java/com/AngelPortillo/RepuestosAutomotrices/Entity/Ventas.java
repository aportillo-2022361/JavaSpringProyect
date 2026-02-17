package com.AngelPortillo.RepuestosAutomotrices.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @NotNull(message = "La fecha tiene que ir especificada")
    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @NotNull(message = "La cantidad debe ir especificada")
    @Positive(message = "La cantidad debe ser positiva")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El total debe ir especificado")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "El id del empleado debe ir especificado")
    @Positive(message = "El id del empleado debe ser positivo")
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @NotNull(message = "El id del repuesto debe ir especificado")
    @Positive(message = "El id del repuesto debe ir positivo")
    @Column(name = "id_repuesto")
    private Integer idRepuesto;

    //Getters and Setters


    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }
}
