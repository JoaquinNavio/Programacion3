package com.example.primeraAPIREST.services;

import com.example.primeraAPIREST.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona,Long>{
    List<Persona> search(String filtro) throws Exception;

}
