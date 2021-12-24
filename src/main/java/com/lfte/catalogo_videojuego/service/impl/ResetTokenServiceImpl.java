package com.lfte.catalogo_videojuego.service.impl;

import com.lfte.catalogo_videojuego.model.ResetToken;
import com.lfte.catalogo_videojuego.repository.ResetTokenRepository;
import com.lfte.catalogo_videojuego.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);
    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}
