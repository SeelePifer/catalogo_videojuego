package com.lfte.catalogo_videojuego.controller;

import com.lfte.catalogo_videojuego.model.Distribuidor;
import com.lfte.catalogo_videojuego.service.DistribuidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/distribuidor")
public class DistribuidorController {

    @Autowired
    DistribuidorService distribuidorService;


    @GetMapping
    public ResponseEntity<List<Distribuidor>> listar(){
        List<Distribuidor> distribuidor= distribuidorService.findAll();
        return new ResponseEntity<List<Distribuidor>>(distribuidor, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distribuidor>listarPorId(@PathVariable("id") long id){
        Distribuidor obj = distribuidorService.findById(id);
        return new ResponseEntity<Distribuidor>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Distribuidor distribuidor){
        Distribuidor obj = distribuidorService.save(distribuidor);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(distribuidor.getIdDistribuidor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Distribuidor> modificar (@Valid @RequestBody Distribuidor distribuidor){
        Distribuidor obj = distribuidorService.save(distribuidor);
        return new ResponseEntity<Distribuidor>(obj, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminar (@PathVariable("id") long id) throws Exception {
        distribuidorService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }



}
