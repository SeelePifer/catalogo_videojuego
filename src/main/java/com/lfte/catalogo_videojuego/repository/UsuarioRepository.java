package com.lfte.catalogo_videojuego.repository;

import com.lfte.catalogo_videojuego.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findOneByNombre(String username);
}
