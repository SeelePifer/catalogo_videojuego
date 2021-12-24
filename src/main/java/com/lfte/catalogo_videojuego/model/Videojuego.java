package com.lfte.catalogo_videojuego.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long idVideojuego;

    @ApiModelProperty(notes = "La consola debe tener como minimo 5 caracteres")
    @Column(name = "consola", length = 20)
    @Size(min = 5, max = 20, message = "El consola debe tener un valor mayor a 5 digitos y menor a 20")
    private String consola;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 5 caracteres")
    @Column(name = "nombre", length = 70)
    @Size(min = 5, max = 70, message = "El consola debe tener un valor mayor a 5 digitos y menor a 70")
    private String nombre;

    @ApiModelProperty(notes = "Genero debe tener como minimo 5 caracteres")
    @Column(name = "genero", length = 70)
    @Size(min = 5, max = 70, message = "El genero debe tener un valor mayor a 5 digitos y menor a 70")
    private String genero;

    @ApiModelProperty(notes = "Clasificación debe tener como minimo 3 caracteres")
    @Column(name = "clasificacion", length = 70)
    @Size(min = 3, max = 70, message = "La clasificación debe tener un valor mayor a 5 digitos y menor a 70")
    private String clasificacion;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 5 caracteres")
    @Column(name = "descripcion", length = 250)
    @Size(min = 1, max = 250, message = "El nombre debe tener un valor mayor a 5 digitos y menor a 250")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "fk_desarrollador", nullable = false, foreignKey = @ForeignKey(name = "FK_desarrollador"))
    private Desarrollador desarrollador;

    @ManyToOne
    @JoinColumn(name = "fk_distribuidor", nullable = false, foreignKey = @ForeignKey(name = "FK_distribuidor"))
    private Distribuidor distribuidor;

    public long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(long idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }
}
