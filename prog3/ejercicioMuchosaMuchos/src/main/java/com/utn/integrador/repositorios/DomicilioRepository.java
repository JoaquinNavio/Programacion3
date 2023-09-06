package com.utn.integrador.repositorios;

import com.utn.integrador.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
