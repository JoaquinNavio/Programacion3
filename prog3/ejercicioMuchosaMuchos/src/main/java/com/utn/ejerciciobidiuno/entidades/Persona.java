package com.utn.ejerciciobidiuno.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "persona")
@EqualsAndHashCode(callSuper=false)
public class Persona extends BaseEntidad {
    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private int edad;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "persona_domicilio",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @EqualsAndHashCode.Exclude
    @Builder.Default


    private Set<Domicilio> domicilios= new HashSet<>();





    public void agregarDomicilio(Domicilio dom){
        domicilios.add(dom);
    }
    public void mostrarDomicilio(){
        System.out.println("Domicilios de: "+nombre+" "+apellido);
        for (Domicilio dom:domicilios) {
            System.out.println(dom.getCalle()+" "+dom.getNumero()+" id:"+dom.getId());
        }
    }
}
