package com.utn.muchoamuchos.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Domicilio extends BaseEntidad {

    private String calle;
    private int numero;

    @ManyToMany(mappedBy = "domicilios")
    @Builder.Default
    private Set<Persona> personas= new HashSet<>();
}