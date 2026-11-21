package com.ecommerce.auth.infraestructure.driver_adapters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
public class UsuarioData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUsuario;
    private String nombre;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String pass;
    private String role;
    private Integer edad;
    private String numeroTelefono;

    public UsuarioData(String idUsuario, String email, String nombre, String pass, String role, Integer edad, String numeroTelefono) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        this.role = role;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
    }

    public UsuarioData() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
