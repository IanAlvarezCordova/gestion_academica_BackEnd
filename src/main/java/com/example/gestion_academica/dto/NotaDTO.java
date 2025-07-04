//File: /src/main/java/com/example/gestion_academica/dto/NotaDTO.java
package com.example.gestion_academica.dto;

public class NotaDTO {
    private Long id;
    private Double calificacion;
    private Long alumnoId;
    private Long asignaturaId;

    public NotaDTO() {}

    public NotaDTO(Long id, Double calificacion, Long alumnoId, Long asignaturaId) {
        this.id = id;
        this.calificacion = calificacion;
        this.alumnoId = alumnoId;
        this.asignaturaId = asignaturaId;
    }
    public NotaDTO(Long id, Double calificacion) {
        this.id = id;
        this.calificacion = calificacion;
    }


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getCalificacion() { return calificacion; }
    public void setCalificacion(Double calificacion) { this.calificacion = calificacion; }
    public Long getAlumnoId() { return alumnoId; }
    public void setAlumnoId(Long alumnoId) { this.alumnoId = alumnoId; }
    public Long getAsignaturaId() { return asignaturaId; }
    public void setAsignaturaId(Long asignaturaId) { this.asignaturaId = asignaturaId; }
}