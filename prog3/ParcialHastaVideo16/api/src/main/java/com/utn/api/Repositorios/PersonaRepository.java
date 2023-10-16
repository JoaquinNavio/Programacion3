package com.utn.api.Repositorios;

import com.utn.api.Entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //Metodo Query
    List<Persona> findByNombreContainingOrAppellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrAppellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsByDni(int dni);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?2%' OR p.appellido LIKE '%?1%'")
    List<Persona> search(String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?2%' OR p.appellido LIKE '%?1%'")
    Page<Persona> search(String filtro, Pageable pageable);

    //Anotacion JPQL parametros nombrados
    /*
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.appellido LIKE '%:filtro%'");
    List<Persona> serach(@Param("filtro") String filtro);*/

    //Anotacion Query nativo
    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
    nativeQuery = true)
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true)
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
