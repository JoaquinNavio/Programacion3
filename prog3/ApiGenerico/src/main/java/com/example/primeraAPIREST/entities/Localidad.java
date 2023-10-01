package com.example.primeraAPIREST.entities;

import com.example.primeraAPIREST.entities.Base;
import jakarta.persistence.Entity;
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
public class Localidad extends Base {

    private String denominacion;

}
