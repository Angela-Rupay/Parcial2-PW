package com.parcial2.Parqueadero.repository;

import com.parcial2.Parqueadero.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);

    List<Usuario> findByRol_Tipo(String tipo);
}