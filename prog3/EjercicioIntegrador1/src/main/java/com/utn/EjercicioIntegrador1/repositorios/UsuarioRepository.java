package com.utn.EjercicioIntegrador1.repositorios;

import com.utn.EjercicioIntegrador1.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
