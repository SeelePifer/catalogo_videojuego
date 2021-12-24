package com.lfte.catalogo_videojuego.service.impl;

import com.lfte.catalogo_videojuego.exception.ModeloNotFoundException;

import com.lfte.catalogo_videojuego.model.Distribuidor;
import com.lfte.catalogo_videojuego.repository.DistribuidorRepository;
import com.lfte.catalogo_videojuego.service.DistribuidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidorServiceImpl implements DistribuidorService {

    @Autowired
    private DistribuidorRepository distribuidorRepository;
    @Override
    public List<Distribuidor> findAll() {
        return distribuidorRepository.findAll();
    }

    @Override
    public Distribuidor findById(long id) {
        Optional<Distribuidor> optional = distribuidorRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
        }
        return optional.get();
    }

    @Override
    public Distribuidor save(Distribuidor distribuidor) {
        return distribuidorRepository.save(distribuidor);
    }

    @Override
    public Distribuidor update(Distribuidor distribuidor) {
        return distribuidorRepository.save(distribuidor);
    }

    @Override
    public boolean delete(long id) {
        Optional<Distribuidor> optional = distribuidorRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        distribuidorRepository.deleteById(id);
        return true;
    }
}
