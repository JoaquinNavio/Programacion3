package com.utn.ejerciciobidiuno.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Domicilio extends BaseEntidad {

    private String calle;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "persona:id")
    private Persona persona;
}