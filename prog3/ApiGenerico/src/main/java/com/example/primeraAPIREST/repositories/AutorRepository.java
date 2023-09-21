package com.example.primeraAPIREST.repositories;

import com.example.primeraAPIREST.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
}
