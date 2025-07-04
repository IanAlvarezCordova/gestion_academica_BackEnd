package com.example.gestion_academica.controladores;

import com.example.gestion_academica.modelos.Asignatura;
import com.example.gestion_academica.servicios.AsignaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AsignaturaControlador {
    @Autowired
    private AsignaturaServicio servicio;

    @GetMapping
    public List<Asignatura> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura asignatura) {
        return servicio.guardar(asignatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerPorId(@PathVariable Long id) {
        Asignatura asignatura = servicio.obtenerPorId(id);
        return asignatura != null ? ResponseEntity.ok(asignatura) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        Asignatura actualizado = servicio.actualizar(id, asignatura);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}