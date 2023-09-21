package com.example.primeraAPIREST.repositories;

import com.example.primeraAPIREST.entities.Base;
import com.example.primeraAPIREST.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
}
