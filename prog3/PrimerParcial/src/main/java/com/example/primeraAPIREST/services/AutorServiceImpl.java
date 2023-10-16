package com.example.primeraAPIREST.services;

import com.example.primeraAPIREST.entities.Autor;
import com.example.primeraAPIREST.repositories.AutorRepository;
import com.example.primeraAPIREST.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl <Autor,Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

}
