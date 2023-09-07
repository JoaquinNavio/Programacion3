package com.utn.EjercicioIntegrador1.repositorios;

import com.utn.EjercicioIntegrador1.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral,Long> {
}
