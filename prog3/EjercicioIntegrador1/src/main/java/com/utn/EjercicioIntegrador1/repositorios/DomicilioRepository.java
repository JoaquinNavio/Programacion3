package com.utn.EjercicioIntegrador1.repositorios;

import com.utn.EjercicioIntegrador1.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
