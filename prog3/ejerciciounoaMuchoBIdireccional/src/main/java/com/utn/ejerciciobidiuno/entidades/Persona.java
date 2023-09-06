package com.utn.ejerciciobidiuno.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    @Builder.Default
    private List<Domicilio> domicilios=new ArrayList<>();

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
