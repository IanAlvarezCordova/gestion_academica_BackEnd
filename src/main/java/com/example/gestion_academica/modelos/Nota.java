//File: /src/main/java/com/example/gestion_academica/modelos/Nota.java
package com.example.gestion_academica.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

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

    private String descripcion;

    private LocalDate fecha;

    public Nota() {}

    public Nota(Long id, Double calificacion, Alumno alumno, Asignatura asignatura, String descripcion, LocalDate fecha) {
        this.id = id;
        this.calificacion = calificacion;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }


}