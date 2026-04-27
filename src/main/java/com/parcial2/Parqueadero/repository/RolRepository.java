package com.parcial2.Parqueadero.repository;

import com.parcial2.Parqueadero.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByTipo(String tipo);
}