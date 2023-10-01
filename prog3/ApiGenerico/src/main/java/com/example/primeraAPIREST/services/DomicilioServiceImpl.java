package com.example.primeraAPIREST.services;

import com.example.primeraAPIREST.entities.Domicilio;
import com.example.primeraAPIREST.entities.Persona;
import com.example.primeraAPIREST.repositories.BaseRepository;
import com.example.primeraAPIREST.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioServiceImpl  extends BaseServiceImpl<Domicilio,Long> implements DomicilioService{
    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
