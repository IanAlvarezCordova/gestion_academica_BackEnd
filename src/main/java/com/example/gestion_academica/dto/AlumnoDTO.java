//File: /src/main/java/com/example/gestion_academica/dto/AlumnoDTO.java
package com.example.gestion_academica.dto;

public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    public AlumnoDTO() {}

    public AlumnoDTO(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}