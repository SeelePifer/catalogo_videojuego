package com.lfte.catalogo_videojuego.service.impl;

import com.lfte.catalogo_videojuego.exception.ModeloNotFoundException;
import com.lfte.catalogo_videojuego.model.Videojuego;
import com.lfte.catalogo_videojuego.repository.VideojuegoRepository;
import com.lfte.catalogo_videojuego.service.VideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoJuegoServiceImpl implements VideoJuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Override
    public List<Videojuego> findAll() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Videojuego findById(long id) {
        Optional<Videojuego> optional = videojuegoRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
        }
        return optional.get();
    }

    @Override
    public Videojuego save(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public Videojuego update(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public boolean delete(long id) {
        Optional<Videojuego> optional = videojuegoRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        videojuegoRepository.deleteById(id);
        return true;
    }
}
