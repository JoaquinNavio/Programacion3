package com.utn.api.Servicios;

import com.utn.api.Entidades.Localidad;
import com.utn.api.Repositorios.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
