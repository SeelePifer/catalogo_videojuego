package com.lfte.catalogo_videojuego.service.impl;

import com.lfte.catalogo_videojuego.exception.ModeloNotFoundException;

import com.lfte.catalogo_videojuego.model.Usuarios;
import com.lfte.catalogo_videojuego.repository.UsuarioRepository;
import com.lfte.catalogo_videojuego.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService, UserDetailsService {
    @Autowired
    private UsuarioRepository usuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios findById(long id) {
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
        }
        return optional.get();
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios update(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public boolean delete(long id) {
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if(!optional.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        usuariosRepository.deleteById(id);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findOneByNombre(username);
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        UserDetails ud = new User(usuario.getNom_User(), usuario.getContraseña(), roles);
        return ud;
    }
}
