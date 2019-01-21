package com.infocarte.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El username es unico, no se puede repetir, el tamaño maximo es de 30 caracteres
    @Column(length = 30, unique = true)
    private String username;

    // El tamaño maximo es de 60 caracteres
    @Column(length = 60)
    private String password;

    private Boolean enabled;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Rol> roles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cartelera> cartelerasPublicadas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="usuario_cartelera",
            joinColumns = { @JoinColumn(name="usuario_id", referencedColumnName="id") },
            inverseJoinColumns = { @JoinColumn(name="cartelera_id", referencedColumnName="id") } )
    private List<Cartelera> cartelerasLikeadas;

    // Constructor
    public Usuario() {
        this.roles = new ArrayList<Rol>();
        this.cartelerasPublicadas = new ArrayList<Cartelera>();
        this.cartelerasLikeadas = new ArrayList<Cartelera>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Cartelera> getCartelerasPublicadas() {
        return cartelerasPublicadas;
    }

    public void setCartelerasPublicadas(List<Cartelera> carteleras) {
        this.cartelerasPublicadas = carteleras;
    }

    public List<Cartelera> getCartelerasLikeadas() {
        return cartelerasLikeadas;
    }

    public void setCartelerasLikeadas(List<Cartelera> cartelerasLikeadas) {
        this.cartelerasLikeadas = cartelerasLikeadas;
    }

}
