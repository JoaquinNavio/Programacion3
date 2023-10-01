package com.example.primeraAPIREST.repositories;

import com.example.primeraAPIREST.entities.Domicilio;
import com.example.primeraAPIREST.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long>{
}
