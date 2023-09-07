package com.utn.EjercicioIntegrador1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto  extends BaseEntidad{
    private String tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedia;
    private String foto;
    private String receta;


    @ManyToOne
    @JoinColumn(name = "Rubro_id")
    private Rubro rubro;
}
