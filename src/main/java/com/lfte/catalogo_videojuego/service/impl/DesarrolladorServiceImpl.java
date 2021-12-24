package com.lfte.catalogo_videojuego.service.impl;

import com.lfte.catalogo_videojuego.exception.ModeloNotFoundException;
import com.lfte.catalogo_videojuego.model.Desarrollador;
import com.lfte.catalogo_videojuego.repository.DesarrolladorRepository;
import com.lfte.catalogo_videojuego.service.DesarrolladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

    @Autowired
    private DesarrolladorRepository desarrolladorRepository;

    @Override
    public List<Desarrollador> findAll() {
        return desarrolladorRepository.findAll();
    }

    @Override
    public Desarrollador findById(long id) {
        Optional<Desarrollador> optional = desarrolladorRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        return optional.get();
    }

    @Override
    public Desarrollador save(Desarrollador desarrollador) {
        return desarrolladorRepository.save(desarrollador);
    }

    @Override
    public Desarrollador update(Desarrollador id) {
        return desarrolladorRepository.save(id);
    }

    @Override
    public boolean delete(long id) {
        Optional<Desarrollador> optional = desarrolladorRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        desarrolladorRepository.deleteById(id);
        return true;
    }
}
