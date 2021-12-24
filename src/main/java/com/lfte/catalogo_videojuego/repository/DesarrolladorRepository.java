package com.lfte.catalogo_videojuego.repository;

import com.lfte.catalogo_videojuego.model.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador,Long> {
}
