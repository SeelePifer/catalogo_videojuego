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
    private String nom_User;

    @ApiModelProperty(notes = "Contraseña tiene como mínimo 8 caracteres")
    @Column(name = "contraseña", length = 64)
    @Size(min = 8, max = 64, message = "El nombre debe tener un valor mayor a 3 digitos y menor a 64")
    private String contraseña;

    @Column(name = "correo")
    @Email(message = "Debe ser un email valido")
    private String correo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "consulta",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idVideojuego", referencedColumnName = "idVideojuego"))
    private List<Videojuego> videojuegos;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNom_User() {
        return nom_User;
    }

    public void setNom_User(String nom_User) {
        this.nom_User = nom_User;
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
}
