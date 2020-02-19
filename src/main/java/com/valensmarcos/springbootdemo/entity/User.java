package com.valensmarcos.springbootdemo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuari")
public class User {
    @Id
    @Column(name = "idusuari")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contrasenya")
    private String password;

    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "cognoms")
    private String secondName;

    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Publication> publications;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }
}
