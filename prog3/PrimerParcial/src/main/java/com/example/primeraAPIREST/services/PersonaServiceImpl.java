package com.example.primeraAPIREST.services;

import com.example.primeraAPIREST.entities.Persona;
import com.example.primeraAPIREST.repositories.BaseRepository;
import com.example.primeraAPIREST.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrAppellidoContaining(filtro,filtro);
            List<Persona> personas = personaRepository.search(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
