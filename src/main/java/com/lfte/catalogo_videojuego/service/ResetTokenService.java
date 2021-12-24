package com.lfte.catalogo_videojuego.service;

import com.lfte.catalogo_videojuego.model.ResetToken;

public interface ResetTokenService {
    ResetToken findByToken(String token);

    void guardar(ResetToken token);

    void eliminar(ResetToken token);
}
