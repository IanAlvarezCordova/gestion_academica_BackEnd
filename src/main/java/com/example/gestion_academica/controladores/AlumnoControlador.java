package com.example.gestion_academica.controladores;

import com.example.gestion_academica.modelos.Alumno;
import com.example.gestion_academica.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio servicio;

    @GetMapping
    public List<Alumno> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) {
        return servicio.guardar(alumno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
        Alumno alumno = servicio.obtenerPorId(id);
        return alumno != null ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno actualizado = servicio.actualizar(id, alumno);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}