package com.example.primeraAPIREST.repositories;

import com.example.primeraAPIREST.entities.Libro;
import com.example.primeraAPIREST.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository <Libro,Long> {
}
