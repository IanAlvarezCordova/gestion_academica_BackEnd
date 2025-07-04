//File: /src/main/java/com/example/gestion_academica/modelos/Nota.java
package com.example.gestion_academica.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id")
    @JsonBackReference(value = "alumno-nota")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id")
    @JsonBackReference(value = "asignatura-nota")
    private Asignatura asignatura;

    public Nota() {}

    public Nota(Double calificacion, Alumno alumno, Asignatura asignatura) {
        this.calificacion = calificacion;
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getCalificacion() { return calificacion; }
    public void setCalificacion(Double calificacion) { this.calificacion = calificacion; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }
}