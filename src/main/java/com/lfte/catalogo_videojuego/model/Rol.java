package com.lfte.catalogo_videojuego.model;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idRol;

    @Column(name = "nombre")
    private String nombre;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
