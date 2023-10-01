package com.example.primeraAPIREST.services;

import com.example.primeraAPIREST.entities.Localidad;
import com.example.primeraAPIREST.entities.Persona;
import com.example.primeraAPIREST.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService{
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }


}
