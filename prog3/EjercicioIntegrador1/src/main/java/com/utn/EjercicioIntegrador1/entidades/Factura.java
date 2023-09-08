package com.utn.EjercicioIntegrador1.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura  extends BaseEntidad{
    private String fecha;
    private int numero;
    private double descuento;

    private int total;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    public enum FormaPago{
        EFECTIVO,ETC;
    }
}
