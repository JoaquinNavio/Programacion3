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

    @Override
    public List<Localidad> findAll() throws Exception {
        return null;
    }

    @Override
    public Localidad findById(Long aLong) throws Exception {
        return null;
    }

    @Override
    public Localidad save(Localidad entity) throws Exception {
        return null;
    }

    @Override
    public Localidad update(Long aLong, Localidad entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws Exception {
        return false;
    }
}
