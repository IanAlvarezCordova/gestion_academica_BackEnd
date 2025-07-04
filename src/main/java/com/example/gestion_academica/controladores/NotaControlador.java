package com.example.gestion_academica.controladores;

import com.example.gestion_academica.modelos.Nota;
import com.example.gestion_academica.servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotaControlador {
    @Autowired
    private NotaServicio servicio;

    @GetMapping
    public List<Nota> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public Nota crear(@RequestBody Nota nota) {
        return servicio.guardar(nota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerPorId(@PathVariable Long id) {
        Nota nota = servicio.obtenerPorId(id);
        return nota != null ? ResponseEntity.ok(nota) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizar(@PathVariable Long id, @RequestBody Nota nota) {
        Nota actualizado = servicio.actualizar(id, nota);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}