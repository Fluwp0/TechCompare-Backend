package com.techcompare.usuarios.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private String gpu1;
    private String gpu2;

    public Usuario() {}

    public Usuario(String nombre, String email, String password, String gpu1, String gpu2) {
        this.nombre   = nombre;
        this.email    = email;
        this.password = password;
        this.gpu1     = gpu1;
        this.gpu2     = gpu2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getGpu1() {
        return gpu1;
    }

    public void setGpu1(String gpu1) {
        this.gpu1 = gpu1;
    }

    public String getGpu2() {
        return gpu2;
    }

    public void setGpu2(String gpu2) {
        this.gpu2 = gpu2;
    }
}

