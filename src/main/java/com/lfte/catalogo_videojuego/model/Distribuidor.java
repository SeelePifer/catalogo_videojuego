package com.lfte.catalogo_videojuego.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "distribuidor")
public class Distribuidor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idDistribuidor;

    @ApiModelProperty(notes = "Genero debe tener como minimo 5 caracteres")
    @Column(name = "genero", length = 70)
    @Size(min = 5, max = 70, message = "El genero debe tener un valor mayor a 5 digitos y menor a 70")
    private String nombre;

    public long getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(long idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
