package com.utn.muchoamuchos.repositorios;

import com.utn.muchoamuchos.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
