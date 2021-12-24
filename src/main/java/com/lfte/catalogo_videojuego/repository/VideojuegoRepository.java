package com.lfte.catalogo_videojuego.repository;

import com.lfte.catalogo_videojuego.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
