package com.lfte.catalogo_videojuego.controller;

import com.lfte.catalogo_videojuego.model.Usuarios;
import com.lfte.catalogo_videojuego.model.Videojuego;
import com.lfte.catalogo_videojuego.service.UsuariosService;
import com.lfte.catalogo_videojuego.service.VideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/videojuego")
public class VideojuegoController {
    @Autowired
    VideoJuegoService videoJuegoService;


    @GetMapping
    public ResponseEntity<List<Videojuego>> listar(){
        List<Videojuego> videojuego= videoJuegoService.findAll();
        return new ResponseEntity<List<Videojuego>>(videojuego, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego>listarPorId(@PathVariable("id") long id){
        Videojuego obj = videoJuegoService.findById(id);
        return new ResponseEntity<Videojuego>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Videojuego videojuego){
        Videojuego obj = videoJuegoService.save(videojuego);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(videojuego.getIdVideojuego()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Videojuego> modificar (@Valid @RequestBody Videojuego videojuego){
        Videojuego obj = videoJuegoService.save(videojuego);
        return new ResponseEntity<Videojuego>(obj, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminar (@PathVariable("id") long id) throws Exception {
        videoJuegoService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
