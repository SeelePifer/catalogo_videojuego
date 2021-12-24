package com.lfte.catalogo_videojuego.controller;

import com.lfte.catalogo_videojuego.model.Desarrollador;
import com.lfte.catalogo_videojuego.service.DesarrolladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/desarrollador")
public class DesarrolladorController {

    @Autowired
    DesarrolladorService desarrolladorService;


    @GetMapping
    public ResponseEntity<List<Desarrollador>> listar(){
        List<Desarrollador> desarrolladores= desarrolladorService.findAll();
        return new ResponseEntity<List<Desarrollador>>(desarrolladores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desarrollador>listarPorId(@PathVariable("id") long id){
        Desarrollador obj = desarrolladorService.findById(id);
        return new ResponseEntity<Desarrollador>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Desarrollador desarrollador){
        Desarrollador obj = desarrolladorService.save(desarrollador);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(desarrollador.getIdDesarrollador()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Desarrollador> modificar (@Valid @RequestBody Desarrollador desarrollador){
        Desarrollador obj = desarrolladorService.save(desarrollador);
        return new ResponseEntity<Desarrollador>(obj, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminar (@PathVariable("id") long id) throws Exception {
        desarrolladorService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
