package com.example.primeraAPIREST.entities;

import com.example.primeraAPIREST.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Domicilio extends Base {
    private String calle;
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;


}

