package com.lfte.catalogo_videojuego.repository;

import com.lfte.catalogo_videojuego.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {

    ResetToken findByToken(String token);
}
