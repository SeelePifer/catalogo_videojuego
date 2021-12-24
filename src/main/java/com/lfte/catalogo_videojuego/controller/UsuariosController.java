package com.lfte.catalogo_videojuego.controller;



import com.lfte.catalogo_videojuego.model.Usuarios;
import com.lfte.catalogo_videojuego.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;


    @GetMapping
    public ResponseEntity<List<Usuarios>> listar(){
        List<Usuarios> usuarios= usuariosService.findAll();
        return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios>listarPorId(@PathVariable("id") long id){
        Usuarios obj = usuariosService.findById(id);
        return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Usuarios usuarios){
        Usuarios obj = usuariosService.save(usuarios);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarios.getIdUsuario()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Usuarios> modificar (@Valid @RequestBody Usuarios usuario){
        Usuarios obj = usuariosService.save(usuario);
        return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminar (@PathVariable("id") long id) throws Exception {
        usuariosService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
