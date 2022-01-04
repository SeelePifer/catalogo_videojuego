package com.lfte.catalogo_videojuego.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(description="Información de los usuarios")
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long idUsuario;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 5 caracteres")
    @Column(name = "nombres", length = 70)
    @Size(min = 5, max = 70, message = "El nombre debe tener un valor mayor a 5 digitos y menor a 70")
    private String nombre;

    @ApiModelProperty(notes = "Contraseña tiene como mínimo 8 caracteres")
    @Column(name = "contraseña", length = 64)
    @Size(min = 8, max = 64, message = "El nombre debe tener un valor mayor a 3 digitos y menor a 64")
    private String contraseña;

    @Column(name = "correo")
    @Email(message = "Debe ser un email valido")
    private String correo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "consulta",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_Videojuego", referencedColumnName = "idVideojuego"))
    private List<Videojuego> videojuegos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> roles;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNom_User() {
        return nombre;
    }

    public void setNom_User(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
