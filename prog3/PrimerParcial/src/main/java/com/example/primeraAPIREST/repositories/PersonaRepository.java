package com.example.primeraAPIREST.repositories;

import com.example.primeraAPIREST.entities.Base;
import com.example.primeraAPIREST.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    //anotacion metodo de query
    List<Persona> findByNombreContainingOrAppellidoContaining(String nombre, String apellido);




    //anotacion jpql parametros indexados
    @Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro' OR p.appellido LIKE '%:filtro%'")
    List<Persona> search(@Param("filtro") String filtro);


}
