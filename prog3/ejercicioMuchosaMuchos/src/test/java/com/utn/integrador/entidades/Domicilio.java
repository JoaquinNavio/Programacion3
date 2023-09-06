package com.utn.integrador.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {

    private String calle;
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Persona persona;
}