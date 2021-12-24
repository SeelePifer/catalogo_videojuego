package com.lfte.catalogo_videojuego.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "desarrollador")
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idDesarrollador;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 5 caracteres")
    @Column(name = "nombre", length = 70)
    @Size(min = 5, max = 70, message = "El genero debe tener un valor mayor a 5 digitos y menor a 70")
    private String nombre;

    public long getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(long idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
